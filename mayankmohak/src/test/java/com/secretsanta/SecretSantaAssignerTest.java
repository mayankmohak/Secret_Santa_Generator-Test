package com.secretsanta;

import com.secretsanta.model.Employee;
import com.secretsanta.service.SecretSantaAssigner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SecretSantaAssignerTest {

    @Test
    @DisplayName("Test that the Santa is not self assigned.")
    void testValidAssignments() {
      List<Employee> employees = Arrays.asList(
        new Employee("Alice", "alice@acme.com"),
        new Employee("Bob", "bob@acme.com"),
        new Employee("Charlie", "charlie@acme.com")
      );

      Map<String, String> previousAssignments = new HashMap<>();
      Map<Employee, Employee> assignments = SecretSantaAssigner.assignSecretSantas(employees, previousAssignments);

      assertEquals(3, assignments.size());
      for (Map.Entry<Employee, Employee> entry : assignments.entrySet()) {
        assertNotEquals(entry.getKey().getEmail(), entry.getValue().getEmail()); // No self-assignment
      }
    }

    @Test
    @DisplayName("Test that the same child is not assigned to the same Santa as in the previous year")
    void testPreviousAssignments() {
      List<Employee> employees = Arrays.asList(
        new Employee("Alice", "alice@acme.com"),
        new Employee("Bob", "bob@acme.com"),
        new Employee("Charlie", "charlie@acme.com")
      );

      Map<String, String> previousAssignments = new HashMap<>();
      previousAssignments.put("alice@acme.com", "charlie@acme.com");
      previousAssignments.put("bob@acme.com", "alice@acme.com");
      previousAssignments.put("charlie@acme.com", "bob@acme.com");
      Map<Employee, Employee> assignments = SecretSantaAssigner.assignSecretSantas(employees, previousAssignments);

      assertEquals(3, assignments.size());
      for (Map.Entry<Employee, Employee> entry : assignments.entrySet()) {
        assertNotEquals(entry.getKey().getEmail(), entry.getValue().getEmail()); // No self-assignment
        assertNotEquals(previousAssignments.get(entry.getKey().getEmail()), entry.getValue().getEmail()); // not Equal to previous year
      }
    }

    @Test
    void testAtLeastTwoEmployeesRequired() {
      List<Employee> employees = Collections.singletonList(new Employee("Alice", "alice@example.com"));
      assertThrows(IllegalArgumentException.class, () -> SecretSantaAssigner.assignSecretSantas(employees, new HashMap<>()));
    }
}
