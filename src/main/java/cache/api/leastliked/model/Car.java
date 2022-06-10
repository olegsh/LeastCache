package cache.api.leastliked.model;

import java.util.Objects;

public class Car {
  private String color;
  private String vin;
  private Body bodyType;
  private Drive driveType;
  private String make;
  private String model;
  private int year;

  public Car() {
    this.color = null;
    this.vin = null;
    this.bodyType = null;
    this.driveType = null;
    this.make = null;
    this.model = null;
    this.year = -1;
  }

  public Car(String color, String vin, Body bodyType, Drive driveType, String make, String model, int year ) {
    this.color = color;
    this.vin = vin;
    this.bodyType = bodyType;
    this.driveType = driveType;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public String getVin() {
    return vin;
  }

  public Body getBodyType() {
    return bodyType;
  }

  public Drive getDriveType() {
    return driveType;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Car)) return false;
    Car car = (Car) o;
    return year == car.year &&
        color.equals(car.color) &&
        vin.equals(car.vin) &&
        bodyType == car.bodyType &&
        driveType == car.driveType &&
        make.equals(car.make) &&
        model.equals(car.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, vin, bodyType, driveType, make, model, year);
  }

  @Override
  public String toString() {
    return "Car{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", vin='" + vin + '\'' +
        ", color='" + color + '\'' +
        ", vin='" + vin + '\'' +
        ", bodyType=" + bodyType +
        ", driveType=" + driveType +
        ", year=" + year +
        '}';
  }
}
