# JAVA Project - Property management (Work in progress)

## Java project with Spring Boot and Spring Security
A micro service architecture, with :
- a discovery service (Eureka)
- an API gateway with JWT and routes filters
- a authentication module for generate et validate token
- a business application for simulate a property management software


## Initialisation

### Prerequisites
- MySQL

### New project :
- Spring Starter Project
	- Java 17
	- Maven
	- Packaging : Jar
	- Package : com.myorg

---
### Java Dependencies
prop-mgt-auth :

- dependencies
    - spring-boot-starter-data-jpa
    - spring-boot-starter-data-rest
    - spring-boot-starter-web
    - spring-cloud-starter-netflix-eureka-client
    - spring-boot-starter-security
    - spring-boot-devtools
    - mysql-connector-java
    - lombok

	- jjwt-api
		- version : 0.11.5
	- jjwt-impl
		- version : 0.11.5
	- jjwt-jackson
		- version : 0.11.5


prop-mgt-eureka
- dependencies
    - spring-cloud-starter-netflix-eureka-server


prop-mgt-gateway

- dependencies
    - spring-cloud-starter-gateway
    - spring-web
    - spring-cloud-starter-netflix-eureka-client
    - spring-boot-devtools
    - lombok
    - jjwt-api
    - jjwt-impl
    - jjwt-jackson


prop-mgt-business-service

- dependencies

    - spring-boot-starter-data-jpa
    - spring-boot-starter-data-rest
    - spring-boot-starter-web
    - spring-cloud-starter-netflix-eureka-client
    - spring-boot-devtools
    - mysql-connector-j
    - lombok


---
## Run as :
    Maven Install
    Spring Boot App

---
## Test with Postman :


### Requests on Auth service, without Bearer token
### Register
- POST url : http://localhost:8088/api/v1/auth/register
- body :
```json
{
    "lastname": "Doe",
    "firstname": "John",
    "email": "jd@mail.fr",
    "password": "A_PASSWORD",
    "roles":[{"roleName":"ADMIN"}]
}
```

### Login
- POST url : http://localhost:8088/api/v1/auth/login
- body :
```json
{

    "email": "jd@mail.fr",
    "password": "SAME_PASSWORD"
}
```


### Requests on Business service ! Bearer token required !
### Get all tenants
- GET url : http://localhost:8088/api/v1/business/tenants

### Add new tenant
- POST url : http://localhost:8088/api/v1/business/addTenant
- body :
```json
{
	"lastname" : "Doeee",
	"firstname" : "Jonny",
	"email" : "doeej@mail.fr",
    "password" : "ANOTHER_PASSWORD"
}
```


