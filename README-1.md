# A Basic Spring Boot Application

We will define a product that we want to build, and we will split into small chunks.(Requirment Oriented approach)

//TODO : Need to write Initial goals
Expose
Please find the following API used in our UI so far
http://localhost:9000/core-oauth/oauth/token
http://localhost:9100/core-admin/searchUser  
http://localhost:9100/core-admin/getActiveUser
http://localhost:9100/core-admin/getRoleList
http://localhost:9100/core-admin//getUserRoleList/PRODUCERUSER

Initial Goal
============
1. We want a web application to keep the employee records.
2. To begin with, we will present user with enrollment form.
3. User will type user details and submit.

Form Information
FirstName
LastName
EmailId
Description
Username
Password

## USER STORY 1
As a user of the application, I want to enroll to the system. 

##Tasks
1. Create a basic service with business logic (@Email and mailsender)
2. Create a basic API to access this service (REST API)
3. Create a Web page to ask the user to provide his details


## Setting up the Development Environment

Java 16 \
Download URI : https://tpd.io/jdk14

IDE : Community version of IntelliJ IDEA \
Download the latest

Testing tool : HTTPie to test our web application. (command line tester)\
Ref : https://tpd.io/httpie-install


## The Skeleton Web App

https://start.spring.io/

Project : Gradle \
Language : Java \
Spring Boot version : 2.5.2 \
group : com.hbs.edr \
artifact : enroll \
Description : User Enrolling Application \
Packaging : Jar \
Java : 16 

Dependencies \
Lombok \
Spring Web \
Validation

generate the project \
unzip the download \
copy to Intellij \
And new module from existing source \
cd enroll and ./gradlew bootRun to run the skeleton

```
2021-07-20 03:07:12.680  INFO 19819 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 676 ms
2021-07-20 03:07:12.989  INFO 19819 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-07-20 03:07:12.996  INFO 19819 --- [           main] com.hbs.edr.enroll.EnrollApplication     : Started EnrollApplication in 1.329 seconds (JVM running for 1.607)

```

## Spring Boot Autoconfiguration.

What we ger when we add the web dependency is an independently deployable web application that uses tomcat. \
Autoconfiguration feature

@SpringBootApplication groups severl other annotation.\
@EnableAutoConfiguration is one of them.\
That finds all the @Configuration annotated class from my source and the dependencies added.

Dependency that we have added spring-boot-starter-web has another dependency that is spring-boot-starter-tomcat\
Ref : https://tpd.io/starter-web-deps

spring-boot-starter-tomcat dependency contains tomcat-embed-core \
Apache library to start the tomcat embedded server. \
Main logic included in class name Tomcat

And

spring-boot-starter-web also depends on spring-boot-starter (core spring boot starter ref: https://tpd.io/sb-starter)\
which includes whole set of classes annotated with @Configuration. \
Those classes includes configure web servers, message brokers, error handlers, databases and many more \
Ref: https://tpd.io/auto-conf-packages

Class take care of embedded TomcatServer is ServletWebServerFactoryConfiguration Ref: https://tpd.io/swsfc-source \

TODO : Read the rest of the story :)


## Three-Tier, Three-Layer Architecture


























