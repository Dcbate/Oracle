# 📘 Set

## 📝 Overview
`Set` is a part of Java's `java.util` package and represents a **collection** that does not allow **duplicate elements**. It is an interface that extends the `Collection` interface and is implemented by various classes like `HashSet`, `LinkedHashSet`, and `TreeSet`.

- **No duplicate elements**: A `Set` does not allow any duplicates. If you try to insert a duplicate element, it will ignore the new addition.
- **Unordered collection**: Unless a specific implementation like `LinkedHashSet` or `TreeSet` is used, a `Set` does not guarantee the order of elements.

## 🧩 Key Features
- **No duplicates**: Ensures uniqueness in the collection.
- **Efficient lookup**: The primary use case for a `Set` is to quickly check if an element is already present.
- Depending on the implementation, elements may be **unordered** (`HashSet`), **ordered by insertion** (`LinkedHashSet`), or **sorted** (`TreeSet`).


## 🚀 Set Implementations

| **Implementation**   | **Description**                                                                 |
|----------------------|---------------------------------------------------------------------------------|
| `HashSet`            | Implements `Set` with no guarantee of iteration order and provides constant time performance for basic operations (`O(1)`). |
| `LinkedHashSet`      | Extends `HashSet` but maintains insertion order of elements.                     |
| `TreeSet`            | Implements `Set` that stores elements in a **sorted order** (according to natural ordering or a custom comparator) and offers `O(log n)` time complexity for most operations. |

## Example: Set Usage

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        Set<String> set = new HashSet<>();
        
        // Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // This will be ignored since "Apple" is already in the set
        
        // Checking if an element exists
        System.out.println("Contains Banana? " + set.contains("Banana"));

        // Iterating over the Set
        for (String element : set) {
            System.out.println(element);
        }
    }
}
```



## 🚀 Common Methods (Set)

| **Method**                              | **Description**                                |
|-----------------------------------------|------------------------------------------------|
| `add(E element)`                        | Adds the specified element to the set if it is not already present. Returns `true` if the element was added. |
| `remove(Object o)`                      | Removes the specified element from the set.    |
| `contains(Object o)`                    | Returns `true` if the set contains the specified element. |
| `isEmpty()`                             | Returns `true` if the set contains no elements.|
| `size()`                                | Returns the number of elements in the set.     |
| `clear()`                               | Removes all elements from the set.             |
| `iterator()`                            | Returns an iterator over the elements in the set.|
| `retainAll(Collection<?> c)`            | Retains only the elements in the set that are contained in the specified collection. |
| `removeAll(Collection<?> c)`            | Removes from the set all of its elements that are contained in the specified collection. |

## ⚙️ How Set Works
1. **Unique elements**: `Set` is designed to hold only unique elements. When you try to add an element that is already present, it is ignored.
2. **No fixed order**: A `HashSet` is unordered, whereas a `TreeSet` stores elements in a **sorted** order. `LinkedHashSet` maintains the **insertion order**.
3. **Performance**:
    - `HashSet`: Provides **constant-time** performance `O(1)` for adding, removing, and checking for elements.
    - `TreeSet`: Provides **logarithmic time** performance `O(log n)` since it keeps elements in a sorted order.
    - `LinkedHashSet`: Slightly slower than `HashSet` due to maintaining the insertion order, but still generally offers **constant-time** operations.

## 🔐 Important Notes
- **HashSet** is backed by a **hash table**, which ensures no duplicate elements and offers fast performance.
- **TreeSet** maintains **sorted order** but has slower performance than `HashSet` due to tree-based operations.
- **LinkedHashSet** preserves **insertion order** but comes with additional memory overhead compared to `HashSet`.

## 🎯 When to Use Set?
- Use `Set` when you need to ensure **unique elements** in your collection.
- **HashSet** is ideal for scenarios where **fast performance** is critical, and order doesn’t matter.
- **TreeSet** is best when you need to maintain **sorted elements**.
- **LinkedHashSet** is useful when you need to preserve the **insertion order** of elements.


## 🔚 Conclusion

The `Set` interface in Java is a powerful tool for managing collections of **unique elements**. With its various implementations, such as `HashSet`, `TreeSet`, and `LinkedHashSet`, developers can choose the best approach based on their requirements, whether it's for **fast performance**, **maintaining sorted order**, or **preserving insertion order**. The `Set` interface provides methods that allow for efficient addition, removal, and lookup operations, making it ideal for scenarios where duplicates are not allowed, and uniqueness is paramount.

By understanding the characteristics of each `Set` implementation, you can optimize your program's performance and ensure that your collections are managed effectively and efficiently.
