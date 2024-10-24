package interview.circuitbreaker;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

public class CircuitBreaker {

    private final int failureThreshold;  // Max failures before circuit trips
    private final Duration timeout;      // Time to wait in OPEN state
    private final Duration failureTimeWindow;  // Time window to monitor failures
    private Queue<Instant> failureTimestamps = new LinkedList<>(); // Queue to hold failure timestamps
    private boolean isOpen = false;      // Circuit state: Open or Closed
    private Instant lastFailureTime;     // Last time the circuit tripped

    /**
     * Creates a new CircuitBreaker instance.
     *
     * @param failureThreshold The number of failures allowed before the circuit trips.
     * @param failureTimeWindow The time window during which failures are monitored.
     * @param timeout The duration for which the circuit remains OPEN once it trips.
     */
    public CircuitBreaker(int failureThreshold, Duration failureTimeWindow, Duration timeout) {
        this.failureThreshold = failureThreshold;
        this.failureTimeWindow = failureTimeWindow;
        this.timeout = timeout;
    }

    /**
     * Executes the given supplier. If the circuit is OPEN, it will block execution.
     * If the supplier throws an exception, the failure is recorded, and the circuit
     * will trip if the failure threshold is exceeded within the time window.
     *
     * @param supplier The function to execute.
     * @param <T> The return type of the supplier.
     * @return The result from the supplier, or null if the circuit is OPEN or the supplier fails.
     * @throws CircuitBreakerOpenException If the circuit is OPEN and execution is blocked.
     */
    public <T> T execute(Supplier<T> supplier) throws CircuitBreakerOpenException {
        // Check if the circuit is open
        if (isOpen) {
            // If timeout period has passed, reset to closed
            if (Instant.now().isAfter(lastFailureTime.plus(timeout))) {
                isOpen = false;
                failureTimestamps.clear(); // Reset failure history after timeout
                System.out.println("Circuit reset to CLOSED after timeout.");
            } else {
                System.out.println("Circuit is OPEN. Try again later.");
                return null;
            }
        }

        try {
            // Try executing the supplier if circuit is not open
            T result = supplier.get();
            onSuccess();
            System.out.println("Supplier executed successfully.");
            return result;
        } catch (Exception e) {
            // On failure, record the error
            onFailure();
            System.out.println("Supplier execution failed.");
            return null;
        }
    }

    /**
     * Called when the supplier succeeds. Clears the failure history.
     */
    private void onSuccess() {
        // Clear failure history if the operation succeeds
        failureTimestamps.clear();
        System.out.println("Operation succeeded. Resetting failure history.");
    }

    /**
     * Called when the supplier fails. Records the failure and checks if the
     * failure threshold has been reached within the failure time window.
     */
    private void onFailure() {
        Instant now = Instant.now();
        failureTimestamps.add(now);
        System.out.println("Operation failed. Failure timestamp added: " + now);

        // Remove failures outside the failure time window
        while (!failureTimestamps.isEmpty() && failureTimestamps.peek().isBefore(now.minus(failureTimeWindow))) {
            Instant removed = failureTimestamps.poll();
            System.out.println("Removed old failure timestamp: " + removed);
        }

        System.out.println("Number of Errors: " + failureTimestamps.size());

        // If failures exceed the threshold within the time window, open the circuit
        if (failureTimestamps.size() >= failureThreshold) {
            isOpen = true;
            lastFailureTime = now;
            System.out.println("Circuit breaker tripped! Circuit is now OPEN.");
        }
    }

    /**
     * Custom exception to indicate the circuit breaker is open and blocking execution.
     */
    public static class CircuitBreakerOpenException extends RuntimeException {
        public CircuitBreakerOpenException(String message) {
            super(message);
        }
    }
}