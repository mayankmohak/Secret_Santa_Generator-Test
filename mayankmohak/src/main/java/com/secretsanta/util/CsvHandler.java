package com.secretsanta.util;

import com.secretsanta.model.Employee;
import java.io.*;
import java.util.*;

public class CsvHandler {

    public static List<Employee> readEmployees(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    employees.add(new Employee(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch( FileNotFoundException e) {
            System.err.println("File not found " + filePath);
            throw e;
        } catch(IOException e) {
            System.err.println("Error processing file " + filePath);
            throw e;
        }
        return employees;
    }

    public static Map<String, String> readPreviousAssignments(String filePath) throws IOException {
        Map<String, String> previousAssignments = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    previousAssignments.put(parts[1].trim(), parts[3].trim()); // (EmployeeEmail, SecretChildEmail)
                }
            }
        } catch( FileNotFoundException e) {
            System.err.println("File not found " + filePath);
        } catch(IOException e) {
            System.err.println("Error processing file " + filePath);
            throw e;
        }
        return previousAssignments;
    }

    public static void writeAssignments(String filePath, Map<Employee, Employee> assignments) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID\n");
            for (Map.Entry<Employee, Employee> entry : assignments.entrySet()) {
                Employee santa = entry.getKey();
                Employee child = entry.getValue();
                bw.write(String.format("%s,%s,%s,%s\n", santa.getName(), santa.getEmail(), child.getName(), child.getEmail()));
            }
        }
    }
}