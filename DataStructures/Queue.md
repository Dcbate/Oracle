# 📘 Queue in Java

## 📝 Overview
`Queue` is a part of Java's `java.util` package and is a **collection** that follows the **First-In-First-Out (FIFO)** principle, meaning the element added first is the one removed first. The `Queue` interface is implemented by several classes like `LinkedList`, `PriorityQueue`, and `ArrayDeque`.

- **FIFO**: The element that is added first is the one that is removed first.
- `Queue` is ideal for **managing tasks** where order and sequence are crucial, like job scheduling, message handling, and resource management.

## 🧩 Key Features
- **Order preservation**: Ensures that elements are processed in the order they are added.
- Supports operations for inserting, retrieving, and inspecting elements.
- Specialized variants such as **PriorityQueue** provide additional features, like sorting elements based on natural ordering or a comparator.

## 🚀 Queue Implementations

| **Implementation**   | **Description**                                                                 |
|----------------------|---------------------------------------------------------------------------------|
| `LinkedList`         | Implements `Queue` using a doubly linked list, providing efficient insertion and removal at both ends. |
| `PriorityQueue`      | A queue where elements are ordered according to their natural ordering or a comparator, rather than FIFO. |
| `ArrayDeque`         | A resizable array implementation of `Deque`, providing efficient insertion, removal, and access from both ends. |

## 🚀 Common Methods (Queue)

| **Method**                              | **Description**                                |
|-----------------------------------------|------------------------------------------------|
| `add(E element)`                        | Inserts the specified element into the queue. Throws an exception if the queue is full. |
| `offer(E element)`                      | Inserts the specified element into the queue. Returns `false` if the queue is full. |
| `poll()`                                | Retrieves and removes the head of the queue, returning `null` if the queue is empty. |
| `remove()`                              | Retrieves and removes the head of the queue. Throws an exception if the queue is empty. |
| `peek()`                                | Retrieves, but does not remove, the head of the queue, returning `null` if the queue is empty. |
| `element()`                             | Retrieves, but does not remove, the head of the queue. Throws an exception if the queue is empty. |
| `isEmpty()`                             | Returns `true` if the queue contains no elements.|
| `size()`                                | Returns the number of elements in the queue.   |
| `clear()`                               | Removes all elements from the queue.           |

## ⚙️ How Queue Works
1. **First-In-First-Out (FIFO)**: Elements are inserted at the **rear** of the queue and removed from the **front**.
2. **Offer vs. Add**: `add()` throws an exception if the queue is full, while `offer()` returns `false`.
3. **Poll vs. Remove**: `poll()` returns `null` when the queue is empty, whereas `remove()` throws an exception.
4. **PriorityQueue**: Elements are processed according to their **natural order** (or based on a comparator), not in a strict FIFO order.

## Example: Basic Queue Usage

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Creating a queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        // Retrieving and removing the head of the queue
        System.out.println("Poll: " + queue.poll());

        // Viewing the next element without removing it
        System.out.println("Peek: " + queue.peek());
    }
}
```

## Example: PriorityQueue Usage

``` java
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
public static void main(String[] args) {
// Creating a priority queue
Queue<Integer> priorityQueue = new PriorityQueue<>();

        // Adding elements (sorted in natural order)
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(20);

        // Polling elements in sorted order
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
    }
}
```


## 🔐 Important Notes
- **Queue operations** such as `offer()`, `poll()`, and `peek()` handle queue limits and empty states more gracefully compared to `add()` and `remove()`, which throw exceptions.
- **PriorityQueue** does not follow the FIFO principle but instead processes elements based on their **priority**.
- The `ArrayDeque` class is a more efficient alternative to `LinkedList` for non-blocking queue scenarios, offering better performance in most cases.

## 🎯 When to Use Queue?
- Use `Queue` when you need to manage a **sequence of tasks** or events where **processing order** is important.
- `LinkedList` is ideal for standard **FIFO operations**, especially when **insertion** and **deletion** are frequent at both ends of the collection.
- Use `PriorityQueue` when elements need to be processed based on **priority** rather than their insertion order.
- `ArrayDeque` is efficient for both queue and deque operations, offering flexibility in non-blocking environments.

## 🔚 Conclusion

The `Queue` interface in Java provides a robust solution for managing tasks in a **FIFO** manner, ensuring that elements are processed in the correct sequence. With various implementations like `LinkedList`, `PriorityQueue`, and `ArrayDeque`, `Queue` offers flexibility for different use cases, from simple task management to priority-based processing. By selecting the right implementation, developers can efficiently handle sequential tasks while optimizing performance and resource usage.