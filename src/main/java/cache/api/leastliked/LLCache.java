package cache.api.leastliked;

import cache.api.leastliked.model.Car;

public interface LLCache {
  void put(String uuid, Car data) throws Exception;
  Car get(String uuid);
}
