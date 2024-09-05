# 📚 Java Data Structures

In this document, we will cover various data structures in Java, providing examples and explanations for each. These data structures are essential for efficient programming and can significantly enhance the performance of your applications. Let's dive in! 🔥

## 📖 Table of Contents

1. [Arrays](#1--arrays)
2. [ArrayList](#2--arraylist)
3. [LinkedList](#3--linkedlist)
4. [Stack](#4-%EF%B8%8F-stack)
5. [Queue](#5--queue)
6. [HashMap](#6--hashmap)
7. [HashSet](#7--hashset)

---

## 1. 📦 Arrays

An **Array** is a fixed-size data structure that stores elements of the same type in a contiguous memory location. Arrays are static in nature.

### Example:

```java
// Declare an array
int[] numbers = new int[5]; 

// Assign values to the array
numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;

// Access elements in the array
System.out.println("Element at index 0: " + numbers[0]);
```
Key Characteristics:
* Fixed size 📏
* Can store primitive data types and objects 🗂️
* Indexed starting at 0️⃣

## 2. 📝 ArrayList
   ArrayList is a resizable array implementation in Java, part of the java.util package. It automatically grows as we add elements.

Example:

``` java
Copy code
import java.util.ArrayList;

ArrayList<String> fruits = new ArrayList<>();

// Add elements to ArrayList
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Orange");

// Access elements
System.out.println("First fruit: " + fruits.get(0));

// Remove an element
fruits.remove("Banana");
System.out.println("After removing Banana: " + fruits);

```

#### Key Characteristics:
* Dynamic resizing 📈
* Allows duplicate elements 🔁
* Maintains insertion order 🔡


## 3. 🔗 LinkedList
   A LinkedList is a linear data structure where each element is a separate object, linked using references. Each node in a LinkedList contains data and a reference (link) to the next node.

Example:
``` java
import java.util.LinkedList;

LinkedList<String> animals = new LinkedList<>();

// Add elements to LinkedList
animals.add("Dog");
animals.add("Cat");
animals.add("Horse");

// Access elements
System.out.println("First animal: " + animals.get(0));

// Remove an element
animals.remove(1);
System.out.println("After removing second animal: " + animals);
```
#### Key Characteristics:
* Efficient for insertions and deletions 🛠️
* Slower random access compared to ArrayList ⏳
* Can be used as a Queue or Stack by using addFirst and removeFirst methods
## 4. 🗂️ Stack
   A Stack follows the Last In First Out (LIFO) principle. You can push elements onto the stack and pop them off in reverse order.

Example:
```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();

// Push elements onto the stack
stack.push(10);
stack.push(20);
stack.push(30);

// Pop element from the stack
int popped = stack.pop();
System.out.println("Popped element: " + popped);

// Peek at the top element
System.out.println("Top element: " + stack.peek());
```
#### Key Characteristics:
* LIFO (Last In, First Out) order 📚
* Useful for undo operations or recursive algorithms 🔄
## 5. 🎫 Queue
   A Queue follows the First In First Out (FIFO) principle. It is used in scenarios where the order of processing matters.

Example:
``` java
import java.util.LinkedList;
import java.util.Queue;

Queue<String> queue = new LinkedList<>();

// Add elements to the queue
queue.add("Customer 1");
queue.add("Customer 2");
queue.add("Customer 3");

// Remove element from the queue
String served = queue.poll();
System.out.println("Served: " + served);

// Peek at the front element
System.out.println("Next in line: " + queue.peek());
```
#### Key Characteristics:
* FIFO (First In, First Out) order 🏃‍♂️🏃‍♀️
* Useful for scheduling and task management 🗓️
## 6. 🔑 HashMap
   HashMap stores data in key-value pairs. It allows constant-time performance for basic operations like adding, removing, and retrieving data.

Example:
``` java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();

// Add key-value pairs
map.put("Apple", 10);
map.put("Banana", 20);
map.put("Orange", 30);

// Access values by key
System.out.println("Price of Apple: " + map.get("Apple"));

// Remove a key-value pair
map.remove("Banana");
System.out.println("After removing Banana: " + map);
```
#### Key Characteristics:
* Stores data in key-value pairs 🔑🗝️
* Allows null keys and values 🕳️
* No guarantee of insertion order 🚫🔡
## 7. 🌿 HashSet
   A HashSet is a collection that does not allow duplicate elements. It is backed by a hash table and offers constant-time performance for basic operations.

Example:
```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();

// Add elements
set.add("Apple");
set.add("Banana");
set.add("Orange");

// Duplicate elements are ignored
set.add("Apple");

// Display the set
System.out.println("HashSet: " + set);
```
#### Key Characteristics:
* No duplicates allowed 🚫
* Unordered collection 🔀
* Efficient lookups and insertions ⚡


### 🚀 Conclusion
These are some of the most commonly used data structures in Java. They offer different advantages depending on the type of operations you need to perform. Understanding when and how to use each data structure will help you write more efficient and optimized code.

Happy coding! 🚀