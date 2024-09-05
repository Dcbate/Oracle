**# Development Guidelines

As a developer, it is part of your responsibility to maintain this document and ensure it stays up to date. Let's collaborate as a team to achieve the highest quality code possible.

## General Coding Rules
- **Leave the code better than you found it:** Tidy up as you go.
- **Take pride in your code:** Craft it with care and attention.
- **Always follow solid principles:** Keep them in mind as you code.
- **Use design patterns when applicable.**
- **Write PRs that are easy to review.**
- **Logging is crucial:** Help production support and SL3 teams.
- **Use annotations:** They make life easier.

---

## Naming Conventions

### Classes
- Use `CamelCase`.
- Prefer nouns and whole words – **no abbreviations**.
- Keep names simple and descriptive.
- Use a pattern for classes with similar functionality (e.g., `RestClient`).
- For classes implementing interfaces, append `Impl` (e.g., `NameImpl`).

### Interfaces
- Follow the same conventions as classes.

### Packages
- Use **all lowercase**.
- Group by functionality (e.g., `controller`).
- Keep names to **one word** if possible.

### Methods
- Use `camelCase` starting with a lowercase letter.
- Begin with a verb to describe the action.
- If the name is too long, the method may be doing too much.
- Use common verbs like `get` and `set`.

### Variables
- Use `camelCase` starting with a lowercase letter.
- Keep names short but meaningful.
- Avoid one-character names, even in lambdas.
- For maps, use names that describe what the map groups (e.g., `studentsByAge`).

### Constants
- Use `UPPERCASE` with `_` for spaces (e.g., `MAX_WIDTH`).

---

## Java 17 Features

We are using **Java 17**, so take full advantage of its features:
- Method references
- Optionals
- Streams
- Records
- Pattern Matching for `switch` statements
- Lambdas
- `var` keyword
- Text blocks

Make an effort to learn and apply these features—they will help in your career. Also, let's start aiming for **Java 21**!

---

## Useful Annotations

### Java Annotations
- `@Deprecated` — Marks deprecated methods, classes, or fields. **Use this to signal that a piece of code should no longer be used.**
- `@Override` — Indicates a method overrides a superclass method. **Helps identify methods that are intended to replace inherited methods.**

### Spring Annotations
- `@RestController` — Combines `@Controller` and `@ResponseBody`, making it easier to build RESTful web services. **Used for defining REST APIs.**
- `@Component` — Marks a Java class as a Spring component. **Indicates that Spring should manage the lifecycle of this class as a bean.**
- `@Service` — Specialization of `@Component`, typically used for business logic services. **Used to mark service layer classes.**
- `@Repository` — Specialization of `@Component`, for persistence layer logic. **Used to mark Data Access Objects (DAOs).**
- `@Bean` — Indicates that a method produces a bean to be managed by Spring. **Used in configuration classes to define beans.**
- `@Primary` — Indicates that a bean should be given preference when multiple beans of the same type are available. **Useful in dependency injection when you have multiple beans of the same type.**
- `@PostMapping`, `@GetMapping`, `@PutMapping`, `@PatchMapping` — HTTP method mapping annotations. **Used to map HTTP requests to handler methods.**
- `@PreAuthorize` — Restricts access to a method based on roles or conditions. **Used for securing methods based on expressions.**
- `@Transactional` — Manages transactions. **Ensures a method executes within a database transaction.**
- `@Configuration` — Indicates that a class declares one or more `@Bean` methods and may be processed by the Spring container. **Used for Java-based configuration.**
- `@Query` — Custom SQL queries for Spring Data JPA. **Used to define native SQL queries for JPA repositories.**

### Swagger Annotations
- `@Tag` — Describes an API tag in the OpenAPI specification. **Used for grouping operations under a common tag.**
- `@Parameter` — Describes an API parameter. **Used for documenting parameters in REST APIs.**
- `@ApiResponses` — Container for multiple `@ApiResponse` annotations. **Used to document the possible responses from an API method.**
- `@ApiResponse` — Describes a single API response. **Used to document HTTP response codes and their meanings.**
- `@Operation` — Describes a single API operation. **Used to document an API endpoint and its behavior.**
- `@Schema` — Describes the schema of an object used in API responses. **Used to define models for API responses.**

### Lombok Annotations
- `@RequiredArgsConstructor` — Generates a constructor with required fields. **Used to create a constructor with final fields or fields marked `@NonNull`.**
- `@AllArgsConstructor` — Generates a constructor with all fields. **Creates a constructor that initializes all class fields.**
- `@NoArgsConstructor` — Generates a no-argument constructor. **Creates a default constructor with no parameters.**
- `@Slf4j` — Adds a static `Log` field using `Slf4j`. **Facilitates logging without manually defining a logger.**
- `@Data` — Generates getters, setters, `toString`, `equals`, and `hashCode`. **Simplifies POJO creation by automatically generating these methods.**
- `@Builder` — Implements the builder pattern. **Allows easy object creation with the builder design pattern.**
- `@Builder.Default` — Specifies the default value for a field in a `@Builder` class. **Ensures default values are set even when not provided explicitly.**

### Jakarta Annotations
- `@NotNull` — Ensures that a field or method parameter is not null. **Used for validation to prevent null values.**
- `@Nullable` — Indicates that a field or method parameter can be null. **Used for documentation and null-checking logic.**
- `@Pattern` — Specifies a regular expression a string must match. **Used for validating string fields.**
- `@Id` — Marks a field as a primary key in JPA entities. **Used for entity primary keys.**
- `@ManyToOne`, `@OneToOne`, `@OneToMany` — Define relationships between JPA entities. **Used to specify different types of database relationships.**
- `@Column` — Specifies a column in a database table. **Used for mapping class fields to database columns.**
- `@GeneratedValue` — Specifies how the primary key value is generated. **Used for auto-incrementing primary keys.**
- `@Table` — Specifies the table name for a JPA entity. **Used to map a class to a specific database table.**
- `@Entity` — Marks a class as a JPA entity. **Indicates that the class is a database entity.**
- `@SequenceGenerator` — Defines a sequence generator for primary key generation. **Used for generating values using database sequences.**

### Testing Annotations
- `@ExtendWith` — Registers an extension for JUnit tests. **Used to include additional functionality in tests.**
- `@Mock` — Creates a mock object for testing. **Used to mock dependencies in unit tests.**
- `@BeforeEach` — Executed before each test method. **Used to set up test conditions.**
- `@AfterEach` — Executed after each test method. **Used to clean up after tests.**
- `@Test` — Marks a method as a test method. **Indicates that a method is a JUnit test.**
- `@MockBean` — Creates a mock bean for Spring tests. **Used to mock Spring beans in unit tests.**
- `@Autowired` — Injects dependencies in Spring tests. **Used to automatically inject dependencies in Spring-managed beans.**
- `@SpringBootTest` — Loads the full Spring context for integration testing. **Used for end-to-end tests involving the entire Spring application context.**

---

## Code Smells

Avoid adding the following **code smells** to the codebase. If you encounter any, please address them:

- **Long methods** (>100 lines): Break them into smaller, more readable ones.
- **Large classes**: Break them up for easier understanding and maintenance.
- **Service classes without interfaces**: Interfaces improve flexibility and testing.
- **Long parameter lists**: Consider using parameter objects or builders.
- **Too many `if-else` statements**: Use design patterns like Strategy or State.
- **Nulls**: Avoid `NullPointerExceptions`—use `Optional` or other strategies.
- **For loops**: Use streams for more concise code.
- **No logging**: Proper logging is essential for production support.
- **Unused code**: Remove any unused classes, methods, or parameters.
- **Duplicate code**: Eliminate duplication through refactoring.
- **Boilerplate code**: Use annotations to reduce repetitive code.
- **Hardcoded hostnames**: Avoid security risks by using environment variables.

---

## Testing

We aim for **100% unit test coverage** on all code going to production. Use **JUnit 5** and **Mockito** for unit tests.

- A unit test should only test a single class. **Mock everything else.**
- **Unit tests are not for finding integration defects.**
- Test methods should naturally follow class design—if methods are small and maintainable, testing becomes easy.

### Further Points on Unit Tests

- Check your code coverage before you raise a PR. Use IntelliJ's code coverage tool to make this easy.
- Aim for 100% line coverage.
- Make your test methods short (< 10 lines) and with a single purpose.
- Make tests fast.
- Make use of the `verify` and `when` methods in Mockito.
- Unit tests should be in the corresponding package name for their classes.
- Name tests clearly and consistently.
- Create tests that target error cases.
- Keep them simple.

---

## Rest Controllers

### What do they do?

- Listen to HTTP requests.
- Deserialize the input from the incoming request.
- Validate the input.
- Call into the business logic (e.g., service class).
- Serialize the output of the business logic.
- Return response body and HTTP status.

### How should they do it?

- They should be simple and not contain logic.
- Make use of annotations.
- Swagger is important, treat it like production code.
- Use the `ResponseEntity` class to return a response.
- Make use of the `RestExceptions` classes in the `http-toolkit` library module.

---

## Service Classes

### What do they do?

- Encapsulate business logic.
- Usually called by the controller layer.
- Usually call the repository layer to retrieve data.

### How should they do it?

- They should never talk directly to the database.
- Make use of annotations.
- Should return the entity model.
- Always implement an interface.
- Use the contract with the interface to expose only certain methods.
- The transactional behavior of a request is set up here.

---

## Repository Layer

### What do they do?

- Manage all Java data access logic.
- Abstract the details of data storage and retrieval from the rest of the application.
- It is the only place we can talk to the database.

### How should they do it?

- Extending `JpaRepository` gives us several useful CRUD methods.
- Use the `@Query` annotation to write SQL directly.
- Take advantage of query lookup strategies.

---

# Rest API Standards

## Introduction
The standard, however, has been introduced after a large number of services have already been delivered and running in the production environment, and as such, conformity to it is lacking. It is expected that where developers need to make changes to an API, they will bring it in line with these standards. Please consider the users of the APIs and if your changes are breaking changes. If they are breaking changes, make sure all necessary dependencies are updated accordingly.

## General Standards
All APIs must observe the following standards:
- Any resource provided by an API must have an enterprise unique identifier in the form of a URI.
- Input to or output from the API must comply with ISO8601 standard.
- The APIs must be able to accept timestamps in any valid time zone under the ISO8601 standard. The API is responsible for converting this to any internal reference timezone.
- The request and response bodies must be in JSON format.
- Use nouns instead of verbs in endpoint paths.
- Handle errors gracefully and return standard error codes with user-friendly errors that the UI can display.
- Before creating an API, understand the reasons for creating it and the clients that will be using it.
- Do not couple your APIs to UI logic. For example, just because the UI does data validation, does not mean the API should be doing the same. The UI is subject to change, and they should not be coupled together.
- Avoid returning a 500 response to users.
- Do not expose database ID keys to clients.

### A Resource
The primary data representation. The JSON response must return a unique URI for that resource, e.g., `application` or `student`.

### A Collection
This refers to a group of resources, e.g., `applications`.
Than
## Required HTTP Response Codes for a GET Request

| HTTP Response | Condition                              | Response Body Content                         |
|---------------|----------------------------------------|----------------------------------------------|
| 200 OK        | Found resource in database             | The Resource with the unique URI             |
| 404 Not Found | Cannot find resource in the database   | Error reason                                 |

### A GET ALL on a Collection

| HTTP Response | Condition                              | Response Body Content                         |
|---------------|----------------------------------------|----------------------------------------------|
| 200 OK        | Found or not found resources in database | All found resources even if the collection is empty |

## POST

The POST verb is used for the creation of a new resource where the client cannot form the resource identifier (URI). The POST is to the singular endpoint of the resource type, and the request body should contain all mandatory fields to create a resource.

### Required HTTP Response Codes for a POST Request

| HTTP Response | Condition                                                  | Response Body Content                                             |
|---------------|------------------------------------------------------------|------------------------------------------------------------------|
| 200 OK        | POST of existing resource (identifier matches) and all attributes match | Resource payload as returned by performing a GET request on the resource’s URI |
| 201 Created   | POST of new resource (identifier does not match any existing resource) | Resource payload as returned by performing a GET request on the resource’s URI |
| 400 Bad Request | POST of new resource with invalid data                    | Error reason                                                      |
| 404 Not Found | POST references a parent resource that cannot be found     | Error reason                                                      |
| 409 Conflict  | POST of existing resource with mismatching attributes      | Error reason                                                      |

## PATCH

The PATCH verb is used to perform an update on the mutable properties of an existing resource. The PATCH request only contains the properties to be modified. Use the unique URI for the resource.

### Required HTTP Response Codes for a PATCH Request

| HTTP Response | Condition                                                      | Response Body Content                                             |
|---------------|----------------------------------------------------------------|------------------------------------------------------------------|
| 200 OK        | PATCH of existing resource completed with the fields changed   | Resource payload as returned by performing a GET request on the resource’s URI |
| 400 Bad Request | PATCH tries to change values that don't comply with constraints | Error reason                                                      |
| 404 Not Found | PATCH on a resource that cannot be found                       | Error reason                                                      |
| 409 Conflict  | PATCH tries to change values that conflict with another resource identifier | Error reason                                                      |

## DELETE

The DELETE verb is used to remove an existing resource. Use the unique URI for the resource.

### Required HTTP Response Codes for a DELETE Request

| HTTP Response | Condition                                  | Response Body Content                                             |
|---------------|--------------------------------------------|------------------------------------------------------------------|
| 204 No Content | Found resource and deleted successfully    | Empty                                                             |
| 404 Not Found | No resource found                           | Error reason                                                      |
| 400 Bad Request | Found resource but unable to delete       | Error reason                                                      |

## PUT

The PUT verb is used in limited cases to represent the creation or update of a resource where the client is able to form the identifier (URI) for the resource. For the PUT request, the client must supply all of the resource properties, irrespective of whether the resource already exists and irrespective of whether the properties are changing.

### Required HTTP Response Codes for a PUT Request

| HTTP Response | Condition                                                     | Response Body Content                                             |
|---------------|---------------------------------------------------------------|------------------------------------------------------------------|
| 200 OK        | PUT of existing resource with all fields saved down           | Resource payload as returned by performing a GET request on the resource’s URI |
| 201 Created   | PUT of new or existing resource                               | Resource payload as returned by performing a GET request on the resource’s URI |
| 400 Bad Request | PUT contains fields that do not comply with constraints      | Error reason                                                      |
| 409 Conflict  | PUT tries to change/create fields that clash with another resource | Error reason                                                      |


## API Versioning Guidelines

To ensure backward compatibility and smooth transitions during updates, it's important to follow these API versioning guidelines:

### 1. Use Versioning in the URL
Each API should include a version number in the URL path. This makes it easy to update the API while maintaining support for older versions. The version should be included as the first part of the URL path.

**Example:**
GET /v1/applications


### 2. Deprecation Strategy
When deprecating an API version, follow a structured deprecation strategy:
- **Announce** the deprecation at least one version in advance.
- **Inform clients** about the deprecation via response headers or documentation.
- **Support old versions** for a reasonable period to allow clients time to transition to the new version.

**Example of Deprecation Response Header:**


### 3. Avoid Versioning Through Headers
While possible, avoid versioning via headers as it makes the API less intuitive and harder to debug. Always prefer versioning via the URL path.

### 5. Considerations for Breaking Changes
- Ensure you increment the **MAJOR** version when making breaking changes.
- Clearly communicate these changes through release notes and API documentation.
- Provide a migration path or guidelines for clients to transition to the new version.

### 6. Default Version
If a version is not specified, the API should default to the latest stable version. Ensure that the default version is backward-compatible with the most recent major release to avoid breaking client integrations.

**Example:**

GET /api/applications (Defaults to /api/v1/applications)


### Summary
- Use the URL path to version your APIs.
- Clearly communicate any deprecations and allow sufficient time for clients to transition.
- Avoid breaking changes in minor or patch versions.

---

## IntelliJ

IntelliJ is a powerful tool—use it!

### Plugins

- **SonarLint**: Helps catch issues by analyzing your code for bugs, vulnerabilities, and code smells in real-time.
- **Problems Tab & Inspection Lines Plugin**: Highlights potential problems in the code directly within the editor, such as unused imports or parameters, making it easier to address issues before code review.
- **Rainbow Brackets**: Enhances readability by color-coding matching brackets, parentheses, and braces, which helps in understanding the structure of the code.
- **Pojo to JSON**: Generates a JSON representation from POJOs with random values, facilitating testing with tools like Postman.

### Pre-Commit Checks

Use Git to set pre-commit checks. Select checks that align with your coding standards, such as:

- Code formatting
- Linting rules
- Running unit tests
- Checking for code coverage
- Ensuring no sensitive information is committed**
