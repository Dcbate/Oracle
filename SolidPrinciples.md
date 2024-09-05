# SOLID Principles

## Introduction
In development, we strive to create maintainable, scalable, and flexible code. As we grow as a team and platform, just like in life, the goal is to make it easier for people who follow us. These principles establish a design that everyone can follow. The SOLID acronym was introduced by Robert C. Martin (2000). We should always write code with the idea of a new joiner 5 years from now being able to understand and build on our software. We should take pride in our work and avoid leaving tech debt for colleagues to clean up in the future. In this course, you will learn what these principles are but, more importantly, understand why we use them.

## Single Responsibility Principle (SRP)
This principle states that a class should have only one reason to change, meaning a class should only have one job or responsibility. For example, if you want to create software that creates a new user account, generates a report, and sends out an email, the class would break the SRP if it handled all these tasks in one place.

### Example:
If we want to change the report format, email title, or how we create users, we would need to change the class for each of these changes, which is not ideal. By refactoring, we separate these concerns into different classes, making it easier to follow, maintain, and test.

### Interpretation:
Sometimes, the boundaries of a class's responsibility can be subjective. While we might think one class does too much or not enough, discussing these perspectives within a team can help achieve a clearer design.


---

## Open-Closed Principle (OCP)
The Open-Closed Principle states that classes should be open for extension but closed for modification. This means we should design code in such a way that new features can be added with minimal changes to existing code. While this isn't always possible, using techniques such as inheritance, polymorphism, and the factory pattern can help achieve this.

### Example:
A transport cost calculator that requires new transport modes can break OCP if we have to modify the existing class every time a new mode is introduced. By refactoring the design, we can make the base class extensible without modifying it.

### Interpretation:
In some cases, modification might be necessary when significant changes occur, but we should always aim to minimize the need for modification by planning for future extensibility.


---

## Liskov Substitution Principle (LSP)
The Liskov Substitution Principle states that child classes must be substitutable for their parent classes without breaking the application.

### Example:
If a Penguin class extends a Bird class that includes a `fly` method, but penguins can't fly, this violates LSP. Instead, we should create a separate FlyingBird class, and ensure Penguin doesn’t inherit `fly`.

### Interpretation:
Though LSP is mostly relevant in library code, it's essential to use inheritance correctly. However, in practice, composition is often favored over inheritance.


---

## Interface Segregation Principle (ISP)
The Interface Segregation Principle states that large interfaces should be broken down into smaller, more specific ones.

### Example:
A MediaPlayer interface with methods for both audio and video would force a Radio class to implement methods it doesn't need, such as `playVideo()`. This violates ISP. By splitting the interface into smaller, relevant interfaces, such as AudioPlayer and VideoPlayer, we can avoid this issue.

### Interpretation:
ISP promotes small, focused interfaces, much like SRP promotes single-responsibility classes. Following ISP makes code easier to maintain and understand.

---

## Dependency Inversion Principle (DIP)
The Dependency Inversion Principle states that high-level modules should not depend on low-level modules. Both should depend on abstractions, and abstractions should not depend on details.

### Example:
If a TransactionManager depends directly on a CashPayment class, adding new payment methods like CardPayment would require changes to TransactionManager. By using an interface like Payment, we can add new payment methods without modifying the TransactionManager.

### Interpretation:
DIP encourages decoupling between classes, making code more flexible and easier to extend.

---

## Conclusion
In this course, we have covered the five principles of object-oriented design. These guidelines help create maintainable, flexible software systems. While we may have different ideas on coding practices, the SOLID principles provide a strong foundation for object-oriented programming (OOP) and will continue to do so in the future.