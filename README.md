# OnlineBookStore
RESTful API service for online book store platform in spring boot with in-memory data source.

## Requirements

For building and running the application you need:

- [JAVA 17](https://www.oracle.com/java/technologies/downloads/#java17)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.techconative.library.LibraryApplication` class from your IDE.

Alternatively you can run the gradle build and run the generated jar.

```shell
gradlew bootjar
cd /build/libs
java -jar OnlineBookStore.jar
```

Swagger URL:: http://localhost:8080/swagger-ui/index.html#/