package interview.circuitbreaker;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

public class CircuitBreaker {

    // Circuit Breaker configuration parameters:
    // failureThreshold: Maximum number of failures allowed before the circuit trips to "Open" state
    private final int failureThreshold;

    // timeout: Duration for which the circuit remains "Open" (i.e., blocks further calls) once tripped
    private final Duration timeout;

    // failureTimeWindow: The time window within which the failureThreshold is checked. Failures outside
    // this window are discarded, allowing the system to reset after intermittent issues.
    private final Duration failureTimeWindow;

    // Queue is chosen here to store the timestamps of each failure. A Queue (FIFO structure) helps us track
    // failures and easily remove old ones as time progresses, making it suitable for managing sliding windows of time.
    private Queue<Instant> failureTimestamps = new LinkedList<>();

    // isOpen: Boolean flag to indicate whether the circuit is in "Open" state or "Closed" state.
    // "Open" means no further execution is allowed.
    private boolean isOpen = false;

    // lastFailureTime: Records the last time the circuit tripped to "Open" state. It is used to track when
    // the circuit should close again after the timeout.
    private Instant lastFailureTime;

    /**
     * Constructor for the CircuitBreaker class. Initializes the circuit breaker with
     * failureThreshold, failureTimeWindow, and timeout values.
     *
     * @param failureThreshold   The number of consecutive failures allowed before the circuit breaker trips.
     * @param failureTimeWindow  The time window during which the failure count is monitored.
     * @param timeout            The time period the circuit remains "Open" after tripping.
     */
    public CircuitBreaker(int failureThreshold, Duration failureTimeWindow, Duration timeout) {
        this.failureThreshold = failureThreshold;         // Max failures before circuit trips
        this.failureTimeWindow = failureTimeWindow;       // Time window for tracking failures
        this.timeout = timeout;                           // Duration to stay in the "Open" state
    }

    /**
     * The main method that clients use to execute their supplier function. If the circuit breaker is in
     * the "Closed" state, it will attempt to execute the supplier. If the supplier throws an exception,
     * the failure is recorded. If the circuit is in the "Open" state, execution is blocked.
     *
     * @param supplier The function to execute, supplied as a lambda or method reference.
     * @param <T>      The return type of the supplier.
     * @return         The result of the supplier if successfully executed, or null if the circuit is "Open" or the supplier fails.
     * @throws CircuitBreakerOpenException If the circuit breaker is in the "Open" state and execution is blocked.
     */
    public <T> T execute(Supplier<T> supplier) throws CircuitBreakerOpenException {
        // Check if the circuit is in the "Open" state
        if (isOpen) {
            // If enough time has passed (greater than the configured timeout), reset the circuit to "Closed"
            if (Instant.now().isAfter(lastFailureTime.plus(timeout))) {
                isOpen = false;
                failureTimestamps.clear(); // Clear failure history when resetting the circuit
                System.out.println("Circuit reset to CLOSED after timeout.");
            } else {
                // Circuit is still "Open" and within the timeout period, reject the request
                System.out.println("Circuit is OPEN. Try again later.");
                return null; // Return null to indicate that the supplier execution was blocked
            }
        }

        try {
            // Circuit is "Closed", so we attempt to execute the supplier
            T result = supplier.get();
            onSuccess(); // If successful, call onSuccess to reset failure history
            System.out.println("Supplier executed successfully.");
            return result; // Return the result of the supplier
        } catch (Exception e) {
            // If the supplier throws an exception, record the failure
            onFailure();
            System.out.println("Supplier execution failed.");
            return null; // Return null to indicate the failure
        }
    }

    /**
     * Handles the scenario when the supplier executes successfully. It clears the failure history,
     * allowing the circuit breaker to forget previous failures and remain "Closed."
     */
    private void onSuccess() {
        // When the supplier is successful, we reset the failure history by clearing the queue of timestamps
        failureTimestamps.clear();
        System.out.println("Operation succeeded. Resetting failure history.");
    }

    /**
     * Handles the scenario when the supplier fails (throws an exception). Records the timestamp of the failure,
     * checks if the failure threshold is exceeded within the configured time window, and trips the circuit breaker
     * to the "Open" state if necessary.
     */
    private void onFailure() {
        Instant now = Instant.now();  // Record the current time as the time of failure
        failureTimestamps.add(now);   // Add the timestamp of the failure to the queue
        System.out.println("Operation failed. Failure timestamp added: " + now);

        // Remove failures that occurred outside of the configured failureTimeWindow
        while (!failureTimestamps.isEmpty() && failureTimestamps.peek().isBefore(now.minus(failureTimeWindow))) {
            Instant removed = failureTimestamps.poll(); // Remove the oldest failures
            System.out.println("Removed old failure timestamp: " + removed);
        }

        // Output the current number of failures in the queue
        System.out.println("Number of Errors: " + failureTimestamps.size());

        // If the number of failures within the failureTimeWindow exceeds the threshold, trip the circuit
        if (failureTimestamps.size() >= failureThreshold) {
            isOpen = true; // Set the circuit to "Open" state
            lastFailureTime = now; // Record the time when the circuit tripped
            System.out.println("Circuit breaker tripped! Circuit is now OPEN.");
        }
    }

    /**
     * Custom exception to indicate that the circuit breaker is "Open" and blocking execution.
     * This exception is thrown when a request is attempted while the circuit is in the "Open" state.
     */
    public static class CircuitBreakerOpenException extends RuntimeException {
        public CircuitBreakerOpenException(String message) {
            super(message);
        }
    }
}