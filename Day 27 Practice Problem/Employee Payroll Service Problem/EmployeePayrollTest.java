package com.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollTest {

    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEntries() {

        EmployeePayrollData emp1 =
                new EmployeePayrollData(1, "Amit", 50000);

        EmployeePayrollData emp2 =
                new EmployeePayrollData(2, "Rahul", 60000);

        EmployeePayrollData emp3 =
                new EmployeePayrollData(3, "Priya", 70000);

        List<EmployeePayrollData> list = new ArrayList<>();

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        EmployeePayrollService payrollService =
                new EmployeePayrollService(list);

        payrollService.writeEmployeePayrollToFile(
                "payroll-file.txt");

        long entries =
                payrollService.countEntries("payroll-file.txt");

        Assert.assertEquals(3, entries);
    }
}