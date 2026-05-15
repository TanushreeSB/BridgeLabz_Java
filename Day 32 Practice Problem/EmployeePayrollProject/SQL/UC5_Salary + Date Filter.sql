SELECT salary FROM employee_payroll
WHERE name = 'Bill';

SELECT * FROM employee_payroll
WHERE start_date BETWEEN '2018-01-01' AND GETDATE();