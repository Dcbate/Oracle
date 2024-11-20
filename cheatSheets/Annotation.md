
# Understanding Custom Annotations in Java (with Spring Examples)

## What are Custom Annotations?

Annotations in Java are a form of metadata that provide additional information to the compiler or runtime. While Java comes with many built-in annotations (e.g., `@Override`, `@Deprecated`), you can define **custom annotations** to suit specific needs in your application.

Custom annotations are:
- A way to standardize repetitive logic.
- Used to attach metadata to code that can be processed at compile-time or runtime.

---

## How Custom Annotations Work

1. **Definition**: You define a custom annotation using the `@interface` keyword.
2. **Retention Policy**: Specifies how long the annotation information is retained:
   - **SOURCE**: Available only at compile-time (ignored at runtime).
   - **CLASS**: Stored in the `.class` file but not available at runtime.
   - **RUNTIME**: Available at runtime using reflection.
3. **Target**: Specifies where the annotation can be applied (e.g., methods, fields, classes).
4. **Processing**: Custom annotations can be processed using reflection or tools like Spring AOP.

---

## Example 1: Sending Method Results to a Pub/Sub Queue

### Use Case

You want to:
1. Annotate methods whose results should be published to a Pub/Sub queue.
2. Automatically send the method result to a queue after the method finishes execution.

### Implementation

**Define the Annotation:**

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PublishToQueue {
    String queueName(); // Specify the queue name
}
```

**Process with Spring AOP:**

```java
@Aspect
@Component
public class PublishToQueueAspect {

    @Autowired
    private PubSubService pubSubService;

    @Around("@annotation(publishToQueue)")
    public Object handlePublishToQueue(ProceedingJoinPoint joinPoint, PublishToQueue publishToQueue) throws Throwable {
        Object result = joinPoint.proceed(); // Proceed with the method
        pubSubService.publish(publishToQueue.queueName(), result); // Publish result
        return result;
    }
}
```

**Use the Annotation:**

```java
@Service
public class OrderService {

    @PublishToQueue(queueName = "order-updates")
    public String createOrder(String orderDetails) {
        return "Order created: " + orderDetails;
    }
}
```

---

## Example 2: Automatic Validation for Method Parameters

### Use Case

You want to:
1. Annotate methods to validate their parameters automatically.
2. Avoid repetitive validation logic.

### Implementation

**Define the Annotation:**

```java
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    String message() default "Parameter cannot be null";
}
```

**Process with Spring AOP:**

```java
@Aspect
@Component
public class NotNullAspect {

    @Around("execution(* *(.., @NotNull (*), ..)) && args(.., param, ..)")
    public Object validateNotNull(ProceedingJoinPoint joinPoint, Object param) throws Throwable {
        if (param == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }
        return joinPoint.proceed(); // Proceed with the method
    }
}
```

**Use the Annotation:**

```java
@Service
public class UserService {

    public void registerUser(@NotNull String username) {
        System.out.println("User registered: " + username);
    }
}
```

---

## Example 3: Role-Based Access Control (RBAC)

### Use Case

You want to:
1. Annotate methods with specific roles that are allowed to execute them.
2. Enforce security rules dynamically at runtime.

### Implementation

**Define the Annotation:**

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {
    String[] roles();
}
```

**Process with Spring AOP:**

```java
@Aspect
@Component
public class SecurityAspect {

    @Around("@annotation(secured)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint, Secured secured) throws Throwable {
        // Simulate a security context
        String currentUserRole = "USER";

        for (String role : secured.roles()) {
            if (role.equals(currentUserRole)) {
                return joinPoint.proceed(); // User has access
            }
        }

        throw new SecurityException("Access denied for role: " + currentUserRole);
    }
}
```

**Use the Annotation:**

```java
@Service
public class AdminService {

    @Secured(roles = {"ADMIN"})
    public void deleteAccount(String accountId) {
        System.out.println("Account deleted: " + accountId);
    }
}
```

---

## Additional Use Cases

### 1. **Custom Caching**
Annotate methods to cache their results dynamically.

**Example:**
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheResult {
    String cacheName();
}
```

**Use Case:** Automatically store and retrieve results from a cache for performance optimization.

---

### 2. **Auditing**
Log method invocations for auditing purposes.

**Example:**
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Audit {
    String action();
}
```

**Use Case:** Capture method execution details for compliance or debugging.

---

### 3. **Retry Logic**
Retry failed methods with configurable attempts.

**Example:**
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {
    int attempts() default 3;
    long delay() default 1000; // Delay in milliseconds
}
```

**Use Case:** Automatically retry transient failures like network calls.

---

### 4. **Metrics Collection**
Track execution time or method calls for monitoring.

**Example:**
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Metric {
    String name();
}
```

**Use Case:** Collect performance metrics for application monitoring.

---

## Common Pitfalls

1. **Reflection Overhead**: Overuse of annotations with reflection may impact performance.
2. **Incorrect Retention Policy**: Use `RetentionPolicy.RUNTIME` for runtime processing.
3. **Complex Logic in Aspects**: Keep annotation-related logic lightweight to maintain readability 