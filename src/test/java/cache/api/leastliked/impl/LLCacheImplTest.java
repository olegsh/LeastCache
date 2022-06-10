package cache.api.leastliked.impl;

import cache.api.leastliked.LLCache;
import cache.api.leastliked.model.Body;
import cache.api.leastliked.model.Car;
import cache.api.leastliked.model.Drive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LLCacheImplTest {

  @Test
  void queueTester() {
    Car mazda = new Car("white", "a0bc50a1-b2e9-4542-b591-acbbfc1f926b",
        Body.SEDAN, Drive.FWD, "mazda", "mazda3", 2022);
    Car mazda2 = new Car("gray", "be8e6845-6173-43d8-bb8c-d6916cd969ee",
        Body.SUV, Drive.AWD, "mazda", "cx-50", 2022);
    Car honda = new Car("red", "7edc3426-abff-4956-b523-d956e0f5c033",
        Body.SUV, Drive.AWD, "honda", "CR-V", 2021);
    Car honda2 = new Car("green", "53d0f64b-8a7c-4e1b-855d-349d6bd6dd4d",
        Body.TRUCK, Drive.AWD, "honda", "ridgeline", 2020);
    Car vw = new Car("white", "f53d90db-d1cb-44a0-a0bd-aba4767b7940",
        Body.SEDAN, Drive.FWD, "vw", "jetta", 2018);
    Car audi = new Car("white", "35f25cd3-3843-44b2-af84-c4f14405a766",
        Body.STATIONWAGON, Drive.AWD, "audi", "avant", 2022);

    LLCache cache = new LLCacheImpl();
    try {
      cache.put("a0bc50a1-b2e9-4542-b591-acbbfc1f926b", mazda);
      cache.put("be8e6845-6173-43d8-bb8c-d6916cd969ee", mazda2);
      cache.put("7edc3426-abff-4956-b523-d956e0f5c033", honda);

      cache.get("be8e6845-6173-43d8-bb8c-d6916cd969ee");

      cache.put("53d0f64b-8a7c-4e1b-855d-349d6bd6dd4d", honda2);
      cache.put("f53d90db-d1cb-44a0-a0bd-aba4767b7940", vw);
      cache.put("35f25cd3-3843-44b2-af84-c4f14405a766", audi);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}