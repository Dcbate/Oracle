# Java 21 Features Overview 🚀

Java 21 is the latest release packed with new enhancements, language improvements, and performance optimizations. This LTS version builds on previous updates, introducing exciting features to make Java more modern, concise, and developer-friendly.

---

## 🌟 **1. String Templates (Preview)**

Java 21 introduces **String Templates**, allowing for embedded expressions in string literals, which can be processed at runtime. This makes string formatting more readable and concise.

### Example:
```java
int age = 25;
String message = STR."He is {age} years old.";
System.out.println(message); // Output: He is 25 years old.
```

---

## 🔄 **2. Sequenced Collections**

Java 21 introduces **Sequenced Collections**, a new interface that extends both `List` and `Set` interfaces, offering a consistent way to handle collections that have a well-defined encounter order.

🔍 **Benefits**:
- Easier manipulation of collections in a sequence.
- Unified API for ordered collections.


```java
SequencedSet<String> sequencedSet = new LinkedHashSet<>();
sequencedSet.add("A");
sequencedSet.add("B");
sequencedSet.add("C");

sequencedSet.reversed().forEach(System.out::println); // Outputs: C, B, A
```
---

## 🧑‍💻 **3. Virtual Threads (Preview)**

Java 21 continues improving **Virtual Threads** (introduced in Java 19) as part of Project Loom. Virtual Threads make it easy to write scalable concurrent applications without managing thread pools.

🔍 **Benefits**:
- Simplified concurrency.
- Lightweight threads that reduce overhead.
```java

try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    List<Future<String>> results = executor.invokeAll(List.of(
        () -> "Task 1",
        () -> "Task 2"
    ));
    results.forEach(result -> System.out.println(result.get()));
}
```