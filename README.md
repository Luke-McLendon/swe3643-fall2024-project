#### KSU SWE 3643:<br/>SWE3643 Section 1<br/>Semester Project<br/>Luke McLendon

# KSU SWE 3643 Software Testing and Quality Assurance Semester Project: Web-Based Calculator
This repository includes all the necessary files to run a Java-based webapp representing a statistics calculator and a Junit test module that covers all code paths of the calculator logic module.

## Table of Contents
- [Team Members](#team-members)
- [Architectural diagram](#architectural-diagram)
- [Environment](#environment)
  - [Executing the Web Application](#Executing-the-Web-Application)
  - [Executing Unit Tests](#executing-unit-tests)
- [Reviewing Unit Tests](#Reviewing-Unit-Tests)
- [Reviewing Unit Test Coverage](#Reviewing-Unit-Test-Coverage)
- [End-to-End Tests](#End-to-end-tests)
- [YouTube Presentation](#Link-to-YT-video-here)

## Team Members:
Luke McLendon

## Architectural diagram:

![image](https://github.com/user-attachments/assets/544ae207-c1a6-4906-aa2b-b4455095f0b2)

## Environment:
Explain how to configure the environment to execute your web application, unit tests, and end-to-end tests......................
This program is built on and requires the following dependencies:

-Jackson Core Json library 

-Tomcat 11.0.1

-SpringBoot 

-Junit-Jupiter 5.11
  -is black magic and is presumably not included
  -(was installed via Maven)

## Executing the Web Application:
In theory, executing the project from console is as easy as navigating to the application (or JAR) file's location in your file structure using the command
>cd C:\User\Documents\program etc...

and then entering either
>mvn spring-boot:run

or
>mvnw spring-boot:run

into console.
This, however, does not work for my project, likely due to an incorrectly configured POM file and/or misconfigured dependencies. Fixing this requires working with processes that are far beyond my level of understanding, and has thus been disregarded in favor of using the time to develop much higher-quality code.


## Executing Unit Tests
Executing unit tests from cmd is equally as straight forward as running the main program should be, but in practice appears to run into the same issues. The only difference would be running
>mvn spring-boot:run

in your test file's directory instead.


## Reviewing Unit Tests:
My test code is split into two main catagories; input validation and mathematical validation. I perform extensive tests on my various functions to ensure that whatever data they take in as a parameter is handled, even if it is missing, incorrectly formatted, or otherwise wrong. My computational tests test the mathematical accuracy of my compute functions.


## Reviewing Unit Test Coverage:
The below two screenshots show my tests achieving 100% code coverage, both branch and line-wise, as well as all fourty-five tests completing and exiting.

![alt text](https://github.com/user-attachments/assets/99fb1ee9-5ae9-4493-a1a4-27d8d5ab119b)

![alt text](https://github.com/user-attachments/assets/9f643f68-303c-48ad-8acf-b37ec48d0a5c)


## End-to-End Tests
Unfortunately I did not have time to implement playwright end-to-end testing in this project. Playwright is not included in this project in any way.



## Link to YT video here:
[YouTube Video link] ----------------
