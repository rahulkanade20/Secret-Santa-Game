# Secret-Santa-Game

Overview of problem statement and solution provided
---

- Need to provide a solution for Secret Santa event amongst employees.
- Each employee is required to choose another employee as their secret child, to whom they will anonymously give a gift during the event.

- Requirements and constraints - 
  - 2 input files (csv format) will be given, first file consists of the employee details (employee name and employee email id), second file consists of the previous year's      secret santa assignments (employee name, employee email address, secret child name, secret child email address).
  - Our goal is to assign a secret child to each and every employee such that - 
    - An employee cannot have themselves as a secret child.
    - An employee cannot be assigned the same secret child as previous year (if applicable).
    - Each employee will have only one secret child.
    - Each secret child will be assigned to only one employee.

- Need to generate a new csv file which will have - 
- Employee name, employee email id, newly assigned secret child name, newly assigned secret child email id.

Design details
---

- The solution has been implemented using Core java and is fully modular and extensible (OOPs principles and best practices followed wherever applicable).
- Error handling has been implemented wherever applicable to gracefully handle exceptions.
- The logic has been split into various classes (following OOPs principles).
- The solution includes 2 model classes Employee and EmployeeWithSecretSatna to receive the input csv files.
- We have a DataReader interface which is used to abstarct the mechanism for handling input data (use of strategy design pattern).
- We have 2 concrete implementation of DataReader one for reading the Employee csv file and one for reading the Employee with previous secret santa details csv file.
- We have a processorService which has all the logic included to make use of the input data and randomnly assign secret child to each employee taking into consideration all - requirements and constraints mentioned in the above section.
- Once processing is done we have a Data Writer interface which is used to abstract the mechanism for handling creation of output in the requirred format. (use of strategy design pattern).
- We have a implementation of this Data writer interface for creating a new .csv file and writing the newly generated secret santa data in the .csv file.
- Finally we call all the required classes in the main in the following order - input-processing-output.

Instructions to install and run the program and other requirements
---
- Requirements
  - You must have JRE v17 or above installed on your machine.

- Steps to run
  - Download the jar file provided in the source code and save it in a new folder.
  - Download the data folder and csv files provided in the source code and save it in the same new folder.
  - Start cmd and navigate to the newly created folder.
  - Run the following command -
      - java -jar target/SecretSantaGame-1.0-SNAPSHOT.jar data/employees.csv data/employees-previous-santa-info.csv
  - If all instructions are followed correctly a new folder named result will be created and it will have a SecretSantaList.csv file which will include the newly generated secret sant / secret child pairing for each employee.
  - Now you can update the 2 input csv files with your organizations data and follow the same procedure and once done successfully you will find the updated results in the result/SecretSantaList.csv file

