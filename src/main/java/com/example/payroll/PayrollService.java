package com.example.payroll;

public class PayrollService {
    private final TaxCalculator taxCalculator;

    // ✅ Default constructor
    public PayrollService() {
        this.taxCalculator = new TaxCalculator();
    }

    // ✅ Calculate salary for one employee
    public double calculateSalary(Employee employee) {
        double gross = employee.getBasicSalary();

        // Attendance logic (optional)
        int presentDays = employee.getAttendanceDays();
        double perDay = gross / 30.0;
        gross = perDay * presentDays;

        double tax = taxCalculator.calculateTax(gross);
        return gross - tax;
    }
}
