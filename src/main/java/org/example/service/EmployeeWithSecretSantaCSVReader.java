package org.example.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.EmployeeWithSecretSanta;

public class EmployeeWithSecretSantaCSVReader implements DataReader<EmployeeWithSecretSanta> {
    @Override
    public List<EmployeeWithSecretSanta> read(String filepath) {
        if(!filepath.toLowerCase().endsWith(".csv")) { // appropriate input validation
            throw new IllegalArgumentException("Invalid file type. Expected a .csv file");
        }
        List<EmployeeWithSecretSanta> employeeWithSecretSantas = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine(); // not including header
            while((line = br.readLine()) != null) {
                String values[] = line.split(",");
                if(values.length == 4) { // appropriate input validation
                    employeeWithSecretSantas.add(new EmployeeWithSecretSanta(values[0].toLowerCase().trim(), values[1].toLowerCase().trim(), values[2].toLowerCase().trim(), values[3].toLowerCase().trim()));
                }
            }
        } catch(IOException e) { // Appropriate error handling
            e.printStackTrace();
        }
        return employeeWithSecretSantas;
    }
}
