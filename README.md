# ScheduleMessageUsingSpringBootRESTAPI
RESTful web service that schedules messages to be printed


**#How to Build the project**
Step1: Go to the project structure where POM.xml file resides and open the command prompt and run he below command to generate the project dependecies
step2: **mvn clean install -DskipTests**

**#How to Run the project**
Step1: After compliation and bild of project, we need to run the project using command line tool or IDE (IntelLIJ)
Step2: Using command line window, stay on project structure folder where POM.xm file reside and runt he command below
Step3: **mvn spring-boot:run**
Step4: Above command will runt he spring boot project and deploy into embedded tomcat server on custom port number **8080**
![image](https://user-images.githubusercontent.com/63526345/125489237-88d3d6b1-098a-4ecb-807c-003c7800c767.png)


**#How to access project on browser**
#1. SWAGGER - Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON.

Step1: run he url - http://localhost:8088/swagger-ui.html#/
Step2: Where we can see the swagger dashboard consist of List of operation of HTTP methods like GET, POST, DLEETE and list of REST Api operation developed
Step3: To ScheduleMessage, access the url "http://localhost:8088/swagger-ui.html#!/message-controller/scheduleMessageUsingPOST", in which it uses HTTP POST method to creat the message body and deliveryDate of message with below payload
**Expected Value:** 
{
  "deliveryDate": "2021-07-13T16:09:46.295Z",
  "message": "string"
}
Step4: Similarly to the above steps, we can do HTTP operations like GET, POST, DELETE, PUT, UPDATE, DELETE ALL and GET ALL by using the Listed Operation using Swagger API
![image](https://user-images.githubusercontent.com/63526345/125488731-165dc592-ec56-43b3-be5d-b82ab1f004f0.png)

**#How to Run the H2 Database using Browser**
H2 Database - H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode using Spring Boot.
Step1: After running the Application sucessfull and UP, Hit the below url in browser to access the H2 database
Step2: http://localhost:8088/h2-ui
Step3: use JDBC url - jdbc:h2:file:~/testdb and hit on button "connect"//to store in file database on disk
Step4: Where it provide SQL query box and list of tables
![image](https://user-images.githubusercontent.com/63526345/125488794-5c20be15-7cbc-42f8-a3fb-23d58660815e.png)

**#How Scheduler works and print the schedule messages on to Console**
Scheduler in integrated into Spring boot Application using the cron expression to run for every 1 minute time interval, in which it will fetch the message which are scheduled.
![image](https://user-images.githubusercontent.com/63526345/125489739-4f473a7c-59c7-4e92-9d7c-0f74fb52f3f7.png)

