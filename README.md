#### KSU SWE 3643:<br/>SWE3643 Section 1<br/>Semester Project<br/>Luke McLendon

# KSU SWE 3643 Software Testing and Quality Assurance Semester Project: Web-Based Calculator
This repository includes all the necessary files to run a Java-based webapp representing a statistics calculator and a Junit test module that covers all code paths of the calculator logic module.

## Table of Contents
  [Team Members](#team-members)
- [Architectural diagram](#architectural-diagram)
- [Run from CMD](#Instructions-to-run-from-CMD)
- [Screenshots of Unit Tests](#Screenshots-of-all-unit-tests-in-IDE)
- [YouTube Presentation](#Link-to-YT-video-here)

# Team Members
Luke McLendon

# Architectural diagram:

![image](https://github.com/user-attachments/assets/544ae207-c1a6-4906-aa2b-b4455095f0b2)



# Instructions to run from CMD:
*In theory, having all the required dependencies and then running this in cmd should run the program (if you edit every single directory in it, which is unrealistic)

Jackson Core Json library, Tomcat, and SpringBoot(?) dependencies are included in the project, but JUnit is black magic and is presumably not included. Junit-Jupiter 5.11 was installed via Maven.

> "C:\Users\Sgt C4\.jdks\openjdk-23.0.1\bin\java.exe" 
      -XX:TieredStopAtLevel=1 
      -Dspring.output.ansi.enabled=always 
      -Dcom.sun.management.jmxremote 
      -Dspring.jmx.enabled=true 
      -Dspring.liveBeansView.mbeanDomain 
      -Dspring.application.admin.enabled=true 
      "-Dmanagement.endpoints.jmx.exposure.include=*" 
      "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2024.3\lib\idea_rt.jar=59905:C:\Program Files\JetBrains\IntelliJ IDEA 2024.3\bin" 
      -Dfile.encoding=UTF-8 
      -Dsun.stdout.encoding=UTF-8 
      -Dsun.stderr.encoding=UTF-8 
      -classpath 
         "D:\Documents\College Homework+Assignments\2024 - Fall\Software Testing\SWE 3643 Semester Project\calculator\target\classes;
         C:\Users\Sgt C4\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.18.1\jackson-core-2.18.1.jar;
         C:\Users\Sgt C4\.m2\repository\org\opentest4j\opentest4j\1.3.0\opentest4j-1.3.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;
         C:\Users\Sgt C4\.m2\repository\org\junit\jupiter\junit-jupiter\5.11.3\junit-jupiter-5.11.3.jar;
         C:\Users\Sgt C4\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.11.3\junit-jupiter-api-5.11.3.jar;
         C:\Users\Sgt C4\.m2\repository\org\junit\jupiter\junit-jupiter-params\5.11.3\junit-jupiter-params-5.11.3.jar;
         C:\Users\Sgt C4\.m2\repository\org\junit\jupiter\junit-jupiter-engine\5.11.3\junit-jupiter-engine-5.11.3.jar;

         C:\Users\Sgt C4\.m2\repository\org\junit\platform\junit-platform-commons\1.11.3\junit-platform-commons-1.11.3.jar;
         C:\Users\Sgt C4\.m2\repository\org\junit\platform\junit-platform-engine\1.11.3\junit-platform-engine-1.11.3.jar;
         
         C:\Users\Sgt C4\.m2\repository\ch\qos\logback\logback-classic\1.5.12\logback-classic-1.5.12.jar;
         C:\Users\Sgt C4\.m2\repository\ch\qos\logback\logback-core\1.5.12\logback-core-1.5.12.jar;
         
         C:\Users\Sgt C4\.m2\repository\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;
         
         C:\Users\Sgt C4\.m2\repository\org\yaml\snakeyaml\2.3\snakeyaml-2.3.jar;

         C:\Users\Sgt C4\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.18.1\jackson-databind-2.18.1.jar;
         C:\Users\Sgt C4\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.18.1\jackson-annotations-2.18.1.jar;
         C:\Users\Sgt C4\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.18.1\jackson-datatype-jdk8-2.18.1.jar;
         C:\Users\Sgt C4\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.18.1\jackson-datatype-jsr310-2.18.1.jar;
         C:\Users\Sgt C4\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.18.1\jackson-module-parameter-names-2.18.1.jar;

         C:\Users\Sgt C4\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.24.1\log4j-to-slf4j-2.24.1.jar;
         C:\Users\Sgt C4\.m2\repository\org\apache\logging\log4j\log4j-api\2.24.1\log4j-api-2.24.1.jar;
         C:\Users\Sgt C4\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\10.1.33\tomcat-embed-core-10.1.33.jar;
         C:\Users\Sgt C4\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\10.1.33\tomcat-embed-el-10.1.33.jar;
         C:\Users\Sgt C4\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\10.1.33\tomcat-embed-websocket-10.1.33.jar;

         C:\Users\Sgt C4\.m2\repository\io\micrometer\micrometer-observation\1.14.1\micrometer-observation-1.14.1.jar;
         C:\Users\Sgt C4\.m2\repository\io\micrometer\micrometer-commons\1.14.1\micrometer-commons-1.14.1.jar;

         C:\Users\Sgt C4\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\3.4.0\spring-boot-starter-tomcat-3.4.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\boot\spring-boot-starter-web\3.4.0\spring-boot-starter-web-3.4.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\boot\spring-boot-starter\3.4.0\spring-boot-starter-3.4.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\boot\spring-boot\3.4.0\spring-boot-3.4.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.4.0\spring-boot-autoconfigure-3.4.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\boot\spring-boot-starter-logging\3.4.0\spring-boot-starter-logging-3.4.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\boot\spring-boot-starter-json\3.4.0\spring-boot-starter-json-3.4.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-web\6.2.0\spring-web-6.2.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-beans\6.2.0\spring-beans-6.2.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-webmvc\6.2.0\spring-webmvc-6.2.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-aop\6.2.0\spring-aop-6.2.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-context\6.2.0\spring-context-6.2.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-expression\6.2.0\spring-expression-6.2.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-core\6.2.0\spring-core-6.2.0.jar;
         C:\Users\Sgt C4\.m2\repository\org\springframework\spring-jcl\6.2.0\spring-jcl-6.2.0.jar" 

         C:\Users\Sgt C4\.m2\repository\org\slf4j\jul-to-slf4j\2.0.16\jul-to-slf4j-2.0.16.jar;
         C:\Users\Sgt C4\.m2\repository\org\slf4j\slf4j-api\2.0.16\slf4j-api-2.0.16.jar;
      com.calculator.CalculatorApplication


# Screenshots of all unit tests in IDE:
Sample standard deviation input validation unit tests

![alt text](https://github.com/user-attachments/assets/e5131d00-44c4-4e21-84bb-ae1d43c7a705)


Population standard deviation input validation unit tests

![alt text](https://github.com/user-attachments/assets/bd7de64a-f66d-4d6b-b0ce-a7cd8c4827bc)


Mean input validation unit tests

![alt text](https://github.com/user-attachments/assets/183b64e9-0489-4aeb-b9d3-877009dbfaa6)


Z-Score input validation unit tests

![alt text](https://github.com/user-attachments/assets/887b0df7-eae6-46c9-8f26-38779cf233ef)


All calculation logic unit tests

![alt text](https://github.com/user-attachments/assets/11061ce4-57e6-4264-8b3a-e0f797d04a86)


# Link to YT video here:
[YouTube Video link] ----------------
