ALTER TABLE employee_payroll
ADD phone VARCHAR(15),
    address VARCHAR(255),
    department VARCHAR(50);

-- =========================
-- UC9: Add Payroll Fields
-- =========================
ALTER TABLE employee_payroll
ADD basic_pay FLOAT,
    deductions FLOAT,
    taxable_pay FLOAT,
    income_tax FLOAT,
    net_pay FLOAT;