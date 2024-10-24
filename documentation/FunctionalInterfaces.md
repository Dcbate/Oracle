# Java Functional Interfaces: `Predicate`, `Consumer`, `Supplier`, and `Function`

Java 8 introduced the concept of **functional interfaces** in the `java.util.function` package to support lambda expressions. These interfaces allow you to treat behavior as a parameter, making it easier to create functional-style programming in Java.

Let's dive into the four commonly used functional interfaces: `Predicate`, `Consumer`, `Supplier`, and `Function`.

---

## 1. **Predicate**

### Definition
The `Predicate<T>` interface represents a **single-argument function** that returns a boolean value. It is commonly used to evaluate a condition based on the input provided.

```java
boolean test(T t);
```

The `test()` method evaluates the condition defined by the `Predicate` and returns `true` or `false`.

### Example Use Case
`Predicate` can be used to filter a collection, such as filtering out even numbers from a list of integers.

### Example
```java
Predicate<Integer> isEven = num -> num % 2 == 0;
System.out.println(isEven.test(4));  // Output: true
System.out.println(isEven.test(3));  // Output: false
```

### Common Use
- Filtering collections
- Conditional checks

---

## 2. **Consumer**

### Definition
The `Consumer<T>` interface defines an operation that **accepts a single input argument** and returns no result. It is typically used for operations where you want to perform an action on a given input, like logging, printing, or modifying an object.

### Key Method
```java
void accept(T t);
```

### Example Use Case
`Consumer` can be used to perform an operation like printing each element of a list.

### Example
```java
Consumer<String> printName = name -> System.out.println("Hello, " + name);
printName.accept("Alice");  // Output: Hello, Alice
```

### Common Use
- Printing values
- Applying side effects (e.g., updating database, sending data over network)

---

## 3. **Supplier**

### Definition
The `Supplier<T>` interface represents a function that takes **no input** and provides a result of type `T`. It is commonly used when you need to generate or supply values, such as a factory method or a lazy initialization.

### Key Method
```java
T get();
```

### Example Use Case
`Supplier` is useful for lazy loading, where you want to delay the creation of a resource until it's actually needed.

### Example
```java
Supplier<Double> randomValue = () -> Math.random();
System.out.println(randomValue.get());  // Output: Random number
```

### Common Use
- Generating values (e.g., random number generation)
- Lazy evaluation

---

## 4. **Function**

### Definition
The `Function<T, R>` interface represents a **single-argument function** that produces a result. The input argument type is `T` and the result type is `R`. This interface is mainly used for data transformation or mapping one type to another.

### Key Method
```java
R apply(T t);
```

### Example Use Case
`Function` can be used to convert or transform data, such as mapping an integer to its string representation.

### Example
```java
Function<Integer, String> intToString = num -> "Number: " + num;
System.out.println(intToString.apply(5));  // Output: Number: 5
```

### Common Use
- Data transformation
- Mapping values (e.g., converting data types)

---

## Comparison of Interfaces

| Interface        | Method       | Input Type      | Return Type   | Purpose                    |
|------------------|--------------|-----------------|---------------|----------------------------|
| **Predicate<T>**  | `test()`     | `T`             | `boolean`     | Evaluates a condition on the input |
| **Consumer<T>**   | `accept()`   | `T`             | `void`        | Performs an action on the input    |
| **Supplier<T>**   | `get()`      | None            | `T`           | Supplies a result                |
| **Function<T, R>**| `apply()`    | `T`             | `R`           | Transforms input to output         |

---

## Chaining Functional Interfaces

One of the strengths of these functional interfaces is that they can be easily chained using default methods. For example:

- `Predicate` has methods like `and()`, `or()`, and `negate()` for combining multiple predicates.
- `Consumer` has `andThen()` to chain multiple actions.
- `Function` has methods like `andThen()` and `compose()` to chain transformations.

### Example: Chaining `Predicate`
```java
Predicate<Integer> isEven = num -> num % 2 == 0;
Predicate<Integer> isPositive = num -> num > 0;

Predicate<Integer> isPositiveAndEven = isEven.and(isPositive);
System.out.println(isPositiveAndEven.test(4));  // Output: true
System.out.println(isPositiveAndEven.test(-4)); // Output: false
```

---

## Conclusion

The `Predicate`, `Consumer`, `Supplier`, and `Function` interfaces are foundational for functional programming in Java. They provide simple, reusable building blocks for processing data, checking conditions, and performing actions. Mastering these interfaces allows you to write cleaner, more expressive, and functional code in Java.

