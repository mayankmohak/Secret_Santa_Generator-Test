# Secret_Santa_Generator-Test
This repo is build to submit test solution

### Steps to run
 1. Add sample test files in data folder
 2. Run main class using below commands.
    - mvn clean install
    - java -jar target/mayankmohak-1.0-SNAPSHOT.jar
 3. Run Test class using
    - mvn test

### Note
 - Unit Test is done in com.secretsanta.SecretSantaAssignerTest
 - Model class is Employee.java
 - Assignment logic is build in com.secretsanta.model.Employee.SecretSantaAssigner
 - Reading and writing from csv is done in CSV Handler

### Project Structure
 
secret-santa/<br>
│── src/main/java/com/secretsanta/<br>
│   ├── Main.java<br>
│   ├── model/Employee.java<br>
│   ├── service/SecretSantaAssigner.java<br>
│   ├── util/CsvHandler.java<br>
│── src/test/java/com/secretsanta/<br>
│   ├── SecretSantaAssignerTest.java<br>
│── data/<br>
│   ├── employees.csv<br>
│   ├── previous_assignments.csv<br>
│   ├── secret_santa_assignments.csv<br>
│── README.md<br>
│── pom.xml (for Maven and Junits)<br>
│── .gitignore<br>
