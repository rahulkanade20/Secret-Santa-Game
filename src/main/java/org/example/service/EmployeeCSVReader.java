package org.example.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Employee;

public class EmployeeCSVReader implements DataReader<Employee> {
    @Override
    public List<Employee> read(String filepath) {
        if(!filepath.toLowerCase().endsWith(".csv")) { // appropriate input validation
            throw new IllegalArgumentException("Invalid file type. Expected a .csv file");
        }
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine();
            String line;
            while((line = br.readLine()) != null) {
                String values[] = line.split(",");
                if (values.length == 2) { // appropriate input validation
                    employees.add(new Employee(values[0].toLowerCase().trim(), values[1].toLowerCase().trim()));
                }
            }
        } catch(IOException e) { // Appropriate error handling
            e.printStackTrace();
        }
        return employees;
    }
}
