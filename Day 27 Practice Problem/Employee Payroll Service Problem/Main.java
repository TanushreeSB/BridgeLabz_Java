package com.payroll;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<EmployeePayrollData> employeeList =
                new ArrayList<>();

        EmployeePayrollService payrollService =
                new EmployeePayrollService(employeeList);

        Scanner scanner = new Scanner(System.in);

        // UC1
        payrollService.readEmployeePayrollData(scanner);
        payrollService.writeEmployeePayrollData();

        // UC2
        FileOperations.performOperations();

        // UC4
        payrollService.writeEmployeePayrollToFile(
                "payroll-file.txt");

        // UC5
        payrollService.printData("payroll-file.txt");

        long entries =
                payrollService.countEntries("payroll-file.txt");

        System.out.println("Entries Count : " + entries);

        // UC6
        List<String> payrollData =
                payrollService.readData("payroll-file.txt");

        payrollData.forEach(System.out::println);
    }
}