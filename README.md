# Secret_Santa_Generator-Test
This repo is build to submit test solution

### Steps to run
 1. Add sample test files in data folder
 2. run main class

### Note
 - Unit Test is done in com.secretsanta.SecretSantaAssignerTest
 - Model class is Employee.java
 - Assignment logic is build in com.secretsanta.model.Employee.SecretSantaAssigner
 - Reading and writing from csv is done in CSV Handler

### Project Structure

secret-santa/
│── src/main/java/com/secretsanta/
│   ├── Main.java
│   ├── model/Employee.java
│   ├── service/SecretSantaAssigner.java
│   ├── util/CsvHandler.java
│── src/test/java/com/secretsanta/
│   ├── SecretSantaAssignerTest.java
│── data/
│   ├── employees.csv
│   ├── previous_assignments.csv
│   ├── secret_santa_assignments.csv
│── README.md
│── pom.xml (for Maven and Junits)
│── .gitignore