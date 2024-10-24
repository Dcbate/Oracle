
# Java Exceptions Cheat Sheet

Exception handling is an essential mechanism in Java that ensures programs can manage and recover from errors during execution. This cheat sheet covers the structure of exceptions, types (checked vs unchecked), and the usage of `try-catch` blocks.

---

## 1. **Exception Class Structure**

All exceptions in Java are part of the **`java.lang.Throwable`** class hierarchy. It has two main subclasses: **Error** and **Exception**.

# Java Exception Class Hierarchy

```plaintext
java.lang.Throwable
    |
    |-- java.lang.Error (Unchecked)
    |      |-- OutOfMemoryError
    |      |-- StackOverflowError
    |      |-- VirtualMachineError
    |      |-- LinkageError
    |          |-- NoClassDefFoundError
    |
    |-- java.lang.Exception (Checked)
           |
           |-- java.lang.RuntimeException (Unchecked)
           |      |-- NullPointerException
           |      |-- ArrayIndexOutOfBoundsException
           |      |-- ArithmeticException
           |      |-- ClassCastException
           |      |-- IllegalArgumentException
           |
           |-- IOException (Checked)
           |      |-- FileNotFoundException
           |      |-- EOFException
           |
           |-- SQLException (Checked)
           |
           |-- ClassNotFoundException (Checked)
 ```

### Key Classes:
- **`Throwable`**: Base class for all exceptions and errors.
- **`Error`**: Indicates serious problems that an application should not try to handle.
- **`Exception`**: Base class for recoverable exceptions.
    - **CheckedException**: Exceptions that must be handled or declared.
    - **RuntimeException**: Unchecked exceptions that do not require handling at compile time.

---

## 2. **Checked vs Unchecked Exceptions**

### **Checked Exceptions:**
- These are exceptions that the Java compiler **forces** you to handle.
- Methods that throw checked exceptions must either:
    - **Handle them** within a `try-catch` block, or
    - **Declare them** in the method signature using `throws`.
- **Examples**: `IOException`, `ClassNotFoundException`, `SQLException`.

### **Unchecked Exceptions (Runtime Exceptions):**
- These exceptions **do not** need to be declared in the method signature or handled explicitly. They occur due to programmer errors, such as logic mistakes.
- **Examples**: `NullPointerException`, `ArrayIndexOutOfBoundsException`, `IllegalArgumentException`.

---

## 3. **Try-Catch Blocks**

The **`try-catch`** block is the standard way to handle exceptions in Java. It allows you to execute code that might throw an exception and handle it gracefully.

### Syntax:
```java
try {
    // Code that might throw an exception
} catch (ExceptionType1 e) {
    // Handle ExceptionType1
} catch (ExceptionType2 e) {
    // Handle ExceptionType2
} finally {
    // Code that will always run, regardless of exceptions
}
```

### Components:
- **`try` block**: Contains the code that might throw an exception.
- **`catch` block**: Handles the exception. You can have multiple `catch` blocks to handle different exception types.
- **`finally` block**: This block is always executed, whether an exception is thrown or not, and is typically used for cleanup code (e.g., closing resources like files or database connections).

---

## 4. **Throws and Throw**

### `throws` Keyword:
- Used in method signatures to declare that a method might throw an exception.
- It informs the calling method that it should handle or declare the exception.
- Example:
  ```java
  public void readFile(String filePath) throws IOException {
      // Code that might throw IOException
  }
  ```

### `throw` Keyword:
- Used to explicitly throw an exception.
- Example:
  ```java
  public void validateAge(int age) {
      if (age < 18) {
          throw new IllegalArgumentException("Age must be 18 or older.");
      }
  }
  ```

---

## 5. **Finally Block**

- The `finally` block contains code that **always** executes, whether or not an exception occurred.
- Commonly used for resource cleanup (closing files, database connections, etc.).
- Example:
  ```java
  try {
      // Risky code
  } catch (Exception e) {
      // Handle exception
  } finally {
      // Cleanup code (e.g., close a file)
  }
  ```

---

## 6. **Try-with-Resources**

Introduced in Java 7, the **try-with-resources** statement ensures that resources (like files, connections, etc.) are closed automatically after execution, without requiring a `finally` block.

### Syntax:
```java
try (ResourceType resource = new ResourceType()) {
    // Use the resource
} catch (ExceptionType e) {
    // Handle exception
}
```

### Benefits:
- It ensures that any object that implements the `AutoCloseable` or `Closeable` interface is automatically closed at the end of the `try` block.
- Cleaner and safer resource management.

---


## 7. **Custom Exceptions**

You can create your own exceptions by extending the `Exception` or `RuntimeException` classes.

### Syntax:
```java
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
```

### Example:
```java
public void validateAge(int age) throws CustomException {
    if (age < 18) {
        throw new CustomException("Age must be 18 or older.");
    }
}
```

---