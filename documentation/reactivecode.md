
# Reactive Programming in Java Using `Flux` and `Mono`

Reactive programming allows us to handle asynchronous data streams effectively, making applications more efficient, especially under high concurrency. Project Reactor offers two primary classes for reactive streams:

- **`Mono<T>`**: Represents a single value or an empty result.
- **`Flux<T>`**: Represents a stream of 0 to many elements.

---

### 1. Getting Started with `Mono`

**Creating a `Mono`:**
```java
Mono<String> mono = Mono.just("Hello, Mono!");
```

**Empty and Error Monos:**
```java
Mono<String> emptyMono = Mono.empty();
Mono<String> errorMono = Mono.error(new RuntimeException("An error occurred"));
```

**Transforming Data with `Mono`:**
```java
Mono<String> mono = Mono.just("hello")
                        .map(String::toUpperCase); // "HELLO"
```

**Subscribing to `Mono`:**
```java
mono.subscribe(System.out::println); // Outputs: HELLO
```

---

### 2. Getting Started with `Flux`

**Creating a `Flux`:**
```java
Flux<String> flux = Flux.just("Spring", "Reactor", "Flux");
```

**Creating a Range Flux:**
```java
Flux<Integer> rangeFlux = Flux.range(1, 5); // 1 to 5
```

**Subscribing to `Flux`:**
```java
flux.subscribe(System.out::println); // Spring, Reactor, Flux
```

**Transforming Data with `Flux`:**
```java
Flux<String> transformedFlux = flux.map(String::toUpperCase);
transformedFlux.subscribe(System.out::println); // SPRING, REACTOR, FLUX
```

---

### 3. Error Handling in `Mono` and `Flux`

Project Reactor provides operators to handle errors gracefully.

**Example with `Mono`:**
```java
Mono<String> mono = Mono.error(new RuntimeException("Error!"))
                        .onErrorReturn("Fallback value");
mono.subscribe(System.out::println); // Fallback value
```

**Example with `Flux`:**
```java
Flux<String> flux = Flux.just("data", "error", "more data")
                        .map(value -> {
                            if (value.equals("error")) throw new RuntimeException("Error!");
                            return value;
                        })
                        .onErrorResume(e -> Flux.just("Recovered data"));

flux.subscribe(System.out::println); // data, Recovered data
```

---

### 4. Combining `Mono` and `Flux`

Reactive programming allows merging, concatenating, and zipping streams to create complex asynchronous flows.

**Concatenation:**
```java
Flux<String> flux1 = Flux.just("a", "b", "c");
Flux<String> flux2 = Flux.just("1", "2", "3");

Flux<String> combinedFlux = Flux.concat(flux1, flux2);
combinedFlux.subscribe(System.out::println); // a, b, c, 1, 2, 3
```

**Merging (for concurrent streams):**
```java
Flux<String> mergedFlux = Flux.merge(flux1, flux2);
mergedFlux.subscribe(System.out::println); // interleaved order
```

**Zipping:**
```java
Flux<String> zippedFlux = Flux.zip(flux1, flux2, (a, b) -> a + b);
zippedFlux.subscribe(System.out::println); // a1, b2, c3
```

---

### 5. Practical Example: CRUD Operations with Reactive Repository, Service, and Controller

#### Step 1: Reactive Repository

In Spring Data with reactive support, define a repository interface by extending `ReactiveCrudRepository`.

```java
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
    Flux<User> findByRole(String role); // Custom query for users by role
}
```

---

#### Step 2: Reactive Service Layer

The service layer contains business logic. Use `Mono` and `Flux` for non-blocking data processing.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> getUserById(String id) {
        return userRepository.findById(id)
                             .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                             .flatMap(existingUser -> {
                                 existingUser.setName(updatedUser.getName());
                                 existingUser.setRole(updatedUser.getRole());
                                 return userRepository.save(existingUser);
                             })
                             .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }

    public Flux<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }
}
```

---

#### Step 3: Reactive Controller

Expose endpoints for clients, returning `Mono` and `Flux` responses directly.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Mono<User> updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/role/{role}")
    public Flux<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }
}
```

---

#### Sample `User` Entity

Here’s a sample `User` entity for this example.

```java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String role;

    // Constructors, getters, and setters
    public User() {}

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
```

---

### 6. Testing Reactive Code

To test reactive services, use `StepVerifier`, a utility from Project Reactor for testing `Mono` and `Flux` sequences:

```java
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        Mono<User> userMono = userService.getUserById("1");

        StepVerifier.create(userMono)
                    .expectNextMatches(user -> user.getName().equals("Alice"))
                    .verifyComplete();
    }

    @Test
    public void testGetAllUsers() {
        Flux<User> usersFlux = userService.getAllUsers();

        StepVerifier.create(usersFlux)
                    .expectNextCount(3) // Expect 3 users
                    .verifyComplete();
    }
}
```

---

### Summary of Key Operators

| Operator          | Description                                               |
|-------------------|-----------------------------------------------------------|
| `just`            | Creates a `Mono` or `Flux` with a specific value.         |
| `map`             | Transforms each emitted item using a function.            |
| `flatMap`         | Transforms items asynchronously into other publishers.    |
| `onErrorReturn`   | Provides a fallback value if an error occurs.             |
| `concat`          | Concatenates multiple `Flux` or `Mono` instances in sequence. |
| `merge`           | Merges multiple publishers concurrently.                  |
| `zip`             | Combines elements from multiple sources.                  |

---

