# 🟡 **Java 17 Keywords**

In Java 17, there are **52 reserved keywords** that are part of the language, and each plays a crucial role in the programming structure.

## 📚 **1. Access Modifiers**
These keywords define the visibility of classes, methods, and variables.

| Keyword    | Description                                                     |
|------------|-----------------------------------------------------------------|
| `private`  | Makes a member visible only within its own class.               |
| `protected`| Makes a member visible within its own package and subclasses.   |
| `public`   | Makes a member visible everywhere in the program.               |

## 📚 **2. Control Flow Statements**
Control the flow of execution in your program.

| Keyword    | Description                                                    |
|------------|----------------------------------------------------------------|
| `if`       | Executes a block of code conditionally.                        |
| `else`     | Executes an alternate block if the `if` condition is false.    |
| `switch`   | Selects one of many code blocks to be executed.                |
| `case`     | Defines the possible outcomes of a `switch`.                   |
| `default`  | Defines the default action when no case matches in a `switch`. |
| `do`       | Executes a block of statements repeatedly. The condition is checked after the block is executed. |
| `while`    | Repeats a block of code as long as the given condition is true.|
| `for`      | Repeats a block of code a specific number of times.            |
| `break`    | Exits the nearest loop or `switch`.                            |
| `continue` | Skips the current iteration of a loop and moves to the next iteration. |
| `return`   | Exits from the current method and optionally returns a value.  |
| `yield`    | Returns a value from a `switch` expression. *(New in Java 12)* |

## 📚 **3. Object-Oriented Programming (OOP) Keywords**
These keywords are essential for object-oriented design in Java.

| Keyword      | Description                                                            |
|--------------|------------------------------------------------------------------------|
| `class`      | Defines a class in Java.                                               |
| `interface`  | Defines an interface (abstract contract).                              |
| `enum`       | Defines an enumeration (a set of named values).                        |
| `extends`    | Indicates that a class is inheriting from a superclass.                |
| `implements` | Indicates that a class implements an interface.                        |
| `this`       | Refers to the current object instance.                                 |
| `super`      | Refers to the superclass of the current object.                        |
| `instanceof` | Tests whether an object is an instance of a class or interface.        |
| `new`        | Creates a new instance of a class.                                     |

## 📚 **4. Exception Handling Keywords**
These handle exceptions that might occur during program execution.

| Keyword    | Description                                                   |
|------------|---------------------------------------------------------------|
| `try`      | Defines a block of code to test for exceptions.               |
| `catch`    | Defines a block of code to handle exceptions.                 |
| `finally`  | A block that always executes after the `try` or `catch`.      |
| `throw`    | Throws an exception manually.                                 |
| `throws`   | Indicates what exceptions a method can throw.                 |

## 📚 **5. Primitive Data Types**
Java has built-in types for holding values.

| Keyword   | Description                                                    |
|-----------|----------------------------------------------------------------|
| `byte`    | An 8-bit integer.                                              |
| `short`   | A 16-bit integer.                                              |
| `int`     | A 32-bit integer.                                              |
| `long`    | A 64-bit integer.                                              |
| `float`   | A 32-bit floating point number.                                |
| `double`  | A 64-bit floating point number.                                |
| `boolean` | A true/false value.                                            |
| `char`    | A 16-bit Unicode character.                                    |
| `void`    | Indicates a method that returns no value.                      |

## 📚 **6. Variable and Method Modifiers**
These define how classes, variables, and methods are treated.

| Keyword        | Description                                                            |
|----------------|------------------------------------------------------------------------|
| `static`       | Declares a class-level variable or method (doesn't belong to an instance). |
| `final`        | Declares constants or restricts method overriding and inheritance.     |
| `abstract`     | Declares an abstract class or method.                                  |
| `volatile`     | Indicates that a variable can be changed asynchronously by multiple threads. |
| `transient`    | Prevents serialization of certain fields.                              |
| `synchronized` | Controls the access of multiple threads to a method or block of code.  |
| `native`       | Indicates that a method is implemented in platform-dependent code.     |
| `strictfp`     | Restricts floating-point calculations to ensure portability.           |

## 📚 **7. Miscellaneous Keywords**
These provide special functionality or enable advanced features.

| Keyword    | Description                                                    |
|------------|----------------------------------------------------------------|
| `package`  | Defines the package that a class belongs to.                   |
| `import`   | Imports other classes or packages.                             |
| `assert`   | Tests the truth of a condition during debugging.               |
| `const`    | Reserved, not used.                                            |
| `goto`     | Reserved, not used.                                            |
| `null`     | Represents the null reference.                                 |
| `true`     | Boolean literal representing true.                             |
| `false`    | Boolean literal representing false.                            |

## 📚 **8. Sealed Classes** *(Introduced in Java 17)*  
Java 17 introduces **sealed classes** to restrict which classes can extend or implement a class or interface.

| Keyword      | Description                                                     |
|--------------|-----------------------------------------------------------------|
| `sealed`     | Declares a class that restricts which other classes can extend it. |
| `non-sealed` | A subclass that extends a `sealed` class but can be extended by other classes. |
| `permits`    | Specifies the classes that are allowed to extend a `sealed` class. |

---

### 🎉 **Summary**
These **Java 17 keywords** form the building blocks of the language, enabling a rich variety of constructs, including control flow, object-oriented programming, exception handling, and more. They ensure that your code adheres to the Java standard and provides structured and maintainable programs.
