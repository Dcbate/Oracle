package interview.circuitbreaker;

import java.time.Duration;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {


        // Circuit breaker that allows 3 failures in a 10-second window and has a 5-second timeout
        CircuitBreaker circuitBreaker = new CircuitBreaker(8, Duration.ofSeconds(10), Duration.ofSeconds(5));

        circuitBreaker.execute(someUnreliableMethod());
        circuitBreaker.execute(someUnreliableMethod());
        circuitBreaker.execute(someUnreliableMethod());
        circuitBreaker.execute(someUnreliableMethod());
        circuitBreaker.execute(someUnreliableMethod());
        circuitBreaker.execute(someUnreliableMethod());
        circuitBreaker.execute(someUnreliableMethod());
        circuitBreaker.execute(someUnreliableMethod());



    }

    private static Supplier<String> someUnreliableMethod() {
        return () -> {
            // Simulate a failing supplier
            if (Math.random() > 0.9) {
                return "Success!";
            } else {
                throw new RuntimeException("Failure!");
            }
        };
    }
}