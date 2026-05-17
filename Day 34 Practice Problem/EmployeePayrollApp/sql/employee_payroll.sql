-- =====================================================
-- UC1 : Create Payroll Service Database
-- =====================================================

CREATE DATABASE IF NOT EXISTS payroll_service;

USE payroll_service;


-- =====================================================
-- UC2 : Create Employee Payroll Table
-- =====================================================

CREATE TABLE IF NOT EXISTS employee_payroll
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    salary DOUBLE,
    start DATE
);


-- =====================================================
-- UC3 : Insert Employee Payroll Data
-- =====================================================

INSERT INTO employee_payroll
(name, salary, start)
VALUES
('Bill', 1000000.00, '2018-01-03'),
('Terisa', 2000000.00, '2019-11-13'),
('Charlie', 3000000.00, '2020-05-21');


-- =====================================================
-- UC4 : Retrieve All Employee Payroll Data
-- =====================================================

SELECT * FROM employee_payroll;


-- =====================================================
-- UC5 : Retrieve Salary Data and Date Range Data
-- =====================================================

SELECT salary
FROM employee_payroll
WHERE name = 'Bill';

SELECT *
FROM employee_payroll
WHERE start BETWEEN
CAST('2018-01-01' AS DATE)
AND DATE(NOW());


-- =====================================================
-- UC6 : Add Gender Column and Update Values
-- =====================================================

ALTER TABLE employee_payroll
ADD gender CHAR(1)
AFTER name;

UPDATE employee_payroll
SET gender = 'M'
WHERE name = 'Bill'
OR name = 'Charlie';

UPDATE employee_payroll
SET gender = 'F'
WHERE name = 'Terisa';


-- =====================================================
-- UC7 : Aggregate Functions
-- =====================================================

-- SUM

SELECT gender,
SUM(salary) AS TotalSalary
FROM employee_payroll
GROUP BY gender;

-- AVG

SELECT gender,
AVG(salary) AS AverageSalary
FROM employee_payroll
GROUP BY gender;

-- MIN

SELECT gender,
MIN(salary) AS MinimumSalary
FROM employee_payroll
GROUP BY gender;

-- MAX

SELECT gender,
MAX(salary) AS MaximumSalary
FROM employee_payroll
GROUP BY gender;

-- COUNT

SELECT gender,
COUNT(*) AS EmployeeCount
FROM employee_payroll
GROUP BY gender;


-- =====================================================
-- UC8 : Extend Employee Payroll Table
-- =====================================================

ALTER TABLE employee_payroll
ADD phone VARCHAR(15),
ADD address VARCHAR(250) DEFAULT 'TBD',
ADD department VARCHAR(50) NOT NULL DEFAULT 'General';


-- =====================================================
-- UC9 : Add Payroll Columns
-- =====================================================

ALTER TABLE employee_payroll
ADD basic_pay DOUBLE,
ADD deductions DOUBLE,
ADD taxable_pay DOUBLE,
ADD income_tax DOUBLE,
ADD net_pay DOUBLE;


-- =====================================================
-- Update Payroll Values
-- =====================================================

UPDATE employee_payroll
SET basic_pay = salary,
    deductions = 100000,
    taxable_pay = salary - 100000,
    income_tax = 50000,
    net_pay = salary - 150000;


-- =====================================================
-- UC10 : Create Normalized ER Diagram Tables
-- =====================================================

CREATE TABLE IF NOT EXISTS employee
(
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    gender CHAR(1),
    phone VARCHAR(15),
    address VARCHAR(250),
    start DATE
);


CREATE TABLE IF NOT EXISTS payroll
(
    payroll_id INT PRIMARY KEY AUTO_INCREMENT,
    basic_pay DOUBLE,
    deductions DOUBLE,
    taxable_pay DOUBLE,
    income_tax DOUBLE,
    net_pay DOUBLE,
    emp_id INT,

    FOREIGN KEY(emp_id)
    REFERENCES employee(emp_id)
);


CREATE TABLE IF NOT EXISTS department
(
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS employee_department
(
    emp_id INT,
    dept_id INT,

    FOREIGN KEY(emp_id)
    REFERENCES employee(emp_id),

    FOREIGN KEY(dept_id)
    REFERENCES department(dept_id)
);


-- =====================================================
-- Insert Data into Normalized Tables
-- =====================================================

INSERT INTO employee
(name, gender, phone, address, start)
VALUES
('Bill', 'M', '9876543210', 'Chennai', '2018-01-03'),
('Terisa', 'F', '9123456780', 'Mumbai', '2019-11-13'),
('Charlie', 'M', '9988776655', 'Delhi', '2020-05-21');


INSERT INTO department
(dept_name)
VALUES
('Sales'),
('Marketing'),
('HR');


INSERT INTO payroll
(basic_pay, deductions, taxable_pay,
 income_tax, net_pay, emp_id)
VALUES
(1000000, 100000, 900000, 50000, 850000, 1),
(2000000, 150000, 1850000, 100000, 1750000, 2),
(3000000, 200000, 2800000, 150000, 2650000, 3);


INSERT INTO employee_department
(emp_id, dept_id)
VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 3);


-- =====================================================
-- UC11 : Queries using New ER Structure
-- =====================================================

-- Retrieve Complete Employee Payroll Data

SELECT *
FROM employee e
JOIN payroll p
ON e.emp_id = p.emp_id;


-- Retrieve Salary By Employee Name

SELECT e.name,
p.basic_pay
FROM employee e
JOIN payroll p
ON e.emp_id = p.emp_id
WHERE e.name = 'Bill';


-- Employees Joined Between Dates

SELECT *
FROM employee
WHERE start BETWEEN
'2018-01-01'
AND CURDATE();


-- Aggregate Functions using Normalized Tables

SELECT e.gender,
SUM(p.basic_pay) AS TotalSalary
FROM employee e
JOIN payroll p
ON e.emp_id = p.emp_id
GROUP BY e.gender;


SELECT e.gender,
AVG(p.basic_pay) AS AverageSalary
FROM employee e
JOIN payroll p
ON e.emp_id = p.emp_id
GROUP BY e.gender;


SELECT e.gender,
MIN(p.basic_pay) AS MinimumSalary
FROM employee e
JOIN payroll p
ON e.emp_id = p.emp_id
GROUP BY e.gender;


SELECT e.gender,
MAX(p.basic_pay) AS MaximumSalary
FROM employee e
JOIN payroll p
ON e.emp_id = p.emp_id
GROUP BY e.gender;


SELECT e.gender,
COUNT(*) AS EmployeeCount
FROM employee e
JOIN payroll p
ON e.emp_id = p.emp_id
GROUP BY e.gender;