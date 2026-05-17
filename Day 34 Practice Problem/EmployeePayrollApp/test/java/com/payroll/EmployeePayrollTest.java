package com.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class EmployeePayrollTest {

    @Test
    public void givenConnection_WhenCorrect_ShouldReturnTrue() {

        try {

            PayrollDBService service =
                    new PayrollDBService();

            Connection connection =
                    service.getConnection();

            Assert.assertNotNull(connection);

        } catch (Exception e) {

            Assert.fail();
        }
    }
}