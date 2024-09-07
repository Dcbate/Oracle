# 📘 HashMap in Java

## 📝 Overview
`HashMap` is part of Java's `java.util` package, providing an **unordered** collection that stores **key-value pairs**. It implements the **Map interface**, allowing keys to map to values.

- **No duplicates:** A key can appear only once in the map.
- **One null key allowed**; multiple null values are permitted.
- Provides constant-time performance for basic operations (get and put), assuming the hash function disperses elements properly among the buckets.

## 🧩 Key Features
- **Not synchronized** (needs external synchronization for thread safety).
- **Constant time complexity** `O(1)` for basic operations like adding, removing, or checking an element.
- **Non-ordered**, meaning insertion order is **not preserved**.
- Suitable for **large datasets** where constant-time performance is crucial.

## 📚 Class Definition

```java
import java.util.HashMap;
import java.util.Map;


public class Example {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> map = new HashMap<>();
        
        // Adding key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Retrieving value by key
        System.out.println("Apple value: " + map.get("Apple"));

        // Removing a key-value pair
        map.remove("Banana");

        // Iterating over keys
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}
```

## 🚀 Common Methods

| **Method**                              | **Description**                                |
|-----------------------------------------|------------------------------------------------|
| `put(K key, V value)`                   | Inserts the key-value pair.                    |
| `get(Object key)`                       | Returns the value associated with the key.     |
| `remove(Object key)`                    | Removes the key-value pair.                    |
| `containsKey(Object key)`               | Returns `true` if the map contains the key.    |
| `containsValue(Object value)`           | Returns `true` if the map contains the value.  |
| `keySet()`                              | Returns a set view of the keys.                |
| `size()`                                | Returns the number of key-value pairs.         |
| `isEmpty()`                             | Returns `true` if the map is empty.            |

## ⚙️ How HashMap Works
1. **Hashing**: Uses the `hashCode()` method to compute the bucket index for each key.
2. **Buckets**: HashMap divides the data into buckets to handle **collisions**, where multiple keys hash to the same index.
3. **Rehashing**: When the number of entries exceeds the capacity * load factor (default load factor is 0.75), the capacity is **doubled**, and the entries are redistributed across new buckets.

## 🔐 Important Notes
- To make a `HashMap` **thread-safe**, use `Collections.synchronizedMap`.
- The **time complexity** for basic operations is `O(1)`, but this can degrade to `O(n)` in cases of excessive collisions.

## 🎯 When to Use HashMap?
- Use when you need **fast access** to key-value pairs.
- Suitable when **order** of entries is **not important**.
- Ideal for **caching** or **lookup tables**, where retrieval speed is essential.