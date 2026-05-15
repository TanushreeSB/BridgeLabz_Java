package com.payroll;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    // UC1 - Read Employee Data from Console
    public void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.print("Enter Employee ID : ");
        int id = consoleInputReader.nextInt();

        System.out.print("Enter Employee Name : ");
        String name = consoleInputReader.next();

        System.out.print("Enter Employee Salary : ");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    // UC1 - Write to Console
    public void writeEmployeePayrollData() {
        System.out.println("Employee Payroll Data:");
        employeePayrollList.forEach(System.out::println);
    }

    // UC4 - Write Employee Payroll to File
    public void writeEmployeePayrollToFile(String fileName) {
        StringBuffer employeeBuffer = new StringBuffer();

        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            employeeBuffer.append(employeeDataString);
        });

        try {
            Files.write(Paths.get(fileName),
                    employeeBuffer.toString().getBytes());

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // UC5 - Print Payroll File
    public void printData(String fileName) {
        try {
            Files.lines(new File(fileName).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // UC5 - Count Entries
    public long countEntries(String fileName) {
        long entries = 0;

        try {
            entries = Files.lines(new File(fileName).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entries;
    }

    // UC6 - Read File for Analysis
    public List<String> readData(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.lines(Paths.get(fileName))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}