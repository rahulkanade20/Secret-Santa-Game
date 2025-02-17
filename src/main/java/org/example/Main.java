package org.example;

import java.util.List;

import org.example.model.Employee;
import org.example.model.EmployeeWithSecretSanta;
import org.example.service.DataReader;
import org.example.service.EmployeeCSVReader;
import org.example.service.EmployeeWithSecretSantaCSVReader;
import org.example.service.ProcessorService;
import org.example.service.EmployeeWithSecretSantaCSVWriter;

public class Main {
    public static void main(String[] args) {
        if(args.length < 2) { // Appropriate error handling / input validation
            System.out.println("Usage: java Application <EmployeeFile> <secretSantaFile>");
            return;
        }

        String employeeFile = args[0];
        String employeeSantaFile = args[1];

        DataReader<Employee> employeeDataReader = new EmployeeCSVReader();
        DataReader<EmployeeWithSecretSanta> employeeWithSecretSantaDataReader = new EmployeeWithSecretSantaCSVReader();

        List<Employee> employees = employeeDataReader.read(employeeFile);
        List<EmployeeWithSecretSanta> employeeWithSecretSantas = employeeWithSecretSantaDataReader.read(employeeSantaFile);
        
        ProcessorService processorService = new ProcessorService();
        List<EmployeeWithSecretSanta> employeeWithSecretSantasNew = processorService.generateNewSecretSantas(employees, employeeWithSecretSantas);

        EmployeeWithSecretSantaCSVWriter writerService = new EmployeeWithSecretSantaCSVWriter();

        writerService.write("result/SecretSantaList.csv", employeeWithSecretSantasNew);

    }
}