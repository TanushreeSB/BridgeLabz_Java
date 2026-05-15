SELECT gender, SUM(salary) AS total_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, AVG(salary) AS avg_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, MIN(salary) AS min_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, MAX(salary) AS max_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, COUNT(*) AS count
FROM employee_payroll
GROUP BY gender;