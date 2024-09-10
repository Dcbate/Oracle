# 📚 Heap vs Stack in Java

When it comes to Java memory management, the **Heap** and **Stack** play a crucial role in how objects and variables are stored during the execution of a program. Let’s dive into both concepts to understand how they work:

## 🔹 Stack Memory

### Overview
The **Stack** is used for static memory allocation and the execution of threads. It stores primitive data types and references to objects in the heap.

- **LIFO (Last In, First Out)**: The stack follows this structure, meaning the last method called is the first one to finish.
- **Smaller in size** compared to the heap.
- **Thread-specific**: Each thread has its own stack, which makes it safer for concurrent execution.

### What is Stored in the Stack?
1. **Primitive Data Types** (e.g., `int`, `char`, `boolean`, etc.)
2. **Method Call Frames** (local variables, method calls)
3. **References to objects** (which are actually stored in the heap)

### Example
```java
public class Example {
    public static void main(String[] args) {
        int a = 5;     // Stored in Stack
        String name = "Java";  // Reference to String object in Heap
    }
}
```
In the above example:
	•	a = 5 is stored directly in the stack.
	•	name is a reference stored in the stack, while the actual String object resides in the heap.

### Pros of Stack:
- **Fast access**: Stack is faster to access compared to heap because of its LIFO structure.
- **Automatically managed**: Stack memory is automatically cleared when a method returns, which reduces the chances of memory leaks.

### Cons of Stack:
- **Size limitation**: The stack has limited size. A large number of method calls or deep recursion can lead to a **StackOverflowError**.

## 🔹 Heap Memory

### Overview
The **Heap** is used for dynamic memory allocation. This is where objects and their corresponding instance variables are stored. Unlike the stack, the heap is shared across all threads in the JVM.

- **Larger in size** compared to the stack.
- **Global access**: Objects in the heap can be accessed from anywhere in the application.
- **Managed by Garbage Collector**: Java's automatic memory management system (Garbage Collection) cleans up unused objects.

### What is Stored in the Heap?
1. **Objects** (e.g., instances of classes)
2. **Instance variables** (fields of objects)
3. **Arrays**
```java
public class Person {
    String name;  // Stored in Heap

    public Person(String name) {
        this.name = name;  // 'this.name' is stored in Heap
    }
}

public class Example {
    public static void main(String[] args) {
        Person p = new Person("John");  // 'p' is a reference stored in Stack, the object is in Heap
    }
}
```

### Pros of Heap:
- **Dynamic memory allocation**: The heap allows the creation of objects at runtime.
- **No size limitations**: The heap is only constrained by the available memory, making it ideal for large-scale objects and complex data structures.

### Cons of Heap:
- **Slower access**: Accessing objects in the heap is slower than accessing variables in the stack.
- **Requires management**: Memory in the heap needs to be managed, and unused objects must be cleared to avoid memory leaks (handled by the Garbage Collector).

## 📝 Key Differences Between Stack and Heap

| Feature                     | Stack                                | Heap                             |
|------------------------------|--------------------------------------|----------------------------------|
| **Memory Type**              | Static Memory                        | Dynamic Memory                   |
| **Size**                     | Smaller                              | Larger                           |
| **Access Speed**             | Faster                               | Slower                           |
| **Memory Management**        | Managed automatically (LIFO)         | Managed by Garbage Collector     |
| **Scope**                    | Thread-specific                      | Global across all threads        |
| **Storage**                  | Primitive data and object references | Objects and instance variables   |
| **Errors**                   | StackOverflowError                   | OutOfMemoryError                 |

---

### 🎯 Summary:
- **Stack** is for **static memory allocation**, storing method calls, and primitive variables. It's fast but has limited space.
- **Heap** is for **dynamic memory allocation**, where objects are stored and managed by the **Garbage Collector**. It’s larger but slower.

Both memory types are crucial for optimal performance in Java applications. Understanding when and how memory is allocated can help avoid errors like **StackOverflow** and **OutOfMemory** exceptions, and improve overall application efficiency! 🚀