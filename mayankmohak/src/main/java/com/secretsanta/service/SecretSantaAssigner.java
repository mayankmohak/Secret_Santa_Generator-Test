package com.secretsanta.service;

import com.secretsanta.model.Employee;
import java.util.*;

public class SecretSantaAssigner {

    public static Map<Employee, Employee> assignSecretSantas(List<Employee> employees, Map<String, String> previousAssignments) {
        if (employees.size() < 2) {
            throw new IllegalArgumentException("At least two employees are needed for Secret Santa.");
        }

        List<Employee> availableReceivers = new ArrayList<>(employees);
        Map<Employee, Employee> assignments = new HashMap<>();
        Boolean breakReuired = false;

        for(int i=0;i<employees.size();i++) {
          Employee santa = employees.get(i);
          Employee receiver = findValidChild(santa, availableReceivers, employees, previousAssignments);
          if (receiver == null) {
            // Reseting assignments and try again
            assignments.clear();
            availableReceivers = new ArrayList<>(employees);
            System.out.println("Resetting assignments and trying again...");
            i = -1;
            if(breakReuired){
              System.out.println("There is some issue with the data provided. Reach out to mayankmohak@gmail.com for resolution.");
              break;
            }
            breakReuired = true;
          } else {
            assignments.put(santa, receiver);
            availableReceivers.remove(receiver);
          }
        }
        return assignments;
    }

    private static Employee findValidChild(Employee santa, List<Employee> availableReceivers, List<Employee> employees, Map<String, String> previousAssignments) {
      if(previousAssignments.isEmpty()) {
        return availableReceivers.get(availableReceivers.size() == 1 ? 0 : 1);
      }
      else{
        for(Employee receiver : availableReceivers) {
          String santaEmail = santa.getEmail();
          String receiverEmail = receiver.getEmail();
          String previousChildEmail = previousAssignments.get(santaEmail);
          if (!santaEmail.equals(receiverEmail) 
          && !receiverEmail.equals(previousChildEmail)) {
            return receiver;
          }
        }
        return null;
      }
    }
}
