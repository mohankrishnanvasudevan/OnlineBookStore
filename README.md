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
You can run the tests with below command 

```shell
graldlew test
```
and you can check the test results from OnlineBookStore/build/reports/tests/test/index.html

By default application is configured with in-memory data source. you can find the DB scripts in src/main/resources/
you can change the database pointing to your prefered one by changing datasource properties in src/main/resources/application.properties

Swagger URL:: http://localhost:8080/online-book-store/swagger-ui/index.html#/

![image](https://github.com/mohankrishnanvasudevan/OnlineBookStore/assets/128733715/1b11b706-6af6-4761-a191-5591ab5eb26f)
