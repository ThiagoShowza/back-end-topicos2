# API Documentation for topicos2-jordanshoes

## Introduction
This API serves as a backend for a jewelry store, allowing management of jewelry items such as rings, bracelets, necklaces, etc. It provides endpoints to create, retrieve, update, and delete jewelry items.

## Technologies Used
- Quarkus Framework
- Hibernate ORM with Panache
- RESTEasy JAX-RS
- SmallRye OpenAPI

## Running the Application
### Development Mode
To run the application in development mode with live coding enabled, use the following command:
```shell
./mvnw compile quarkus:dev
```

### Packaging and Running
You can package the application using Maven:
```shell
./mvnw package
```
Then run the packaged JAR file:
```shell
java -jar target/*-runner.jar
```

### Creating a Native Executable
You can create a native executable using:
```shell
./mvnw package -Dnative
```
Or, if you don't have GraalVM installed, you can run the native executable build in a container:
```shell
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

---
