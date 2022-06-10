package cache.api.leastliked.impl;

import cache.api.leastliked.LLCache;
import cache.api.leastliked.model.Car;
import cache.api.leastliked.storage.Bucket;
import org.apache.log4j.Logger;

public class LLCacheImpl implements LLCache {
  private static Logger logger = Logger.getLogger(LLCacheImpl.class);
  private Bucket bucket = Bucket.getInstance();

  /**
   * @param uuid
   * @param data
   */
  @Override
  public void put(String uuid, Car data) throws Exception {
    if (uuid.isEmpty() || data == null) {
      throw new Exception("Invalid data entered");
    }
    if (bucket.getStorage().size() >= bucket.getMaxSize()) {
      // remove from queue
      String vin = bucket.getQueue().removeFirst();
      // remove this from storage
      bucket.getStorage().remove(vin);
    }
    bucket.getQueue().add(uuid);
    bucket.getStorage().put(uuid, data);
  }

  /**
   * @param uuid
   * @return
   */
  @Override
  public Car get(String uuid) {
    Car element = bucket.getStorage().get(uuid);
    if (element != null) {
      bucket.getQueue().remove(uuid);
      bucket.getQueue().add(uuid);
      return element;
    }
    return null;
  }
}
