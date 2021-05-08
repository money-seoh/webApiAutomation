# webApiAutomation

This is practice project for understanding the concept of WebAPI test automation. Following are the libraries used to automation API test automation:
1. org.apache.httpcomponents - httpClient library (external library)
2. io.rest-assured - rest-assured library (external library)
3. java.net.http - httpclient (JDK 11 built-in library)

The project is based on Java programming language.

# Project Structure

In this project, each framework have its own independent module. Following are name of modules with associate framework:
1. apacheHttpComponent - httpClient library (external library)
2. restAssured - rest-assured library (external library)
3. java11Practice - httpclient (JDK 11 built-in library)

There are further two other modules in the project which are practice projects and are not related to API test automation.They are as follows:
1. java9Practice - JDK 9 practice project to understand how the changes introduced in JAVA 9 work.
2. jUnitFive - Unit testing framework for Java using JUnit 5 libraries (external libraries).

# Build Tools

Gradle is the build and dependency management tool used for creating this project. The reason to choose Gradle over Maven due to the ease of use of the tool.

# Dependencies in project

## apacheHttpComponent Module
| Dependency Name  | Version | Dependency Provider |
| ------------- | ------------- | ------------ |
| httpClient  | 4.5.7  | org.apache.httpcomponents |
| testng  | 7.0.0  | org.testng |

## restAssure Module
| Dependency Name  | Version | Dependency Provider |
| ------------- | ------------- | ------------ |
| rest-assured  | 4.3.0  | io.rest-assured |
| testng  | 7.0.0  | org.testng |

## java11Practice Module
| Dependency Name  | Version | Dependency Provider |
| ------------- | ------------- | ------------ |
| junit-jupiter-api  | 5.7.0  | org.junit.jupiter|
| junit-jupiter-engine  | 5.7.0  | org.junit.jupiter |

## jUnitFive Module
| Dependency Name  | Version | Dependency Provider |
| ------------- | ------------- | ------------ |
| junit-jupiter-api  | 5.7.0  | org.junit.jupiter|
| junit-jupiter-engine  | 5.7.0  | org.junit.jupiter |

## java9Practice Module
No Dependecy used

# Prerequisites
We need follwoing to make sure that the project smothly on any machine:
1. Java SDK (JDK) version 11 or higher ( prefer LTS release)
2. Gradle build tool 6.8.3 or higher
3. IDE - Prefer to choose any Java IDE that you're most comfortable with. I used Intelij IDEA(2021.1.1) community edition, but you can also use Eclipse or Visual Studio Code.
4. Git - GIT version control system is an add-on tool that you can also use.

## ENJOY CODING !!!!!!!!
