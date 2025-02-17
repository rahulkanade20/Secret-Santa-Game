package org.example.model;

public class EmployeeWithSecretSanta extends Employee {
    String secretSantaChildName;
    String secretSantaChildEmail;

    public EmployeeWithSecretSanta(String secretSantaChildName, String secretSantaChildEmail) {
        this.secretSantaChildName = secretSantaChildName;
        this.secretSantaChildEmail = secretSantaChildEmail;
    }

    public EmployeeWithSecretSanta(String name, String emailId, String secretSantaChildName, String secretSantaChildEmail) {
        super(name, emailId);
        this.secretSantaChildName = secretSantaChildName;
        this.secretSantaChildEmail = secretSantaChildEmail;
    }

    public String getSecretSantaChildName() {
        return secretSantaChildName;
    }

    public void setSecretSantaChildName(String secretSantaChildName) {
        this.secretSantaChildName = secretSantaChildName;
    }

    public String getSecretSantaChildEmail() {
        return secretSantaChildEmail;
    }

    public void setSecretSantaChildEmail(String secretSantaChildEmail) {
        this.secretSantaChildEmail = secretSantaChildEmail;
    }

    @Override
    public String toString() {
        return "EmployeeWithSecretSanta:\n" +
                "secretSantaChildName='" + secretSantaChildName + '\'' + "\n" +
                ", secretSantaChildEmail='" + secretSantaChildEmail + '\'' + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", emailId='" + emailId + '\'';
    }
}
