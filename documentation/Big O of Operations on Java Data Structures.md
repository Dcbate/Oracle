# 📊 Big O of Operations on Java Data Structures

In Java, data structures are essential for organizing and managing data efficiently. The performance of different operations on these data structures can be evaluated using **Big O notation**, which helps measure the time complexity and scalability of an algorithm. Here’s a breakdown of the common data structures in Java and the Big O complexities of their operations, with code examples.

---

## 📚 **1. Array**

### Java Class: `int[]`, `Object[]`, `ArrayList`

Arrays in Java provide a fixed-length, contiguous block of memory where elements are stored in order.

| Operation   | Time Complexity | Explanation                                                                                              | Code Example |
|-------------|-----------------|----------------------------------------------------------------------------------------------------------|--------------|
| Access      | O(1)            | Direct access to elements using an index. No traversal is needed.                                          | `arr[2];`    |
| Search      | O(n)            | In the worst case, you need to traverse the entire array to find an element.                              | `for (int i : arr) { if (i == target) return i; }` |
| Insertion   | O(n)            | Inserting an element requires shifting all elements to make space (unless appending to the end).           | `System.arraycopy(arr, index, newArr, index + 1, arr.length - index);` |
| Deletion    | O(n)            | Similarly, deleting requires shifting elements to fill the gap.                                            | `System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);` |

### **Why?**
- Accessing any element in an array is constant time because of the fixed indexing mechanism.
- However, for insertion or deletion (except at the end), the elements need to be shifted, causing a linear time operation.

---

## 🌳 **2. LinkedList**

### Java Class: `LinkedList`

Linked Lists store data in nodes, where each node points to the next. It comes in two variants: singly and doubly linked.

| Operation   | Time Complexity | Explanation                                                                                              | Code Example |
|-------------|-----------------|----------------------------------------------------------------------------------------------------------|--------------|
| Access      | O(n)            | Access requires traversing the list from the head node.                                                   | `list.get(index);` |
| Search      | O(n)            | Linear search is required to find a specific node.                                                        | `for (Integer i : list) { if (i.equals(target)) return i; }` |
| Insertion   | O(1)            | Inserting a node at the head or tail can be done in constant time.                                        | `list.addFirst(element);` or `list.addLast(element);` |
| Deletion    | O(1)            | Deleting a node is O(1) if you have a reference to the node. Otherwise, searching is O(n).                | `list.removeFirst();` or `list.removeLast();` |

### **Why?**
- Linked lists are optimized for insertions and deletions since no shifting of elements is required.
- However, accessing an element at a specific index requires traversing the list node by node, leading to O(n) time.

---

## 🏷️ **3. HashMap**

### Java Class: `HashMap`, `HashSet`

A `HashMap` is a key-value pair structure that uses hashing to store and retrieve data. It provides efficient insertions, deletions, and lookups.

#### **What about `HashSet`?**
A **`HashSet`** is implemented internally using a `HashMap`. Each element in a `HashSet` is stored as the key in the underlying `HashMap`, with a constant dummy value (usually `Boolean.TRUE`). This ensures that each element in the `HashSet` is unique.

| Operation   | Time Complexity | Explanation                                                                                              | Code Example (HashMap) |
|-------------|-----------------|----------------------------------------------------------------------------------------------------------|------------------------|
| Access      | O(1)            | Constant time on average for retrieving an element by key (due to hashing).                               | `map.get(key);`         |
| Search      | O(1)            | Searching by key is constant time due to the hash function.                                               | `map.containsKey(key);` |
| Insertion   | O(1)            | Inserting an element is usually O(1) unless a hash collision occurs.                                      | `map.put(key, value);`  |
| Deletion    | O(1)            | Similar to insertion, deleting an element is O(1) unless there’s a collision.                             | `map.remove(key);`      |

### **Why?**
- **Hashing** distributes keys evenly, making retrieval fast in most cases.
- However, in the case of hash collisions (when two keys hash to the same bucket), performance can degrade to O(n) if the buckets are poorly managed or too many collisions occur.

---

## 📏 **4. TreeMap**

### Java Class: `TreeMap`, `TreeSet`

A `TreeMap` is a sorted key-value pair structure implemented as a **Red-Black Tree** in Java. This ensures the map remains balanced.

| Operation   | Time Complexity | Explanation                                                                                              | Code Example |
|-------------|-----------------|----------------------------------------------------------------------------------------------------------|--------------|
| Access      | O(log n)        | Access involves traversing the tree from the root to the desired node, ensuring logarithmic time.          | `map.get(key);` |
| Search      | O(log n)        | Similarly, searching for a key involves tree traversal, which takes O(log n).                             | `map.containsKey(key);` |
| Insertion   | O(log n)        | Inserting a new element requires maintaining tree balance, making the time logarithmic.                   | `map.put(key, value);`  |
| Deletion    | O(log n)        | Deletion also involves tree traversal and potential rebalancing of the tree.                              | `map.remove(key);`      |

### **Why?**
- **Balanced trees** like Red-Black trees ensure logarithmic depth, leading to efficient lookups, insertions, and deletions compared to linked structures.
- This is useful when the data needs to be kept sorted and accessible quickly.

---

## 🔢 **5. Stack & Queue**

### Java Class: `Stack`, `LinkedList` (for Queue), `ArrayDeque`

Stacks and Queues are specialized linear data structures. Stacks follow a **Last-In-First-Out (LIFO)** principle, while Queues follow a **First-In-First-Out (FIFO)** principle.

| Operation           | Stack Time Complexity | Queue Time Complexity | Explanation                                                         | Code Example |
|---------------------|-----------------------|-----------------------|---------------------------------------------------------------------|--------------|
| Access (Peek)       | O(1)                  | O(1)                  | Accessing the top of the stack or front of the queue is constant time.| `stack.peek();` or `queue.peek();` |
| Insertion (Push/Enq)| O(1)                  | O(1)                  | Inserting an element at the top of a stack or end of a queue is O(1).| `stack.push(element);` or `queue.offer(element);` |
| Deletion (Pop/Deq)  | O(1)                  | O(1)                  | Removing the top element (stack) or the front element (queue) is O(1).| `stack.pop();` or `queue.poll();` |

### **Why?**
- Both stacks and queues are designed for quick access to specific elements (top or front), and their operations are constant time due to the simple underlying structure (typically arrays or linked lists).

---

## 🧮 **6. PriorityQueue**

### Java Class: `PriorityQueue`

A `PriorityQueue` in Java is a heap-based data structure where elements are dequeued based on their priority, not the order in which they were added.

| Operation   | Time Complexity | Explanation                                                                                              | Code Example |
|-------------|-----------------|----------------------------------------------------------------------------------------------------------|--------------|
| Access      | O(1)            | The highest-priority element can be accessed in constant time.                                             | `queue.peek();` |
| Insertion   | O(log n)        | Insertion into a heap requires reordering to maintain heap property.                                       | `queue.offer(element);` |
| Deletion    | O(log n)        | Removing the highest-priority element requires reheapification.                                            | `queue.poll();` |

### **Why?**
- A priority queue is implemented using **heaps**, where insertions and deletions require reordering the heap to maintain its structure, resulting in logarithmic time complexity.

---

## 🔑 Key Takeaways:

- **Array** is fast for access but slow for insertions and deletions.
- **LinkedList** is efficient for sequential access but slow for random access.
- **HashMap** and **HashSet** provide constant-time operations on average but degrade with hash collisions.
- **TreeMap** ensures sorted order with logarithmic operations.
- **Stack** and **Queue** are efficient for their specific LIFO/FIFO operations.
- **PriorityQueue** is perfect for managing elements with priorities using a heap.