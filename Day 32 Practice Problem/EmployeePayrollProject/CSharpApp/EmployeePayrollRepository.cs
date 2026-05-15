using System;
using System.Collections.Generic;
using System.Data.SqlClient;

public class EmployeePayrollRepository
{
    public List<EmployeePayroll> GetAllEmployees()
    {
        List<EmployeePayroll> employees =
            new List<EmployeePayroll>();

        SqlConnection connection =
            DatabaseConnection.GetConnection();

        string query =
            "SELECT * FROM employee_payroll";

        SqlCommand command =
            new SqlCommand(query, connection);

        connection.Open();

        SqlDataReader reader =
            command.ExecuteReader();

        while (reader.Read())
        {
            EmployeePayroll employee =
                new EmployeePayroll();

            employee.Id =
                Convert.ToInt32(reader["id"]);

            employee.Name =
                reader["name"].ToString();

            employee.Salary =
                Convert.ToDouble(reader["salary"]);

            employees.Add(employee);
        }

        connection.Close();

        return employees;
    }
}