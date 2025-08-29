package com.example.payroll;

public class TaxCalculator {
    public double calculateTax(double gross) {
        if (gross <= 25000) {
            return 0;
        } else if (gross <= 50000) {
            return gross * 0.1;
        } else {
            return gross * 0.2;
        }
    }
}
