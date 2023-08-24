# JAVA Project - Property management (work in progress)

## Java project with Spring Boot and Spring Security
A micro services architecture, with :
- an authentication module for generate et validate token -> prop-mgt-auth
- a business application for simulate a property management software -> prop-mgt-business-service
- a discovery service (Eureka) -> prop-mgt-eureka
- an API gateway with JWT and routes filters -> prop-mgt-gateway


## Initialization

### Prerequisites
- MySQL

### Start new project :
- Spring Starter Project
	- Java 17
	- Maven
	- Packaging : Jar
	- Package : com.myorg

---
### Java dependencies
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
	- jjwt-impl
	- jjwt-jackson
		- jjwt version : 0.11.5

prop-mgt-business-service

- dependencies
    - spring-boot-starter-data-jpa
    - spring-boot-starter-data-rest
    - spring-boot-starter-web
    - spring-cloud-starter-netflix-eureka-client
    - spring-boot-devtools
    - mysql-connector-java
    - lombok

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
    	- jjwt version : 0.11.5


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
	"lastname" : "Doee",
	"firstname" : "Jonny",
	"email" : "doeej@mail.fr",
    "password" : "ANOTHER_PASSWORD"
}
```


