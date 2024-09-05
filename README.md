Development Guidelines
As a developer, it is part of your responsibility to maintain this document and ensure it stays up to date. Let's collaborate as a team to achieve the highest quality code possible.

General Coding Rules
Leave the code better than you found it: Tidy up as you go.
Take pride in your code: Craft it with care and attention.
Always follow solid principles: Keep them in mind as you code.
Use design patterns when applicable.
Write PRs that are easy to review.
Logging is crucial: Help production support and SL3 teams.
Use annotations: They make life easier.
Naming Conventions
Classes
Use CamelCase.
Prefer nouns and whole words – no abbreviations.
Keep names simple and descriptive.
Use a pattern for classes with similar functionality (e.g., RestClient).
For classes implementing interfaces, append Impl (e.g., NameImpl).
Interfaces
Follow the same conventions as classes.
Packages
Use all lowercase.
Group by functionality (e.g., controller).
Keep names to one word if possible.
Methods
Use camelCase starting with a lowercase letter.
Begin with a verb to describe the action.
If the name is too long, the method may be doing too much.
Use common verbs like get and set.
Variables
Use camelCase starting with a lowercase letter.
Keep names short but meaningful.
Avoid one-character names, even in lambdas.
For maps, use names that describe what the map groups (e.g., studentsByAge).
Constants
Use UPPERCASE with _ for spaces (e.g., MAX_WIDTH).
Java 17 Features
We are using Java 17, so take full advantage of its features:

Method references
Optionals
Streams
Records
Pattern Matching for switch statements
Lambdas
var keyword
Text blocks
Make an effort to learn and apply these features—they will help in your career. Also, let's start aiming for Java 21!

Useful Annotations
Java Annotations
@Deprecated — Marks deprecated methods, classes, or fields.
@Override — Indicates a method overrides a superclass method.
Spring Annotations
@RestController, @Component, @Service, @Repository, @Bean, @Primary
Mapping annotations: @PostMapping, @GetMapping, @PutMapping, @PatchMapping
Authorization and transactions: @PreAuthorize, @Transactional
Configuration and queries: @Configuration, @Query
Swagger Annotations
@Tag, @Parameter, @ApiResponses, @ApiResponse, @Operation, @Schema
Lombok Annotations
@RequiredArgsConstructor, @AllArgsConstructor, @NoArgsConstructor
@Slf4j, @Data, @Builder, @Builder.Default
Jakarta Annotations
@NotNull, @Nullable, @Pattern, @Id
Relationship mappings: @ManyToOne, @OneToOne, @OneToMany
@Column, @GeneratedValue, @Table, @Entity, @SequenceGenerator
Testing Annotations
@ExtendWith, @Mock, @BeforeEach, @AfterEach, @Test
Spring Boot testing: @MockBean, @Autowired, @SpringBootTest
Code Smells
Avoid adding the following code smells to the codebase. If you encounter any, please address them:

Long methods (>100 lines): Break them into smaller, more readable ones.
Large classes: Break them up for easier understanding and maintenance.
Service classes without interfaces: Interfaces improve flexibility and testing.
Long parameter lists: Consider using parameter objects or builders.
Too many if-else statements: Use design patterns like Strategy or State.
Nulls: Avoid NullPointerExceptions—use Optional or other strategies.
For loops: Use streams for more concise code.
No logging: Proper logging is essential for production support.
Unused code: Remove any unused classes, methods, or parameters.
Duplicate code: Eliminate duplication through refactoring.
Boilerplate code: Use annotations to reduce repetitive code.
Hardcoded hostnames: Avoid security risks by using environment variables.
Testing
We aim for 100% unit test coverage on all code going to production. Use JUnit 5 and Mockito for unit tests.

A unit test should only test a single class. Mock everything else.
Unit tests are not for finding integration defects.
Test methods should naturally follow class design—if methods are small and maintainable, testing becomes easy.
