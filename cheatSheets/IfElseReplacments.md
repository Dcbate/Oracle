
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
