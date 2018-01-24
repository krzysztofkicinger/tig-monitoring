# Spring Actuator Endpoints

## Endpoint infrastructure

Endpoint infrastructure allows one to define one or several operations in a technology independent fashion.

**Endpoint operations**

* **@Endpoint** - endpoint with a mandatory, unique id, properties will be inferred from that
* **LoggersEndpoint** - example, built-in Spring Boot endpoint

**Overriding operations**

## Configuration

1. All @Endpoint are automatically detected
2. Create a bean that returns @Endpoint

## Resources

1. https://spring.io/blog/2017/08/22/introducing-actuator-endpoints-in-spring-boot-2-0
