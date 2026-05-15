INSERT INTO employee_payroll (name, salary, start_date)
VALUES
('Bill', 1000000, '2018-01-03'),
('Terisa', 2000000, '2019-11-13'),
('Charlie', 3000000, '2020-05-21');

-- =========================
-- UC4: Retrieve All Data
-- =========================
SELECT * FROM employee_payroll;

-- =========================
-- UC5: Salary + Date Filter
-- =========================
SELECT salary FROM employee_payroll
WHERE name = 'Bill';

SELECT * FROM employee_payroll
WHERE start_date BETWEEN '2018-01-01' AND GETDATE();