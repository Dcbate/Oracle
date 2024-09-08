# 📘 Stack in Java

## 📝 Overview
`Stack` is part of Java's `java.util` package and represents a **Last-In-First-Out (LIFO)** data structure. In a `Stack`, the last element added is the first one to be removed. This behavior makes it ideal for scenarios such as **expression evaluation**, **undo operations**, and **recursive algorithms**.

- **LIFO principle**: The element added most recently is the one removed first.
- The `Stack` class extends `Vector` and provides several methods for working with stack-like operations.

## 🧩 Key Features
- **Last-In-First-Out (LIFO)**: The most recent element added is the first to be removed.
- Provides methods for **pushing**, **popping**, and **peeking** elements.
- Commonly used in **recursive programming**, **algorithm implementation** (like DFS), and **undo functionality** in software applications.

## Example: Basic Stack Operations

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Creating a stack of integers
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peeking the top element without removing it
        System.out.println("Top element (peek): " + stack.peek());

        // Popping elements from the stack
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Checking if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
```



## 🚀 Stack Methods

| **Method**                              | **Description**                                |
|-----------------------------------------|------------------------------------------------|
| `push(E element)`                       | Pushes an element onto the top of the stack.   |
| `pop()`                                 | Removes and returns the top element of the stack. Throws `EmptyStackException` if the stack is empty. |
| `peek()`                                | Returns the top element without removing it. Throws `EmptyStackException` if the stack is empty. |
| `isEmpty()`                             | Returns `true` if the stack is empty.          |
| `search(Object o)`                      | Returns the 1-based position of the element from the top of the stack. Returns `-1` if the element is not found. |
| `size()`                                | Returns the number of elements in the stack.   |
| `clear()`                               | Removes all elements from the stack.           |

## ⚙️ How Stack Works
1. **Last-In-First-Out (LIFO)**: In a stack, the **most recent element** added to the stack is the **first one** to be removed.
2. **Push and Pop**: The primary operations in a stack are `push()` (to add an element) and `pop()` (to remove the top element). These operations ensure the LIFO behavior.
3. **Peek**: The `peek()` method allows you to **look at the top element** without removing it, which is useful for inspecting the stack's state.

## 🔐 Important Notes
- The **`Stack` class** in Java extends `Vector`, meaning it inherits many of its methods and behaviors. However, `Deque` (via `ArrayDeque`) is often preferred in modern Java for stack operations because it is more efficient.
- `pop()` and `peek()` throw an `EmptyStackException` if the stack is empty, so ensure you check with `isEmpty()` before calling these methods.

## 🎯 When to Use Stack?
- Use a stack when your task requires **last-in-first-out (LIFO)** behavior. Examples include:
    - **Recursive algorithms**, where function calls need to be processed in reverse order.
    - **Undo functionality**, where you need to revert the most recent changes.
    - **Expression parsing** or **evaluation**, such as with arithmetic or postfix expressions.
    - Implementing **Depth-First Search (DFS)** in algorithms.

## 🔚 Conclusion

The `Stack` class in Java is an essential tool for handling **LIFO** operations, making it highly suitable for scenarios such as **recursive algorithms**, **expression evaluation**, and **backtracking tasks**. While the `Stack` class extends `Vector` and provides basic stack operations, in many cases, the **`Deque` interface** (via `ArrayDeque`) is preferred due to better performance and flexibility. By understanding when and how to use a stack, you can implement efficient and structured solutions to many algorithmic and software problems.