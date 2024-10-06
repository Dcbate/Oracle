# Java 17 Features Overview 🖥️

---

## 🌟 **1. Pattern Matching for `switch` (Preview)**

Java 17 introduces pattern matching in `switch` statements. This feature simplifies complex `switch` logic by allowing you to match patterns directly.

🔍 **Benefits**:
- Cleaner and more readable `switch` statements.
- Avoids boilerplate code when casting.

```java
public static String formattedValue(Object obj) {
    return switch (obj) {
        case Integer i -> String.format("int %d", i);
        case Long l    -> String.format("long %d", l);
        case Double d  -> String.format("double %f", d);
        case String s  -> String.format("String %s", s);
        default        -> obj.toString();
    };
}
```
---

## 🔒 **2. Sealed Classes**

Sealed classes restrict which other classes can extend or implement them, allowing more control over class hierarchies.

🔍 **Benefits**:
- Provides better control over inheritance.
- Can define closed sets of related classes.


```java
public abstract sealed class Shape
    permits Circle, Square {
}

public final class Circle extends Shape { }
public final class Square extends Shape { }
```
---

## 🧵 **3. Enhanced `Stream.toList()` Method**

Java 17 introduces a simple, concise way to collect streams into a list using `Stream.toList()`.

🔍 **Benefits**:
- No need to use `Collectors.toList()`.
- Provides a concise, immutable list.
```java
List<String> names = Stream.of("Alice", "Bob", "Charlie").toList();
```

---

