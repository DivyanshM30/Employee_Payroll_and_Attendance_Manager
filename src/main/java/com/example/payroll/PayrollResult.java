package com.example.payroll;

public record PayrollResult(
        double gross,
        double tax,
        double pf,
        double net
) {}
