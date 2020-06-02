import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class GuavaCacheDemo {
    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder
                .newBuilder().
                        initialCapacity(100)
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        cache.put("key1","val1");
        String value = cache.getIfPresent("key1");
        System.out.println(value);

    }
}
