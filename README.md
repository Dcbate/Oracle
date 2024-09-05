As a Developer it is part of your role to follow this page and keep it up to date. Lets work as a collective team to achieve the highest quality code we can.

General Coding Rules
•	Try to tidy up the code as you go, leave it in a better state than you found it.
•	Take pride in the code you write.
•	Have solid principles always in the back of your mind as you code. 
•	Use Design patterns when you can. 
•	Make your PRs nice for people to review  
•	Logging should be used to help Prod support and SL3. 
•	Use annotations - they make life easier 

Naming
Classes
•	Names should be CamelCase 
•	Try to use Nouns 
•	Use whole words - DO NOT ABBREVIATE 
•	Keep them simple and descriptive 
•	Try to follow a pattern if many classes have similar functionality. e.g - RestClient 
•	If you are implementing an interface include the Impl at the end of the class name e.g NameImpl
Interfaces
•	Follow the same patterns are classes
Packages 
•	Should be all lowercase
•	Make logical components based on class functions e.g controller
•	Try to make them one-word 
Methods 
•	Start with a LowerCase, Then CamelCase
•	Try to add a verb to describe what the method is doing 
•	If the method name is too long the method might be doing too much 
•	Use common words like "get" and "set"
Variables
•	Start with Lowercase, Then CamelCase
•	Short but meaningful 
•	One-character names should be avoided even in lambdas 
•	Map names should help describe what it is grouped by if not obvious e.g studentsByAge
Constants
•	All UpperCase 
•	With "_" for word spaces e.g MAX_WIDTH
Java 17 
We are using Java 17. Let’s use all its features and make the most out of the latest updates. 
•	Method References
•	Optionals 
•	Streams
•	Records
•	Pattern Matching for switch statements 
•	Lambdas
•	var  Keyword
•	Text Blocks
These are features we can take advantage of. Go out of your way to get to know them and try and use them. It will help you in your career.   
Let's aim for Java 21
Useful Annotations 
Java Annotations:
•	@Deprecated: Marks a method, class, or field as deprecated, indicating that it should no longer be used.
•	@Override: Indicates that a method overrides a superclass method.
Spring Annotations:
•	@RestController: Marks a class as a RESTful controller, handling HTTP requests.
•	@Component: Marks a class as a Spring component, eligible for auto-detection and wiring.
•	@Service: Indicates that a class is a service component.
•	@Repository: Marks a class as a data repository.
•	@Bean: Declares a method as a bean definition.
•	@Primary: Marks a bean as the primary choice when multiple beans of the same type exist.
•	@PostMapping, @GetMapping, @PutMapping, @PatchMapping: Map HTTP methods to controller methods.
•	@PathVariable: Binds a method parameter to a path variable.
•	@PreAuthorize: Defines authorization rules for a method.
•	@Transactional: Specifies transactional behavior for a method.
•	@Configuration: Indicates that a class provides Spring configuration.
•	@Query: Used in Spring Data JPA repositories to define custom queries.
•	@LastModifiedDate: Marks a field to track the last modification date.
•	@CreatedDate: Marks a field to track the creation date.
Swagger Annotations:
•	@Tag: Describes a tag for API documentation grouping.
•	@Parameter: Describes a parameter for an operation.
•	@ApiResponses: Defines multiple API responses.
•	@ApiResponse: Describes an API response.
•	@Operation: Describes an operation (method) in the API.
•	@Schema: Describes the schema of a model or property.
Lombok Annotations:
•	@RequiredArgsConstructor, @AllArgsConstructor: Generate constructors with required and all arguments, respectively.
•	@Slf4j: Generates a logger field.
•	@Data: Generates getters, setters, equals, hashCode, and toString.
•	@NoArgsConstructor: Generates a no-args constructor.
•	@Builder, @Builder.Default: Simplifies builder pattern for creating objects.
Jakarta Annotations:
•	@NotNull, @Nullable: Indicate non-null and nullable constraints.
•	@Pattern: Validates a field against a regular expression.
•	@Id: Marks a field as the primary key.
•	@ManyToOne, @OneToOne, @OneToMany: Define relationships between entities.
•	@Column: Specifies column details in a database table.
•	@GeneratedValue: Configures automatic value generation for primary keys.
•	@Table, @Entity: Define JPA entities and their mappings.
•	@SequenceGenerator: Configures a sequence generator for primary keys.
Testing:
•	@ExtendWith: This annotation is used to register extensions (such as custom test runners or parameter resolvers) for JUnit 5 tests1.
•	@Mock: Marks a field as a mock object, typically used with mocking frameworks like Mockito.
•	@BeforeEach: Indicates a method that should be executed before each test method runs.
•	@AfterEach: Indicates a method that should be executed after each test method completes.
•	@Test: Marks a method as a test case. JUnit will execute methods annotated with @Test.
•	@MockBean: Used in Spring Boot tests to create and inject mock beans into the Spring context.
•	@Autowired: Injects dependencies into a test class or method.
•	@SpringBootTest: Indicates that the test should load the Spring application context for integration testing.

Code Smells
All these below are code smells. Please do not add any to the codebase. Please try to tidy up any you see in the codebase 
•	Long methods - This normally means your method is doing too much. Look to break it down into more readable methods. Anything above 100 lines smells. Refactoring into smaller methods can improve readability and maintainability.
•	Large classes - This breaks the Single Responsibility Principle (SRP). Everything is easier with smaller classes. Smaller classes are easier to understand, test, and maintain.
•	Service classes not implementing an interface - This can make your code less flexible and harder to test. Implementing interfaces allows for easier mocking and swapping of implementations.
•	Long Params list into a method - This can make methods hard to read and maintain. Consider using parameter objects or builder patterns to simplify method signatures.
•	Too many if-else statements - Try using a design pattern to stop this from happening or look at the design. Patterns like Strategy or State can help reduce complex conditional logic.
•	Nulls being passed around - This can lead to NullPointerExceptions. Use Optional or other strategies to handle the absence of values more gracefully.
•	For each loops - Let’s use streams; we are using Java 17 now. Streams can make your code more concise and expressive.
•	No logging on a class - Help prod support do their job. Logging is crucial for monitoring and debugging in production environments.
•	Unused classes, methods, params - Clean up the code as you go. Removing unused code reduces clutter and potential confusion.
•	Same string used multiple times in a class - Use a constant at the top of the class. This makes your code easier to maintain and reduces the risk of typos.
•	Duplicate code - Get RID. Duplicate code can lead to inconsistencies and is harder to maintain. Refactor to eliminate duplication.
•	Boilerplate code - Use annotations. Annotations can reduce repetitive code and make your codebase cleaner.
•	Storing Hostnames in the Database - This can lead to security risks and maintenance issues. Consider using environment variables or configuration management tools instead.
Testing 
Unit Tests
Lets AIM for 100% unit test coverage on all code rolling out to production.
I repeat, 100%. If you cannot cover the code you write via JUnit & Mockito, try to think about design and your classes and methods. 
A unit test is to test a single class ONLY. You should be mocking out everything else apart from that class. Unit testing is not for finding integration defects.
We are using JUNIT5. 
Writing tests should come very nature after you have written the class if the methods are small and maintainable.
Example Class:
![image](https://github.com/user-attachments/assets/34bf7fff-4bb3-4ed1-be68-c3b5c401a1e1)
