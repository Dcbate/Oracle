# 🌟 **SOLID Principles** 🌟

## 🛠️ **Introduction**
In development, we strive to create **maintainable**, **scalable**, and **flexible** code. As we grow as a team and platform, just like in life, the goal is to make it easier for people who follow us. These principles establish a design that everyone can follow. The **SOLID** acronym was introduced by *Robert C. Martin* in 2000. We should always write code with the idea of a new joiner 5 years from now being able to understand and build on our software. We should take pride in our work and avoid leaving tech debt for colleagues to clean up in the future. In this course, you will learn what these principles are but, more importantly, understand **why** we use them.

---

## 📏 **Single Responsibility Principle (SRP)**
> **A class should have only one reason to change**, meaning a class should only have one job or responsibility.

This Principle states a class should have only one reason to change. Which really means a class should only have one job, one responsibility. Let’s have a look at an example, say I want to create some software that creates a new user account, generates you a report based on that, and then sends out an email with that report. Looking at the code snippet below

### 🚫 **Code that Breaks SRP:**
```java
class UserCreationReportEmail {
    public void createUser() {
        // code to create user
    }

    public void generateReport() {
        // code to generate report
    }

    public void sendEmail() {
        // code to send email
    }
}


```

you can see it breaks SRP. We have one class with more than one reasonability. With more than one reason to change. We would need to change this class if we wanted to change the information we needed to create a new user, we would have to change the class if we wanted to generate a different report format, we would want to change this class if we wanted to change the title of the email we send out. These are only a few examples, I’m sure you can think of more.  Let’s look at how this code could be written.

### ✅ Code that Follows SRP:


```java
class UserCreator {
    public void createUser() {
        // code to create user
    }
}

class ReportGenerator {
    public void generateReport() {
        // code to generate report
    }
}

class EmailSender {
    public void sendEmail() {
        // code to send email
    }
}

```

You can see now that each class only has one reasonability in the flow. We have made the code easier to follow, easier to maintain, easier to test, easier to organise. We know now in 5 years’ time if anyone needed to make a change to the way we generate reports, there is only one class they should change. The ReportGenerator class. If an error was to occur with the emails not being sent out, we would know what class to look for. This is the Single Responsibility Principle.

### 💡 Interpretation:
Sometimes, the boundaries of a class's responsibility can be subjective. While we might think one class does too much or not enough, discussing these perspectives within a team can help achieve a clearer design.


---

## 🔄 Open-Closed Principle (OCP)
The Open-Closed Principle states that classes should be open for extension but closed for modification. This means we should design code in such a way that new features can be added with minimal changes to existing code. While this isn't always possible, using techniques such as inheritance, polymorphism, and the factory pattern can help achieve this.

### Example:
A transport cost calculator that requires new transport modes can break OCP if we have to modify the existing class every time a new mode is introduced. By refactoring the design, we can make the base class extensible without modifying it.

In this example we have created a class to calculate how much your transport will cost. This does not follow the Open-Closed Principle. If we have a new mode of transport (Car) to add we will have to modify the TransportCalculator class. Lets have a look at how the code can be written so that when we add the Car transport we extend the code instead of modifying existing code.

### 🚫 Code that Breaks OCP:

```java
class TransportCalculator {
    public double calculateCost(String transportType) {
        if (transportType.equals("Bus")) {
            return 1.50;
        } else if (transportType.equals("Train")) {
            return 2.50;
        }
        return 0;
    }
}
```

### ✅ Code that Follows OCP:

```java
interface Transport {
    double calculateCost();
}

class Bus implements Transport {
    public double calculateCost() {
        return 1.50;
    }
}

class Train implements Transport {
    public double calculateCost() {
        return 2.50;
    }
}

class TransportCalculator {
    public double calculateCost(Transport transport) {
        return transport.calculateCost();
    }
}
```

We have the class TransportCalculator that will no longer be modified, instead we have extended the code by added a new class called Car which implements the Transport interface. Ensuring the TransportCalculator stays closed for modification.

A massive benefit is that we have prevented a developer in 5 year’s time from needing to change exiting tried and tested code, which in this case is TransportCalculator. Which will give them greater confidence they are not introducing a new bug by changing existing code.

### 💡 Interpretation:
In some cases, modification might be necessary when significant changes occur, but we should always aim to minimize the need for modification by planning for future extensibility.


---

## 🦢 Liskov Substitution Principle (LSP)
The Liskov Substitution Principle states that child classes must be substitutable for their parent classes without breaking the application.

### Example:
If a Penguin class extends a Bird class that includes a `fly` method, but penguins can't fly, this violates LSP. Instead, we should create a separate FlyingBird class, and ensure Penguin doesn’t inherit `fly`.


As you can see in this example the child class Penguin is not substitutable for the bird class, as it we now throw an exception when the fly method is called. This breaks the LSP. We should fix this by not extending Penguin with Bird. Instead what we should do is create a new class called FlyingBird for example. Which will have the fly method. And the Penguin class would not extend this. Lets look at this in the code :
### 🚫 Code that Breaks LSP:

```java
class Bird {
    public void fly() {
        // fly logic
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```
### ✅ Code that Follows LSP:


```java
class Bird {
    // bird logic
}

class FlyingBird extends Bird {
    public void fly() {
        // fly logic
    }
}

class Penguin extends Bird {
    // penguin-specific logic, no fly method
}
```

We can now see that all child class can be substituted for their parent ones. So, we are adhering to the principle.

### 💡 Interpretation:
Though LSP is mostly relevant in library code, it's essential to use inheritance correctly. However, in practice, composition is often favored over inheritance.


---

## 🎛️ Interface Segregation Principle (ISP)
The Interface Segregation Principle states that large interfaces should be broken down into smaller, more specific ones.

### Example:
A MediaPlayer interface with methods for both audio and video would force a Radio class to implement methods it doesn't need, such as `playVideo()`. This violates ISP. By splitting the interface into smaller, relevant interfaces, such as AudioPlayer and VideoPlayer, we can avoid this issue.

### 🚫 Code that Breaks ISP:
```java
interface MediaPlayer {
    void playAudio();
    void playVideo();
}

class Radio implements MediaPlayer {
    public void playAudio() {
        // play audio logic
    }

    public void playVideo() {
        throw new UnsupportedOperationException("Radio can't play video");
    }
}
```

This is a bad design, we have the MediaPlayer which is too large. We have the Radio that implements the interface. So that will need to implement all methods, which includes play video method. A Radio cannot play video.  We can see this breaks ISP. I hope you can see how this also relates to other principles such as LSP and SRP. A lot of these principles work hand in hand. IF you adhere to one you are adhering to others. Let’s look at some code that adheres to ISP.

### ✅ Code that Follows ISP:
```java

interface AudioPlayer {
    void playAudio();
}

interface VideoPlayer {
    void playVideo();
}

class Radio implements AudioPlayer {
    public void playAudio() {
        // play audio logic
    }
}

class TV implements AudioPlayer, VideoPlayer {
    public void playAudio() {
        // play audio logic
    }

    public void playVideo() {
        // play video logic
    }
}

```

We have now two interfaces for each function. This allows us to implement the correct interfaces into TV and Radio class correctly. So, Radio and TV only have methods relevant to them. This makes the code clearer and easier to maintain.

### 💡 Interpretation:
ISP promotes small, focused interfaces, much like SRP promotes single-responsibility classes. Following ISP makes code easier to maintain and understand.

---

## 🔄 Dependency Inversion Principle (DIP)
The Dependency Inversion Principle states that high-level modules should not depend on low-level modules. Both should depend on abstractions, and abstractions should not depend on details.

### Example:
If a TransactionManager depends directly on a CashPayment class, adding new payment methods like CardPayment would require changes to TransactionManager. By using an interface like Payment, we can add new payment methods without modifying the TransactionManager.


In this example we have a simple TransactionManager that takes the Cashpayment class and calls the pay method. This works fine. But we are not following the DIP. We are not thinking about the developer in 5 years’ time. What happens when a new payment method comes in? We now want to pay by Card. Because we have tightly coupled Cash Payment with TransactionManager. We need to change the TransactionManager code when we need to add a new payment method. This is not good practice.  Let’s see have we could have coded this in the first place to follow DIP.
### 🚫 Code that Breaks DIP:

```java

class CashPayment {
    public void pay() {
        // pay logic
    }
}

class TransactionManager {
    private CashPayment cashPayment;

    public TransactionManager(CashPayment cashPayment) {
        this.cashPayment = cashPayment;
    }

    public void processTransaction() {
        cashPayment.pay();
    }
}
```
We have now coded to an interface called payment. So, if the same requirement came in adding the card payment would not require us to touch TransactionManager. We can add a new class that implements Payment.

Looking forward we can then also add other payment methods the same way, for example if ApplePayment needed to be added we could.  We have isolated the TransactionManager class so that it only needs a payment class, the payment class it needs is not coupled directedly to how the TransactionManager behaves.

### ✅ Code that Follows DIP:

```java
interface Payment {
    void pay();
}

class CashPayment implements Payment {
    public void pay() {
        // pay logic
    }
}

class CardPayment implements Payment {
    public void pay() {
        // card pay logic
    }
}

class TransactionManager {
    private Payment payment;

    public TransactionManager(Payment payment) {
        this.payment = payment;
    }

    public void processTransaction() {
        payment.pay();
    }
}
```

### 💡 Interpretation:
DIP encourages decoupling between classes, making code more flexible and easier to extend.

---

## Testing
We have not mentioned testing in any of these principles, but it you follow them when it comes to writing tests it should be very easy. Writing 100% coverage with simple unit tests should come easier than writing the code. If you are struggling to test a class your design is wrong, and I would revisit the SOLID principles above.


## 🏁 Conclusion
In this course, we have covered the five principles of object-oriented design. These guidelines help create maintainable, flexible software systems. While we may have different ideas on coding practices, the SOLID principles provide a strong foundation for object-oriented programming (OOP) and will continue to do so in the future.~~

Happy coding! 🚀
