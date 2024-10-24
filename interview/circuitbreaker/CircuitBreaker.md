
# 🚧 Problem: Implement a Circuit Breaker with a Supplier in Java

You are tasked with implementing a **Circuit Breaker** pattern in Java. The circuit breaker should wrap a **supplier function** (`Supplier<T>`) and control the execution of the function based on failure thresholds and timeouts. If too many failures occur in a given time window, the circuit should "trip," blocking further calls for a configurable timeout period.

## Requirements

1. **Circuit Breaker Method**:
    - Implement a method `public <T> T execute(Supplier<T> supplier)` that executes the given supplier.
    - If the supplier call succeeds, return the result.
    - If it fails (throws an exception), record the failure.
    - If the failure count exceeds a configurable threshold within a specified time window, the circuit breaker should **trip** and block further calls for a **timeout** period.
    - After the timeout has expired, the circuit breaker should reset and allow calls again.

2. **Configuration**:
    - You need to support three key configurations:
        - **Threshold**: The number of failures within a time window that will trigger the circuit breaker to trip.
        - **Failure Time Window**: The time window during which failures are monitored (e.g., 1 minute).
        - **Timeout**: The amount of time (in milliseconds or seconds) the circuit should stay open (i.e., blocking requests) after tripping.

3. **States**:
    - **Closed**: The circuit breaker is operating normally. It allows calls and tracks failures.
    - **Open**: The circuit breaker is tripped, and no calls are allowed for the configured timeout period.

## Method Signature

```java
public <T> T execute(Supplier<T> supplier) throws CircuitBreakerOpenException {
    // implementation goes here
}
```

## Detailed Requirements

1. **Threshold**: When the number of failures within the specified time window exceeds the threshold, the circuit breaker should trip.

2. **Timeout**: After tripping, the circuit should remain open (i.e., no calls are allowed) for a specified timeout period. Once the timeout expires, the circuit should transition to **Half-Open** state.

