package org.example.service;

import java.util.*;
import java.util.stream.Collectors;

import org.example.model.Employee;
import org.example.model.EmployeeWithSecretSanta;

public class ProcessorService {
    public List<EmployeeWithSecretSanta> generateNewSecretSantas(List<Employee> employees, List<EmployeeWithSecretSanta> previousYearData) {
        List<String> emailIds = employees.stream().map(employee -> employee.getEmailId()).collect(Collectors.toList());
        List<EmployeeWithSecretSanta> newGeneratedList = new ArrayList<>();
        Set<String> previousYearParticipants = previousYearData.stream().map(emp -> emp.getEmailId()).collect(Collectors.toSet());
        Set<String> taken = new HashSet<>();
        Random random = new Random();
        for(EmployeeWithSecretSanta e : previousYearData) {
            if(emailIds.contains(e.getEmailId())) {
                while(true) {
                    String email = emailIds.get(random.nextInt(emailIds.size()));
                    if(!email.equals(e.getEmailId()) && !email.equals(e.getSecretSantaChildEmail()) && !taken.contains(email)) {
                        taken.add(email);
                        Employee santa = employees.stream().
                                filter(employee -> e.getEmailId().equals(employee.getEmailId()))
                                .findFirst()
                                .orElse(null);
                        Employee child = employees.stream()
                                .filter(employee -> email.equals(employee.getEmailId()))
                                .findFirst()
                                .orElse(null);
                        newGeneratedList.add(new EmployeeWithSecretSanta(santa.getName(), santa.getEmailId(), child.getName(), child.getEmailId()));
                        break;
                    }
                }
            }
        }
        for(Employee e : employees) {
            if(!previousYearParticipants.contains(e.getEmailId())) {
                while(true) {
                    String email = emailIds.get(random.nextInt(emailIds.size()));
                    if(!email.equals(e.getEmailId()) && !taken.contains(email)) {
                        taken.add(email);
                        Employee santa = employees.stream().
                                filter(employee -> e.getEmailId().equals(employee.getEmailId()))
                                .findFirst()
                                .orElse(null);
                        Employee child = employees.stream()
                                .filter(employee -> email.equals(employee.getEmailId()))
                                .findFirst()
                                .orElse(null);
                        newGeneratedList.add(new EmployeeWithSecretSanta(santa.getName(), santa.getEmailId(), child.getName(), child.getEmailId()));
                        break;
                    }
                }
            }
        }
        return newGeneratedList;
    }
}
