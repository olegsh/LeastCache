# Stage 1 (create a build image)
FROM openjdk:17-alpine AS builder
RUN java --version

COPY . /usr/src/cacher
WORKDIR /usr/src/cacher

RUN apk --no-cache add maven && mvn --version
RUN mvn package

# Stage 2
FROM openjdk:17-oracle
WORKDIR /root/
COPY --from=builder /usr/src/cacher/target/app.jar .

EXPOSE 8123
ENTRYPOINT ["java", "-jar", "./app.jar"]
