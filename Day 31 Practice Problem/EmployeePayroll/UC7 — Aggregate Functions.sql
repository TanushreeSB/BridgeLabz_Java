SELECT gender,
SUM(salary) AS total_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender,
AVG(salary) AS average_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender,
MIN(salary) AS minimum_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender,
MAX(salary) AS maximum_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender,
COUNT(*) AS employee_count
FROM employee_payroll
GROUP BY gender;