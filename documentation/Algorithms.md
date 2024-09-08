# 📘 Basic Algorithms in Computer Science

## 📝 Overview
Algorithms are step-by-step procedures used to solve specific problems or perform tasks. In computer science, they are essential for problem-solving, data manipulation, and system design. Basic algorithms are fundamental concepts that form the building blocks for more complex algorithms and data structures.

This documentation will cover key **sorting**, **searching**, and **common algorithms** that are often used in programming.

## 🧩 Categories of Basic Algorithms

1. **Sorting Algorithms**: Organize elements in a specific order (e.g., ascending or descending).
2. **Searching Algorithms**: Find elements within a data structure.
3. **Recursive Algorithms**: Solve problems by breaking them into smaller, simpler problems.
4. **Greedy Algorithms**: Make a series of decisions to achieve a locally optimal solution.
5. **Divide and Conquer Algorithms**: Break problems into smaller subproblems, solve them independently, and combine the solutions.

---

## 🚀 Common Sorting Algorithms

### 1. **Bubble Sort**
- **Complexity**: `O(n^2)` worst-case, `O(n)` best-case
- **Description**: Compares adjacent elements and swaps them if they are in the wrong order. This process is repeated until the array is sorted.

**Steps**:
1. Traverse the array from the first element to the last.
2. Compare each pair of adjacent elements.
3. Swap them if they are in the wrong order.
4. Continue the process until the array is sorted.

#### Java Example:
```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```
Usage: Bubble sort is simple but inefficient for large datasets. It is useful for small data sets and learning purposes.


---

### 2. **Selection Sort**
- **Complexity**: `O(n^2)`
- **Description**: Repeatedly finds the minimum element from the unsorted portion and places it at the beginning.

**Steps**:
1. Divide the array into sorted and unsorted parts.
2. Repeatedly select the smallest element from the unsorted part and swap it with the first unsorted element.
3. Repeat until the entire array is sorted.

#### Java Example:
```java
public class SelectionSort {
  public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      // Swap arr[i] with the element at minIndex
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }
}
```
Usage: Selection sort is not efficient for large datasets but is useful when memory writes are more expensive than comparisons.

---

### 3. **Insertion Sort**
- **Complexity**: `O(n^2)` worst-case, `O(n)` best-case
- **Description**: Builds the sorted array one element at a time by picking an element from the unsorted portion and inserting it into the correct position in the sorted portion.

**Steps**:
1. Assume the first element is sorted.
2. For each remaining element, shift larger sorted elements to the right and insert the current element into the correct position.
3. Repeat until all elements are sorted.


#### Java Example:
```java
public class InsertionSort {
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
}
```

Usage: Insertion sort is useful for small datasets and when the data is almost sorted.

---

### 4. **Merge Sort**
- **Complexity**: `O(n log n)`
- **Description**: A **divide-and-conquer** algorithm that splits the array into smaller subarrays, recursively sorts them, and merges them back together.

**Steps**:
1. Divide the array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves back into one sorted array.

#### Java Example:
```java
public class MergeSort {
  public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++) L[i] = arr[left + i];
    for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) arr[k++] = L[i++];
      else arr[k++] = R[j++];
    }
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
  }
}
```

Usage: Merge Sort is ideal for large datasets and when stable sorting is required.


---

### 5. **Quick Sort**
- **Complexity**: `O(n log n)` average-case, `O(n^2)` worst-case
- **Description**: A **divide-and-conquer** algorithm that picks a pivot, partitions the array into elements less than and greater than the pivot, and recursively sorts the partitions.

**Steps**:
1. Choose a pivot element from the array.
2. Partition the array into elements less than the pivot and elements greater than the pivot.
3. Recursively sort the two partitions.

#### Java Example:
```java
public class QuickSort {
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }
}
```
Usage: Quick Sort is useful for large datasets when average-case performance is crucial.


---

## 🚀 Common Searching Algorithms

### 1. **Linear Search**
- **Complexity**: `O(n)`
- **Description**: Searches for an element by traversing the array or list from start to finish.

**Steps**:
1. Start from the first element.
2. Compare each element with the target element.
3. If the element is found, return its position.
4. If the entire array is traversed without finding the element, return `-1`.

#### Java Example:
```java
public class LinearSearch {
  public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
```

Usage: Linear Search is ideal for small datasets or when the data is unsorted.


---

### 2. **Binary Search**
- **Complexity**: `O(log n)`
- **Description**: Efficiently searches for an element in a **sorted array** by repeatedly dividing the search space in half.

**Steps**:
1. Compare the target element with the middle element of the array.
2. If the target is equal to the middle element, return its position.
3. If the target is smaller, search in the left half; if larger, search in the right half.
4. Repeat the process until the element is found or the search space is empty.

#### Java Example:
```java
public class BinarySearch {
  public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
```

Usage: Binary Search is perfect for large, sorted datasets.

---

## 🚀 Common Recursive Algorithms

### 1. **Factorial Calculation**
- **Complexity**: `O(n)`
- **Description**: A recursive algorithm to compute the factorial of a number (`n!`), which is the product of all integers from 1 to `n`.

**Steps**:
1. Base case: If `n == 1`, return 1.
2. Recursive case: Multiply `n` by the factorial of `n - 1`.

#### Java Example:
```java
public class Factorial {
  public static int factorial(int n) {
    if (n == 1) return 1;
    return n * factorial(n - 1);
  }
}
```

Usage: Factorial calculation is often used in combinatorics and probability.

---

### 2. **Fibonacci Sequence**
- **Complexity**: `O(2^n)` for naive recursion, `O(n)` with dynamic programming
- **Description**: A recursive algorithm to compute the Fibonacci sequence, where each number is the sum of the two preceding numbers.

**Steps**:
1. Base cases: If `n == 0` or `n == 1`, return `n`.
2. Recursive case: Return the sum of the Fibonacci numbers for `n - 1` and `n - 2`.

#### Java Example:
```java
public class Fibonacci {
  public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
```

Usage: Fibonacci numbers are used in dynamic programming, algorithmic design, and mathematical computations.

---

## 🚀 Greedy Algorithm Example

### **Coin Change Problem**
- **Complexity**: `O(n)`
- **Description**: A greedy algorithm that selects the largest possible denomination first to minimize the number of coins needed.

**Steps**:
1. Start with the largest coin denomination.
2. Subtract the coin's value from the total amount.
3. Repeat the process with the remaining amount until it becomes zero.


#### Java Example:
```java
import java.util.Arrays;

public class CoinChange {
  public static int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    int count = 0;
    for (int i = coins.length - 1; i >= 0; i--) {
      while (amount >= coins[i]) {
        amount -= coins[i];
        count++;
      }
    }
    return amount == 0 ? count : -1;
  }
}
```

Usage: Used in currency exchange systems and optimization problems.

---

## 🚀 Divide and Conquer Algorithm Example

### **Merge Sort**
- **Complexity**: `O(n log n)`
- **Description**: A sorting algorithm that uses the divide-and-conquer strategy to split, sort, and merge arrays.

**Steps**:
1. Divide the array into two halves.
2. Recursively sort the two halves.
3. Merge the sorted halves into a single sorted array.

#### Java Example:
```java
public class BinarySearch {
  public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
```

Usage: Binary Search is perfect for large, sorted datasets.

---

## 🔐 Important Notes
- **Sorting algorithms** like `Merge Sort` and `Quick Sort` offer better performance for large datasets (`O(n log n)`) compared to simpler algorithms like `Bubble Sort`.
- **Binary Search** is much more efficient than `Linear Search`, but it requires a **sorted array**.
- **Recursive algorithms** can be elegant but may introduce performance issues (like stack overflow or slow runtimes) if not carefully designed.
- **Greedy algorithms** aim for the local optimal solution but may not always provide the best global solution.

## 🎯 When to Use These Algorithms?

- **Sorting algorithms**: When you need to arrange data in a specific order.
  - Use **Merge Sort** for stable sorting with guaranteed `O(n log n)` performance.
  - Use **Quick Sort** when average-case performance matters and you're dealing with large datasets.

- **Searching algorithms**: When you need to find an element in a collection.
  - Use **Linear Search** for small, unsorted datasets.
  - Use **Binary Search** for large, sorted datasets.

- **Recursive algorithms**: For problems that can be broken into subproblems (e.g., factorial, Fibonacci).

- **Greedy algorithms**: When you need to make a sequence of locally optimal choices (e.g., coin change problem).

- **Divide and Conquer**: When a problem can be split into smaller subproblems and solved independently (e.g., **Merge Sort**, **Quick Sort**).

## 🔚 Conclusion

Basic algorithms are the foundation of computer science and are crucial for solving common problems efficiently. By understanding key algorithms like sorting, searching, recursion, and greedy algorithms, you can tackle a wide range of computational problems. Mastering these algorithms will not only improve your coding skills but also help in optimizing solutions for large-scale data processing.