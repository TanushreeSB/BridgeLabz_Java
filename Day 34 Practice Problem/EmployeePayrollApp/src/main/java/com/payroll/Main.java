package com.payroll;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        try {

            PayrollDBService service =
                    new PayrollDBService();

            Connection connection =
                    service.getConnection();

            System.out.println(
                    "Connection Established Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}