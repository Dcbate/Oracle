 Understanding Custom Annotations in Java (with Spring Examples)

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

## When to Use Custom Annotations

- **Code Reusability**: Standardize and encapsulate common patterns (e.g., logging, validation).
- **Cross-Cutting Concerns**: Handle concerns like security, auditing, or transactions using annotations with Spring AOP.
- **Configuration**: Provide metadata to configure services or components dynamically.
- **Validation**: Simplify validation logic for objects.

---

## Creating a Custom Annotation

### 1. Define the Annotation

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This annotation can only be applied to methods
@Target(ElementType.METHOD)
// Retention policy ensures the annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
```

- **`@Target`**: Restricts the annotation to methods (`ElementType.METHOD`).
- **`@Retention`**: Keeps the annotation metadata available at runtime.

---

### 2. Process the Annotation

You can process the annotation using:
- **Reflection**: Manually inspect and act on the annotation.
- **Spring AOP**: Automate behavior for annotated components.

#### Using Spring AOP:

1. Add the annotation to a method:

```java
@Service
public class MyService {

    @LogExecutionTime
    public void performTask() {
        // Simulate a task
        System.out.println("Task is being performed...");
    }
}
```

2. Create an AOP Aspect to Handle the Annotation:

```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Proceed with the method execution
        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) + "ms");
        return result;
    }
}
```

3. Enable AspectJ in Spring:

```java
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
}
```

---

## Example Workflow

1. The `@LogExecutionTime` annotation is added to a method.
2. When the method is called, the AOP `@Aspect` intercepts the call.
3. The logic inside `LogExecutionTimeAspect` is executed, logging the execution time.

---

## Advanced Custom Annotations

### Adding Parameters to Annotations

Annotations can have parameters for flexibility:

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {
    int attempts() default 3; // Default value
    long delay() default 1000; // Delay in milliseconds
}
```

#### Example Usage:

```java
@Retry(attempts = 5, delay = 2000)
public void connectToService() {
    // Retry logic
}
```

### Processing Parameters in the AOP Aspect

```java
@Aspect
@Component
public class RetryAspect {

    @Around("@annotation(retry)")
    public Object retryLogic(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        int attempts = retry.attempts();
        long delay = retry.delay();

        for (int i = 0; i < attempts; i++) {
            try {
                return joinPoint.proceed();
            } catch (Exception e) {
                if (i == attempts - 1) throw e;
                Thread.sleep(delay);
            }
        }
        return null;
    }
}
```

---

## Common Pitfalls

1. **Incorrect Retention Policy**: Ensure you use `RetentionPolicy.RUNTIME` if you want to process annotations at runtime.
2. **Misconfigured AOP**: Forgetting to enable `@EnableAspectJAutoProxy` can result in your aspect not working.
3. **Reflection Overhead**: Overusing annotations with reflection can impact performance.

---

## Summary

- Custom annotations encapsulate reusable logic and reduce boilerplate code.
- Using Spring AOP, you can create powerful features like logging, retry mechanisms, and security.
- Always choose meaningful names and use parameters to make your annotations flexible.

---

### Full Example

**Custom Annotation:**

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
```

**Service:**

```java
@Service
public class MyService {

    @LogExecutionTime
    public void performTask() {
        System.out.println("Task is being performed...");
    }
}
```

**Aspect:**

```java
@Aspect
@Component
public class LogExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) + "ms");
        return result;
    }
}
```
