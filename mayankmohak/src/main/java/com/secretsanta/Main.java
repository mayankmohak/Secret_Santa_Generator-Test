package com.secretsanta;
import com.secretsanta.model.Employee;
import com.secretsanta.service.SecretSantaAssigner;
import com.secretsanta.util.CsvHandler;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String EMPLOYEES_FILE = "data/employees.csv";
    private static final String PREVIOUS_ASSIGNMENTS_FILE = "data/previous_assignments.csv";
    private static final String OUTPUT_FILE = "data/secret_santa_assignments.csv";

    public static void main(String[] args) {
        try {
            List<Employee> employees = CsvHandler.readEmployees(EMPLOYEES_FILE);
            Map<String, String> previousAssignments = CsvHandler.readPreviousAssignments(PREVIOUS_ASSIGNMENTS_FILE);

            Map<Employee, Employee> assignments = SecretSantaAssigner.assignSecretSantas(employees, previousAssignments);

            CsvHandler.writeAssignments(OUTPUT_FILE, assignments);
            System.out.println("Secret Santa assignments have been generated successfully!");

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}