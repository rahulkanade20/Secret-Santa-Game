package org.example.model;

public class Employee {
    String name;
    String emailId;

    public Employee() {

    }

    public Employee(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee:\n" +
                "name='" + name + '\'' + "\n" +
                ", emailId='" + emailId + '\'';
    }
}
