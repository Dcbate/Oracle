
# Cheat Sheet: Adding Caches in Java Spring with Caffeine🚀

---

## 1️⃣ Add Dependencies in Gradle

Include the required dependencies in your `build.gradle` file:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-cache'
implementation 'com.github.ben-manes.caffeine:caffeine:3.1.8'
```

**💡 Why?**
- `spring-boot-starter-cache`: Provides Spring's caching abstraction.
- `caffeine`: High-performance in-memory caching library.

---

## 2️⃣ Enable Caching in Your Application

Annotate your main application class with `@EnableCaching` to activate Spring's cache abstraction.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}
```

**💡 Why?**  
This enables Spring to handle caching annotations like `@Cacheable` and `@CacheEvict`.

---

## 3️⃣ Configure Multiple Caches

Create a `CacheConfig` class to define multiple caches and their expiration policies.

```java
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class CacheConfig {

    // Configure cache with 7-day expiration
    @Bean
    public Caffeine<Object, Object> weeklyCacheConfig() {
        return Caffeine.newBuilder()
                .expireAfterWrite(7, TimeUnit.DAYS);
    }

    // Configure cache with 1-day expiration
    @Bean
    public Caffeine<Object, Object> dailyCacheConfig() {
        return Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS);
    }

    // CacheManager for handling multiple caches
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("weeklyCache", "dailyCache");
        cacheManager.setCaffeine(weeklyCacheConfig()); // Default configuration
        return cacheManager;
    }
}
```

**💡 Why?**  
Different cache configurations allow for varying expiration policies to meet different use cases.

---

## 4️⃣ Use `@Cacheable` and Understand How It Works Under the Hood

### Using `@Cacheable`

Annotate your service methods with `@Cacheable` to specify caching behavior.

```java
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YourService {

    @Cacheable("weeklyCache")
    public String getWeeklyData(String key) {
        // Simulate a time-consuming operation
        return "Weekly data for " + key;
    }

    @Cacheable("dailyCache")
    public String getDailyData(String key) {
        // Simulate a different use case
        return "Daily data for " + key;
    }
}
```

---

### How It Works Under the Hood:

1. **Cache Interception**:
    - Spring intercepts the method call using a proxy.
    - It generates a **key** from the method arguments.

2. **Key Lookup**:
    - Spring checks the cache (e.g., `weeklyCache`) for the generated key.
    - If the key exists:
        - The cached value is returned.
    - If the key doesn't exist:
        - The method is executed, and the result is stored in the cache.

3. **Cache Storage**:
    - Internally, the cache is a **key-value store** (like a hash table).
    - Example:
      ```json
      "weeklyCache": {
          "key1": "Weekly data for key1",
          "key2": "Weekly data for key2"
      }
      ```

4. **Expiration**:
    - Caffeine tracks the timestamp for each entry.
    - When the `expireAfterWrite` duration is reached, the entry is automatically removed.

5. **Optimization**:
    - Caffeine uses **Window TinyLFU** to evict least-used entries when the cache size limit is reached.
    - Segmentation reduces contention for multi-threaded applications.

---

## 5️⃣ Expose an API to Clear Caches

Create a REST controller to clear caches programmatically using `@CacheEvict`.

```java
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CacheController {

    private final CacheManager cacheManager;

    // Clear a specific cache
    @DeleteMapping("/api/cache/clear")
    public String clearCache(@RequestParam String cacheName) {
        if (cacheManager.getCache(cacheName) != null) {
            cacheManager.getCache(cacheName).clear();
            return "Cache " + cacheName + " cleared!";
        } else {
            return "Cache " + cacheName + " not found.";
        }
    }
}
```

**💡 Why?**
- Provides an easy way to manage caches dynamically via an API.
- Can be extended for admin or monitoring use cases.

---

## Summary of Key Concepts:

| **Annotation**       | **Purpose**                                                  |
|-----------------------|-------------------------------------------------------------|
| `@Cacheable`          | Caches the result of a method based on its arguments.       |
| `@CacheEvict`         | Clears specific entries or all entries from a cache.        |
| `@EnableCaching`      | Enables Spring's caching abstraction.                       |
| `@RequiredArgsConstructor` | Ensures dependency injection using final fields.        |

**Caching Workflow**:
1. Use `@Cacheable` to cache expensive computations.
2. Configure Caffeine for fine-grained control over expiration and eviction.
3. Expose APIs for managing caches dynamically when needed.
