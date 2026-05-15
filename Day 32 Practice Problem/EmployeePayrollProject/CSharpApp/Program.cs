using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine(
            "Welcome to Employee Payroll App");

        EmployeePayrollRepository repository =
            new EmployeePayrollRepository();

        var employees =
            repository.GetAllEmployees();

        foreach (var employee in employees)
        {
            Console.WriteLine(
                employee.Id + " "
                + employee.Name + " "
                + employee.Salary);
        }
    }
}