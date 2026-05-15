ALTER TABLE employee_payroll
ADD gender CHAR(1);

UPDATE employee_payroll SET gender = 'M'
WHERE name IN ('Bill', 'Charlie');

UPDATE employee_payroll SET gender = 'F'
WHERE name = 'Terisa';