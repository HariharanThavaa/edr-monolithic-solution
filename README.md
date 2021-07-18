# edr-monolithic-solution

Basic Concepts
==============

Spring
======
The spring framework is a vast set of libraries and tools simplifying software development,
namely dependency injection, data access, validation, internationalization, aspect-oriented programming, etc.

Spring provides built-in implementations for many aspects of software development
1. Spring Data simplifies data access for relational and NoSQL databases
2. Spring Batch provides powerful processing for large volumes of records
3. Spring Security is a security framework that abstracts security features to applications
4. Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems
5. Spring Integration is an implementation of enterprise integration pattern. It facilitates integration with other enterprise application using leightweight messaging and decalrative adapters.

Spring Boot
==========
Spring Boot is a framework that leverages Spring to quickly create stand-alone applications in java based languages.

Bootstrapping an application, meaning the process to configure your spring application to have it up and running,
Spring boot provides application with default configurations - Advantage
If you rely too much on default you will loose control of awareness what happening - DisAdvantage

spring-boot-starter-web - for standalone web application which groups Spring core web libraries, jackson (json handling), validation, logging, autoconfiguration and even an embedded Tomcat server.
auto-configuration - scan your classpath, properties, components etc and load some extra beans and behavior based on that.
Proiles - different configuration option, example dev and prod environment.

Routing - Spring Cloud Gateway,
Service Discovery - Consul,
Load balancing - Spring cloud load balancer

Lombok And Java
==============
Library that generates Java Code based on annotations.
It keeps the code simple and concise, reducing the boilerplate so the reader can focus on what it matters.

Key Lombok annotations
@Value groups the other below mentioned annotations which will generate the code block before java build phase.
1. @AllArgsConstructor - creates a constructor with all the existing fields.
2. @FieldDefaults makes our fields private and final.
3. @Getter generate getters for factorA and factorB
4. @ToString includes a simple implementation concatenate fields
5. @EqualsAndHashCode generates basic equal() and hashcode() methods, using all fields but we could also customise.

Disadvantage
You might add some that is not necessary
IDE plugins needs to be installed

Lombok features that we use
1. We annotate with @Value the immutable classes
2. For the data entities we use separately some of the annotations described earlier
3. We add slf4j annotation for logging


Testing Basics
==============

## Test Driven Development
This technique helps you by putting the focus first on what you need and what your expectation are and later moving to the implementation.

## Behaviour Driven Developments
This brings some better structure and readability to your tests.
we write the tests according to a Given-When-Then structure.

## Junit
Junit5 comes with spring boot test starter dependency.

1. @BeforeEach and @AfterEach for code that should be executed before and after each test, respectively.
2. @Test for every method that represents a test we want to execute.
3. @ExtendsWith at the class level to add JUnit 5 extensions. we will use this to add the mockito extension and the Spring extension to our test.

## Mockito

Mockito is a mocking framework for unit tests in java, when you mock a class, 
you are overriding the real behavior of that class with some predefined instruction of what their methods should return or do for their arguments.

The easiest way to mock a class with Mockito is use the @Mock annotation in a field combined with MockitoExtension for JUnit 5.
### MockitoExtension and Mock Annotation Usage.
```
@ExtendWith(MockitoExtension.class)
public class MutiplicationServiceImplTest {
    @Mock
    private ChallengeAttemptRepository attemptRepository;
}
```

### Defining Custoom Behaviour with Mockito's when
Then we could use the static method Mockito.when to define custom behaviour
```
when(attemptRepository.methodThatReturnSomething()).thenReturn(predefinedResponse);
```

### Using given to Define Custom Behaviour
Alternatively we could BDDMockito to embrace readability
```
given(attemptRepository.methodThatReturnSomething()).willReturn(predefinedResponse);
```

### Verifying an expected Call
to check that an expected call to a mocked class was invoked.
```
verify(attemptRepository).save(attempt);
```

## AssertJ

The standard way to verify expected results with JUnit 5 is using Assertions.
```
assertEquals("Hello, World!", actualGreeting);
```
It can also verigy true/false, null, execution before timeout, throwing an exception etc
Ref: https://tpd.io/junit-assert-docs

AssertJ provides more readability and we can write more concise test
```
assertThat(actualGreeting).isEqualTo("Hello, World!");
```

We will use BDDAssertion which BDDAssertions class included in AssertJ
```
then(actualGreeting).isEqualTo("Hello, World");
```
Ref: https://tpd.io/assertj


## Testing in Spring Boot

Both Junit5 and AssertJ are included in spring-boot-starter-test
Use @SpringBootTest annotation will start spring context and make all your configured beans available for the test.
Best suited for Integration test.

1. Spring Test libraries comes with a SpringExtension, So you can integrate spring in your JUnit 5.  @ExtendWith
2. Spring Test includes @MockBean (dummy values to mock) which is similar to @Mock.

## Logging
Java uses System.out and System.err to print streams
```
System.out.println("Hello, standard output stream!");
```
This is good enough for 12 factor app https://tpd.io/12-logs

Spring boot comes with default implementation of LogBack

SLF4J loggers also supported, To use a logger, we create it via the LoggerFactory

```
import org.slf4j.Logger;
import org,slf4j.LoggerFactory;

class ChallengeServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(ChallengeServiceImpl.class)

    private void dummyMethod() {
        var name = "John";
        log.info("Hello, {}", name);
    }
}

```

With Lombok
```
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ChallengeServiceImpl {

    public void dummyMethod(){
        var name = "John";
        log.info("Hello, {}!", name)
    }
}

```

Summary and Achievements
========================

1. You reviewed the core ideas about Spring and Spring Boot.
2. You understood how we'll use Lombok in the book to reduce boilerplate code.
3. You learned how to use tools like Junit, Mockito and AssertJ to implement test driven development and how these tools are integrated in Spring Boot.
4. You reviewed some logging basics and how to use a logger with Lombok







  











