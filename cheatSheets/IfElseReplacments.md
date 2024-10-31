
# Refactoring `If-Else` Blocks in Java

Refactoring `if-else` statements enhances code readability, maintainability, and scalability. Here, I provide a variety of techniques along with before-and-after code examples using modern Java features.

---

### 1. `If-Else` to Enhanced `Switch` Expressions

Enhanced `switch` expressions support more flexible syntax, allowing block-scoped statements and returning values directly.

**Before:**

```java
public String getDayType(String day) {
        if ("saturday".equalsIgnoreCase(day) || "sunday".equalsIgnoreCase(day)) {
        return "Weekend";
            } else if ("monday".equalsIgnoreCase(day) || "tuesday".equalsIgnoreCase(day) ||
                "wednesday".equalsIgnoreCase(day) || "thursday".equalsIgnoreCase(day) ||
                "friday".equalsIgnoreCase(day)) {
                     return "Weekday";
            } else {
                throw new IllegalArgumentException("Invalid day: " + day);
            }
        }
```

**After:**

```java
public String getDayType(String day) {
        return switch (day.toLowerCase()) {
                case "saturday", "sunday" -> "Weekend";
                case "monday", "tuesday", "wednesday", "thursday", "friday" -> "Weekday";
                default -> throw new IllegalArgumentException("Invalid day: " + day);
            };
        }
```

**Explanation:**  
Enhanced `switch` expressions allow cleaner, more readable syntax for cases where multiple conditions yield the same result. It can also throw exceptions or return values directly within cases.

---

### 2. Using Spring Factory Pattern for Dependency Injection

Spring provides built-in support for dependency injection, allowing you to inject specific implementations based on conditions, removing the need for `if-else` logic.

**Before:**

```java
public void processPayment(String paymentType) {
        if ("paypal".equalsIgnoreCase(paymentType)) {
                // process PayPal payment
            } else if ("creditcard".equalsIgnoreCase(paymentType)) {
                // process credit card payment
            }
        }
```

**After (Using `@Qualifier` in Spring):**

```java
// Define an interface
public interface PaymentService {
    void processPayment();
}

// Implement multiple services
@Service("paypalService")
public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment");
    }
}

@Service("creditCardService")
public class CreditCardPaymentService implements PaymentService {
    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment");
    }
}

// Inject the specific service based on @Qualifier
@Service
public class PaymentProcessor {
    private final PaymentService paymentService;

    @Autowired
    public PaymentProcessor(@Qualifier("paypalService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void process() {
        paymentService.processPayment();
    }
}
```

**Explanation:**  
Using Spring’s `@Qualifier` annotation allows the injection of specific implementations, which removes the need for `if-else` blocks. This approach enables flexibility and modularity within the application, making it easy to add new payment types.

---

### 3. Spring Factory with All Beans of an Interface Type

To avoid hardcoding bean names, you can inject all beans of a specific interface type in a Spring application and populate a map dynamically.

**Before:**

```java
public NotificationService getNotificationService(String type) {
        if ("email".equalsIgnoreCase(type)) {
                return new EmailNotificationService();
            } else if ("sms".equalsIgnoreCase(type)) {
                return new SMSNotificationService();
            } else {
            throw new IllegalArgumentException("Invalid notification type");
            }
        }
```

**After:**

Using Spring to automatically wire all `NotificationService` beans into a map:

```java
// Define the interface
public interface NotificationService {
    void sendNotification();
    String getType();  // To get the type of the service
}

// Example implementations
@Service
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Sending email notification");
    }

    @Override
    public String getType() {
        return "email";
    }
}

@Service
public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Sending SMS notification");
    }

    @Override
    public String getType() {
        return "sms";
    }
}

// Factory class with all beans automatically wired
@Component
public class NotificationFactory {
    private final Map<String, NotificationService> serviceMap;

    @Autowired
    public NotificationFactory(List<NotificationService> services) {
        serviceMap = services.stream()
                .collect(Collectors.toMap(NotificationService::getType, Function.identity()));
    }

    public NotificationService getNotificationService(String type) {
        return Optional.ofNullable(serviceMap.get(type.toLowerCase()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid notification type"));
    }
}
```

**Explanation:**  
In this approach, Spring injects all `NotificationService` beans, and we use `getType()` to map each service by its type. This eliminates the need for `if-else` blocks, as the factory dynamically finds and injects all services. Adding a new notification type only requires a new class implementing `NotificationService`.

---

### 4. `If-Else` to Factory Pattern (Using `record`)

`record` provides a simplified approach to creating data-carrying classes for a Factory pattern.

**Before:**

```java
public NotificationService getNotificationService(String type) {
    if ("email".equalsIgnoreCase(type)) {
        return new EmailNotificationService();
    } else if ("sms".equalsIgnoreCase(type)) {
        return new SMSNotificationService();
    } else {
        throw new IllegalArgumentException("Invalid notification type");
    }
}
```

**After:**

Using `record` to simplify notification service configuration:

```java
public interface NotificationService {
    void sendNotification();
}

record EmailNotificationService() implements NotificationService {
    public void sendNotification() {
        System.out.println("Sending email notification");
    }
}

record SMSNotificationService() implements NotificationService {
    public void sendNotification() {
        System.out.println("Sending SMS notification");
    }
}

public class NotificationFactory {
    private final Map<String, NotificationService> services = Map.of(
        "email", new EmailNotificationService(),
        "sms", new SMSNotificationService()
    );

    public NotificationService getNotificationService(String type) {
        return Optional.ofNullable(services.get(type.toLowerCase()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid notification type"));
    }
}
```

**Explanation:**  
Using `record` provides a concise way to define immutable classes for the factory pattern, removing boilerplate code for data classes and eliminating `if-else` conditions in service creation.

---

### 5. `If-Else` to Polymorphism

**Before:**

```java
public double applyDiscount(String discountType, double price) {
    if ("christmas".equalsIgnoreCase(discountType)) {
        return price * 0.9;
    } else if ("newyear".equalsIgnoreCase(discountType)) {
        return price * 0.8;
    } else {
        return price;
    }
}
```

**After:**

Using polymorphism with a strategy pattern:

```java
public interface DiscountStrategy {
    double applyDiscount(double price);
}

public class ChristmasDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}

public class NewYearDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.8;
    }
}

public class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price;
    }
}
```

**Explanation:**  
By defining a `DiscountStrategy` interface and implementing specific strategies, we can eliminate the need for `if-else` statements. Each discount type is handled by its own class, simplifying the main code and promoting the **Open/Closed Principle**.

---

### 6. Using `Optional` to Avoid Null Checks

**Before:**

```java
public String getWelcomeMessage(User user) {
    if (user != null && user.getName() != null) {
        return "Welcome, " + user.getName();
    } else {
        return "Welcome, Guest";
    }
}
```

**After:**

```java
public String getWelcomeMessage(Optional<User> user) {
    return user.map(User::getName)
               .map(name -> "Welcome, " + name)
               .orElse("Welcome, Guest");
}
```

**Explanation:**  
Using `Optional` helps avoid explicit null checks, replacing them with functional `map` and `orElse` calls. This approach leads to cleaner and more declarative code.

---

### 7. Using Enums for Decision Making

**Before:**

```java
public double calculateFee(String paymentType, double amount) {
    if ("credit".equalsIgnoreCase(paymentType)) {
        return amount * 1.02;
    } else if ("debit".equalsIgnoreCase(paymentType)) {
        return amount * 1.01;
    } else if ("paypal".equalsIgnoreCase(paymentType)) {
        return amount * 1.03;
    } else {
        throw new IllegalArgumentException("Unsupported payment type");
    }
}
```

**After:**

Using enums with lambda functions:

```java
public enum PaymentType {
    CREDIT(amount -> amount * 1.02),
    DEBIT(amount -> amount * 1.01),
    PAYPAL(amount -> amount * 1.03);

    private final Function<Double, Double> feeCalculator;

    PaymentType(Function<Double, Double> feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public double calculateFee(double amount) {
        return feeCalculator.apply(amount);
    }
}
```

Usage:

```java
public double calculateFee(PaymentType paymentType, double amount) {
    return paymentType.calculateFee(amount);
}
```

**Explanation:**  
By defining `PaymentType` as an enum with specific fee calculators, we avoid `if-else` logic entirely. Each payment type has its own calculation method, making it extensible and adhering to **Single Responsibility Principle**.

---

### 8. Using Predicate Functional Interfaces

Predicates allow you to express conditions as functional interfaces and replace `if-else` statements in scenarios where boolean checks are required.

**Before:**

```java
public boolean isEligible(int age, boolean hasMembership) {
    if (age > 18 && hasMembership) {
        return true;
    }
    return false;
}
```

**After:**

Using Predicate for conditional logic:

```java
import java.util.function.Predicate;

Predicate<Integer> isAdult = age -> age > 18;
Predicate<Boolean> isMember = membership -> membership;

public boolean isEligible(int age, boolean hasMembership) {
    return isAdult.test(age) && isMember.test(hasMembership);
}
```

**Explanation:**  
By using `Predicate` functional interfaces, we can create reusable conditions that can be tested directly. This technique is helpful in replacing simple conditional checks in a declarative manner.

---

### Summary of Techniques

| Technique               | Use Case                                              |
|-------------------------|-------------------------------------------------------|
| **Switch Statements**   | Simple cases based on constant values                 |
| **Spring Factory Pattern** | Injecting specific services based on conditions   |
| **Factory Pattern**     | Object creation based on conditions                   |
| **Polymorphism**        | Handling multiple behaviors for similar actions       |
| **Optional**            | Removing null checks with functional style            |
| **Enums with Lambdas**  | Mapping behavior directly to enum constants           |
| **Command Pattern**     | Encapsulating requests as objects                     |
| **Predicate**           | Filtering conditions with functional interfaces       |

