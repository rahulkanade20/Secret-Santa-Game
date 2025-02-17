package org.example.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.example.model.EmployeeWithSecretSanta;

public class EmployeeWithSecretSantaCSVWriter implements DataWriter<EmployeeWithSecretSanta> {
    @Override
    public int write(String filepath, List<EmployeeWithSecretSanta> data) {
        if(!filepath.toLowerCase().endsWith(".csv")) { // appropriate input validation
            throw new IllegalArgumentException("Invalid file type. Expected a .csv file");
        }
        new File(filepath).getParentFile().mkdir();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID");
            writer.newLine();
            for(EmployeeWithSecretSanta e : data) {
                writer.write(e.getName() + "," + e.getEmailId() + "," + e.getSecretSantaChildName() + "," + e.getSecretSantaChildEmail());
                writer.newLine();
            }
        } catch(IOException e) { // Appropriate error handling
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
