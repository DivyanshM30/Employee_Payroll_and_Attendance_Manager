package com.example.payroll;

public interface TaxRule {
    /** Annual taxable income -> annual tax payable */
    double annualTax(double taxableIncome);
}
