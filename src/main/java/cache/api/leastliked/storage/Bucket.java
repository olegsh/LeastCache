package cache.api.leastliked.storage;

import cache.api.leastliked.model.Car;

import java.util.*;

public class Bucket {
  private static Bucket instance = new Bucket();
  private Map<String, Car> storage;
  Deque<String> queue;
  private final int MAX_SIZE = 3;

  public static Bucket getInstance() {
    // bucket should never be equal to null, but just in case...
    if(instance == null) {
      instance = new Bucket();
    }
    return instance;
  }

  private Bucket() {
    this.storage = new HashMap<>(MAX_SIZE);
    this.queue = new LinkedList<>();
  }

  public int getMaxSize() {
    return this.MAX_SIZE;
  }

  public Map<String, Car> getStorage() {
    return this.storage;
  }

  public Deque<String> getQueue() {
    return this.queue;
  }
}
