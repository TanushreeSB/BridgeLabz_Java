
-- =========================================
-- UC 1 : CREATE DATABASE
-- =========================================

CREATE DATABASE payroll_service;

SHOW DATABASES;

USE payroll_service;

-- =========================================
-- UC 2 : CREATE EMPLOYEE PAYROLL TABLE
-- =========================================

CREATE TABLE employee_payroll (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    salary DOUBLE NOT NULL,
    start DATE NOT NULL,
    PRIMARY KEY(id)
);

DESC employee_payroll;

-- =========================================
-- UC 3 : INSERT EMPLOYEE DATA
-- =========================================

INSERT INTO employee_payroll
(name, salary, start)
VALUES
('Bill', 1000000.00, '2018-01-03'),
('Terisa', 2000000.00, '2019-11-13'),
('Charlie', 3000000.00, '2020-05-21');

-- =========================================
-- UC 4 : RETRIEVE ALL EMPLOYEES
-- =========================================

SELECT * FROM employee_payroll;

-- =========================================
-- UC 5 : RETRIEVE SALARY & DATE RANGE
-- =========================================

SELECT salary
FROM employee_payroll
WHERE name = 'Bill';

SELECT *
FROM employee_payroll
WHERE start BETWEEN
CAST('2018-01-01' AS DATE)
AND DATE(NOW());

-- =========================================
-- UC 6 : ADD GENDER COLUMN
-- =========================================

ALTER TABLE employee_payroll
ADD gender CHAR(1) AFTER name;

UPDATE employee_payroll
SET gender = 'M'
WHERE name = 'Bill'
OR name = 'Charlie';

UPDATE employee_payroll
SET gender = 'F'
WHERE name = 'Terisa';

-- =========================================
-- UC 7 : AGGREGATE FUNCTIONS
-- =========================================

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

-- =========================================
-- UC 8 : ADD PHONE, ADDRESS, DEPARTMENT
-- =========================================

ALTER TABLE employee_payroll
ADD phone_number VARCHAR(15),
ADD address VARCHAR(250) DEFAULT 'TBD',
ADD department VARCHAR(100) NOT NULL DEFAULT 'General';

-- =========================================
-- UC 9 : ADD PAYROLL COLUMNS
-- =========================================

ALTER TABLE employee_payroll
ADD basic_pay DOUBLE,
ADD deductions DOUBLE,
ADD taxable_pay DOUBLE,
ADD income_tax DOUBLE,
ADD net_pay DOUBLE;

-- =========================================
-- UPDATE PAYROLL DETAILS
-- =========================================

UPDATE employee_payroll
SET
basic_pay = salary,
deductions = salary * 0.2,
taxable_pay = salary - (salary * 0.2),
income_tax = (salary - (salary * 0.2)) * 0.1,
net_pay = salary - ((salary - (salary * 0.2)) * 0.1);

-- =========================================
-- UC 10 : INSERT TERISA INTO MULTIPLE DEPARTMENTS
-- =========================================

INSERT INTO employee_payroll
(name, gender, salary, start, department,
basic_pay, deductions, taxable_pay,
income_tax, net_pay)
VALUES
('Terisa', 'F', 3000000, '2019-11-13',
'Sales', 3000000, 600000, 2400000,
240000, 2760000),

('Terisa', 'F', 3000000, '2019-11-13',
'Marketing', 3000000, 600000, 2400000,
240000, 2760000);

-- =========================================
-- NORMALIZED DATABASE DESIGN
-- =========================================

DROP TABLE IF EXISTS employee_department;
DROP TABLE IF EXISTS payroll_details;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employee;

-- =========================================
-- EMPLOYEE TABLE
-- =========================================

CREATE TABLE employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(150),
    gender CHAR(1),
    phone_number VARCHAR(15),
    address VARCHAR(250) DEFAULT 'TBD',
    start_date DATE,
    is_active BOOLEAN DEFAULT TRUE
);

-- =========================================
-- PAYROLL DETAILS TABLE
-- =========================================

CREATE TABLE payroll_details (
    payroll_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    basic_pay DOUBLE,
    deductions DOUBLE,
    taxable_pay DOUBLE,
    income_tax DOUBLE,
    net_pay DOUBLE,

    FOREIGN KEY(employee_id)
    REFERENCES employee(employee_id)
    ON DELETE CASCADE
);

-- =========================================
-- DEPARTMENT TABLE
-- =========================================

CREATE TABLE department (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100)
);

-- =========================================
-- EMPLOYEE-DEPARTMENT MAPPING TABLE
-- =========================================

CREATE TABLE employee_department (
    employee_id INT,
    department_id INT,

    PRIMARY KEY(employee_id, department_id),

    FOREIGN KEY(employee_id)
    REFERENCES employee(employee_id),

    FOREIGN KEY(department_id)
    REFERENCES department(department_id)
);

-- =========================================
-- INSERT EMPLOYEES
-- =========================================

INSERT INTO employee
(name, gender, phone_number, address, start_date)
VALUES
('Bill', 'M', '9876543210', 'Chennai', '2018-01-03'),
('Terisa', 'F', '9876543211', 'Bangalore', '2019-11-13'),
('Charlie', 'M', '9876543212', 'Mumbai', '2020-05-21');

-- =========================================
-- INSERT PAYROLL DETAILS
-- =========================================

INSERT INTO payroll_details
(employee_id, basic_pay, deductions,
taxable_pay, income_tax, net_pay)
VALUES
(1, 1000000, 200000, 800000, 80000, 920000),
(2, 2000000, 400000, 1600000, 160000, 1840000),
(3, 3000000, 600000, 2400000, 240000, 2760000);

-- =========================================
-- INSERT DEPARTMENTS
-- =========================================

INSERT INTO department(department_name)
VALUES
('Sales'),
('Marketing'),
('HR'),
('Finance');

-- =========================================
-- MAP EMPLOYEES TO DEPARTMENTS
-- =========================================

INSERT INTO employee_department
(employee_id, department_id)
VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 3);

-- =========================================
-- RETRIEVE ALL EMPLOYEES
-- =========================================

SELECT * FROM employee;

-- =========================================
-- RETRIEVE SALARY OF BILL
-- =========================================

SELECT basic_pay
FROM payroll_details
WHERE employee_id =
(
    SELECT employee_id
    FROM employee
    WHERE name = 'Bill'
);

-- =========================================
-- RETRIEVE EMPLOYEES BETWEEN DATE RANGE
-- =========================================

SELECT *
FROM employee
WHERE start_date BETWEEN
CAST('2018-01-01' AS DATE)
AND DATE(NOW());

-- =========================================
-- AGGREGATE FUNCTIONS USING JOIN
-- =========================================

SELECT e.gender,
SUM(p.basic_pay) AS total_salary,
AVG(p.basic_pay) AS average_salary,
MIN(p.basic_pay) AS minimum_salary,
MAX(p.basic_pay) AS maximum_salary,
COUNT(*) AS employee_count
FROM employee e
INNER JOIN payroll_details p
ON e.employee_id = p.employee_id
GROUP BY e.gender;

-- =========================================
-- SOFT DELETE EMPLOYEE
-- =========================================

UPDATE employee
SET is_active = FALSE
WHERE employee_id = 1;

-- =========================================
-- RETRIEVE ACTIVE EMPLOYEES
-- =========================================

SELECT *
FROM employee
WHERE is_active = TRUE;

-- =========================================
-- COMPLETE JOIN QUERY
-- =========================================

SELECT
e.employee_id,
e.name,
e.gender,
e.phone_number,
e.address,
e.start_date,
d.department_name,
p.basic_pay,
p.deductions,
p.taxable_pay,
p.income_tax,
p.net_pay
FROM employee e
LEFT JOIN payroll_details p
ON e.employee_id = p.employee_id
LEFT JOIN employee_department ed
ON e.employee_id = ed.employee_id
LEFT JOIN department d
ON ed.department_id = d.department_id
WHERE e.is_active = TRUE;

-- =========================================
-- END OF FILE
-- =========================================