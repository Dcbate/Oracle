# 📘 LinkedList

## 📝 Overview
`LinkedList` is a part of Java's `java.util` package and implements both the **List** and **Deque** interfaces, making it a versatile **doubly-linked list**. It allows for efficient insertion and removal of elements at both ends of the list.

- **Doubly-linked**: Each element (node) contains references to both the next and previous elements.
- **Non-contiguous memory**: Elements are not stored in a continuous block of memory, making resizing unnecessary.

## 🧩 Key Features
- **Dynamic size**: Can grow and shrink dynamically.
- Allows **null elements**.
- Provides better performance for frequent **insertion and deletion** of elements compared to an `ArrayList`, especially when modifying the list in the middle.
- Implements both **List** and **Deque**, meaning it can function as a **queue**, **stack**, or **list**.

## 📚 Class Definition

### As a List

```java
import java.util.LinkedList;
import java.util.List;


public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();
        
        // Adding elements to the LinkedList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Inserting an element at a specific position
        list.add(1, "Orange");
        
        // Retrieving an element from the LinkedList
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);
        
        // Removing an element
        list.remove("Banana");
        
        // Iterating over the LinkedList
        for (String item : list) {
            System.out.println(item);
        }
    }
}
```
### As a Queue
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Using LinkedList as a Queue
        LinkedList<String> queue = new LinkedList<>();
        
        // Adding elements to the queue
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        // Retrieving and removing the first element
        System.out.println("Poll: " + queue.poll());

        // Viewing the next element without removing it
        System.out.println("Peek: " + queue.peek());
    }
}
```
### As a Stack
```java
import java.util.LinkedList;

public class StackExample {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

        // Using LinkedList as a Stack (LIFO)
        stack.push(10); // Push element to the stack
        stack.push(20);
        stack.push(30);

        // Pop element from the stack
        System.out.println("Popped: " + stack.pop());

        // Peek the top element
        System.out.println("Top: " + stack.peek());
    }
}
```


## 🚀 Common Methods (List)

| **Method**                              | **Description**                                |
|-----------------------------------------|------------------------------------------------|
| `add(E element)`                        | Appends the element to the end of the list.    |
| `add(int index, E element)`             | Inserts the element at the specified position. |
| `get(int index)`                        | Retrieves the element at the specified index.  |
| `remove(int index)`                     | Removes the element at the specified index.    |
| `remove(Object element)`                | Removes the first occurrence of the element.   |
| `size()`                                | Returns the number of elements in the list.    |
| `isEmpty()`                             | Returns `true` if the list contains no elements.|
| `contains(Object o)`                    | Returns `true` if the list contains the element.|
| `clear()`                               | Removes all elements from the list.            |

## 🚀 Common Methods (Stack)

| **Method**                              | **Description**                                |
|-----------------------------------------|------------------------------------------------|
| `push(E element)`                       | Pushes an element onto the top of the stack.   |
| `pop()`                                 | Removes and returns the top element of the stack.|
| `peek()`                                | Returns the top element without removing it.   |
| `isEmpty()`                             | Returns `true` if the stack is empty.          |
| `size()`                                | Returns the number of elements in the stack.   |

## 🚀 Common Methods (Queue)

| **Method**                              | **Description**                                |
|-----------------------------------------|------------------------------------------------|
| `add(E element)`                        | Adds an element to the end of the queue.       |
| `offer(E element)`                      | Adds an element to the end of the queue, returns `false` if the queue is full. |
| `poll()`                                | Retrieves and removes the head of the queue.   |
| `peek()`                                | Retrieves, but does not remove, the head of the queue. |
| `isEmpty()`                             | Returns `true` if the queue is empty.          |
| `size()`                                | Returns the number of elements in the queue.   |
| `remove()`                              | Removes the head of the queue.                 |



## ⚙️ How LinkedList Works
1. **Nodes**: A LinkedList consists of a series of **nodes**. Each node contains:
    - A **data** field, which stores the actual element.
    - A reference to the **next node** and **previous node** (for a doubly-linked list).

2. **Insertion and Deletion**: Unlike arrays, `LinkedList` allows **constant-time** insertion or removal operations at the beginning or end of the list. However, searching for an element takes **linear time** `O(n)`.

3. **Traversal**: You can traverse from **head to tail** (forward) or from **tail to head** (backward) due to the doubly-linked structure.

## 🔐 Important Notes
- **Time complexity** for insertion and deletion at the beginning or end of the list is `O(1)`, while accessing elements takes `O(n)` due to traversal.
- **Memory overhead** is higher than arrays because each element requires additional space for pointers to the next and previous elements.
- **Not synchronized**, so it’s not thread-safe. Use `Collections.synchronizedList` to make it thread-safe if needed.

## 🎯 When to Use LinkedList?
- When frequent **insertions and deletions** at the beginning or middle of the list are required.
- Suitable for **queues** and **stacks** as it provides efficient removal and insertion at both ends.
- Use when **random access** to elements is **not frequently needed**, as accessing elements by index takes `O(n)` time.

## 🔚 Conclusion

`LinkedList` is a flexible and efficient data structure in Java, particularly suited for scenarios that involve **frequent insertion and deletion** of elements, especially at the beginning or end of the list. Its **doubly-linked** nature allows for constant-time modifications at these points, although **access by index** is slower compared to arrays due to the need for traversal. Additionally, `LinkedList` can be used as both a **list** and a **deque**, making it a versatile option for implementing **queues** and **stacks**.

By using `LinkedList`, you can optimize your application for **dynamic data manipulation**, where the order of elements or the position of insertions and deletions is critical.