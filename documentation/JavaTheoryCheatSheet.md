# Java Theory Interview Cheat Sheet

This cheat sheet covers key concepts and example questions across the most common Java topics, helping you prepare for your interview.

---

## 1. **Object-Oriented Programming (OOP) Concepts**

### Key Topics:
- **Encapsulation**
- **Inheritance**
- **Polymorphism**
- **Abstraction**

### Sample Questions:
- **Q: What is Encapsulation?**
    - **A:** Encapsulation is the practice of wrapping the data (variables) and code (methods) together as a single unit. It restricts direct access to some of the object’s components, which can be done by making fields private and using getters/setters.

- **Q: What is Polymorphism?**
    - **A:** Polymorphism allows one interface to be used for a general class of actions. The specific action is determined by the exact nature of the situation. It can be achieved through method overloading and method overriding.

---

## 2. **Memory Management**

### Key Topics:
- **Heap vs Stack Memory**
- **Garbage Collection**

### Sample Questions:
- **Q: How does Java handle memory management?**
    - **A:** Java uses an automatic memory management system known as Garbage Collection, which reclaims memory from objects no longer in use.

- **Q: What is the difference between Stack and Heap memory in Java?**
    - **A:** Stack memory is used for static memory allocation (method calls, local variables), while heap memory is used for dynamic memory allocation (objects).

---

## 3. **Exception Handling**

### Key Topics:
- **Checked vs Unchecked Exceptions**
- **Try-Catch Blocks**
- **Throw and Throws Keywords**

### Sample Questions:
- **Q: What is the difference between checked and unchecked exceptions?**
    - **A:** Checked exceptions are checked at compile-time (e.g., `IOException`), while unchecked exceptions (like `NullPointerException`) occur at runtime.

- **Q: What happens if an exception is not handled in a program?**
    - **A:** If an exception is not handled, it propagates up the call stack and, if still unhandled, causes the program to terminate abnormally.

---

## 4. **Multithreading and Concurrency**

### Key Topics:
- **Thread Lifecycle**
- **Synchronized Blocks**
- **Executor Framework**

### Sample Questions:
- **Q: What is a thread in Java?**
    - **A:** A thread is a lightweight process that enables concurrent execution of tasks. In Java, threads can be created by implementing the `Runnable` interface or extending the `Thread` class.

- **Q: What is synchronization in Java?**
    - **A:** Synchronization is a mechanism to control the access of multiple threads to shared resources to prevent data inconsistency. It can be achieved using synchronized methods or blocks.

---

## 5. **Collections Framework**

### Key Topics:
- **List, Set, Map Interfaces**
- **ArrayList vs LinkedList**
- **HashMap vs TreeMap**

### Sample Questions:
- **Q: What is the difference between `ArrayList` and `LinkedList`?**
    - **A:** `ArrayList` is backed by a dynamic array, offering O(1) access but slower inserts and deletes. `LinkedList` is backed by a doubly-linked list, providing O(1) insertions and deletions but O(n) access time.

- **Q: What is the difference between `HashMap` and `TreeMap`?**
    - **A:** `HashMap` offers constant-time performance for basic operations like get and put, but does not maintain any order. `TreeMap` guarantees that keys are always sorted.

---

## 6. **Java 8 Features**

### Key Topics:
- **Lambda Expressions**
- **Streams API**
- **Functional Interfaces**

### Sample Questions:
- **Q: What are lambda expressions?**
    - **A:** Lambda expressions provide a clear and concise way to implement single-method interfaces (functional interfaces) using an expression rather than an entire class.

- **Q: What is the Streams API?**
    - **A:** The Streams API allows for functional-style operations on collections, making it easier to process sequences of elements, such as filtering, mapping, and reducing.

---

## 7. **Design Patterns**

### Key Topics:
- **Singleton Pattern**
- **Factory Pattern**
- **Observer Pattern**

### Sample Questions:
- **Q: What is the Singleton design pattern?**
    - **A:** The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

- **Q: When would you use the Factory design pattern?**
    - **A:** The Factory pattern is used when the exact type of object to be created is determined dynamically at runtime.

---

## 8. **JVM Architecture**

### Key Topics:
- **ClassLoader**
- **JIT Compiler**
- **JVM Memory Structure**

### Sample Questions:
- **Q: What is the role of the ClassLoader in Java?**
    - **A:** The ClassLoader loads class files into the JVM during runtime, facilitating the dynamic loading of classes. It uses a delegation model where each class loader delegates the responsibility of loading a class to its parent before attempting to load it itself.

- **Q: What is Just-In-Time (JIT) compilation in Java?**
    - **A:** JIT compilation converts bytecode into native machine code at runtime to improve performance. The JVM identifies frequently executed code segments (hot spots) and compiles them, reducing the overhead of interpretation.

- **Q: What is Garbage Collection in Java, and how does it work?**
    - **A:** Garbage Collection is an automatic memory management feature of the JVM that reclaims memory from objects that are no longer in use. The most common algorithm is Mark-and-Sweep, where live objects are marked, and unused objects are removed.

---

## 9. **Generics**

### Key Topics:
- **Type Safety**
- **Wildcard Types**

### Sample Questions:
- **Q: What are generics in Java?**
    - **A:** Generics enable types (classes and methods) to operate on objects of various types while providing compile-time type safety.

- **Q: What is a wildcard in generics?**
    - **A:** The wildcard (`?`) is used in generics to represent an unknown type. It can be used to specify upper bounds (`? extends T`) or lower bounds (`? super T`).

---

## 10. **Immutability and Strings**

### Key Topics:
- **String Pool**
- **Why Strings are Immutable**

### Sample Questions:
- **Q: Why are Strings immutable in Java?**
    - **A:** Strings are immutable to improve security, performance (String pool), and thread safety. Once created, a String cannot be altered, ensuring its value remains consistent throughout the program.

- **Q: How is memory managed for Strings in Java?**
    - **A:** Java uses a string pool to manage memory for string literals. When a string is created, the JVM checks the pool, and if the string exists, it reuses the object, otherwise, it creates a new one.

---

## 11. **Annotations and Reflection**

### Key Topics:
- **Built-in Annotations (e.g., @Override, @Deprecated)**
- **Custom Annotations**
- **Reflection API**

### Sample Questions:
- **Q: What are annotations in Java?**
    - **A:** Annotations provide metadata about the program to the compiler and JVM. Built-in annotations like `@Override` and `@Deprecated` help the compiler validate code at compile-time.

- **Q: What is reflection in Java?**
    - **A:** Reflection allows Java code to inspect and manipulate classes, methods, and fields at runtime, providing flexibility for dynamic behavior.

---

## 12. **SOLID Principles**

### Key Topics:
- **Single Responsibility Principle**
- **Open/Closed Principle**
- **Dependency Inversion Principle**

### Sample Questions:
- **Q: What is the Single Responsibility Principle (SRP)?**
    - **A:** SRP states that a class should have only one reason to change, meaning it should only have one job or responsibility.

- **Q: What is the Open/Closed Principle (OCP)?**
    - **A:** OCP states that software entities (classes, modules, functions) should be open for extension but closed for modification.

---

## 13. **Miscellaneous Topics**

### Key Topics:
- **Enum Types**
- **Marker Interfaces**
- **JDBC Overview**
- **SerialVersionUID**

### Sample Questions:
- **Q: What is `serialVersionUID`?**
    - **A:** `serialVersionUID` is a unique identifier used during the deserialization process to ensure that a loaded class is compatible with the serialized object.