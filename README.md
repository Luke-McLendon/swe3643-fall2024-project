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
Here are some notes on this project's architecture in no particular order:

Site.js is potentially slightly different from what you might be expecting. In this case,  it acts as the interface between the user and the backend logic. It sends everything straight off the screen as a string that gets handled elsewhere.

The controller responds with either an error or the result that goes back to Site.js to be displayed.

You may notice this software isn't split up into four separate projects, and is instead split into three packages. This is yet another artifact of how Java works, using packages instead of projects. I am missing one project (Playwright end-to-end testing) because I ran out of time to implement it. The other three are present, functional, and complete.

My unit tests appear a litle more involved because I'm not just validating the calculations, but also the input data for correct formatting.

---


## Environment:
This program is built on and requires the following dependencies:
-Jackson Core Json library 

-Tomcat 11.0.1

-SpringBoot 

-Junit-Jupiter 5.11
  -*is black magic and is presumably not packaged in the repository like the others (was installed via Maven)*

Java is based on the concept of the Java Virtual Machine allowing Java code to run on basically any platform, so there is no real reason this project would not run on any reasonably modern personal computer of any kind. It has only been tested on a computer running Windows 10, however, and no instructions are included to get it to run on anything other than a contemporary Windows system.

## Executing the Web Application:
In theory, executing the project from console is as easy as navigating to the application (or JAR) file's location in your file structure using the command
>cd C:\User\Documents\program etc...

and then entering either
>mvn spring-boot:run

or
>mvnw spring-boot:run

into console.
This, however, does not work for my project, likely due to an incorrectly configured POM file and/or misconfigured dependencies. Fixing this requires working with processes that are far beyond my level of understanding, and has thus been disregarded in favor of using the time to develop much higher-quality code.

You may encounter an error saying that a service is already running on your designated port. If this happens, simply open your Services app, locate Apache Tomcat 11.0 in the list, stop the service, and rerun the program.



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
[Video Presentation](https://youtu.be/s-Rvvtuyevo)
