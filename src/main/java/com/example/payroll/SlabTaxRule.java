package com.example.payroll;

/**
 * Very simple progressive slabs (illustrative, not official):
 *  - 0 to 300,000 => 0%
 *  - 300,001 to 700,000 => 10% on amount over 300k
 *  - 700,001 to 1,200,000 => 20% on amount over 700k + 40,000
 *  - 1,200,001+ => 30% on amount over 1.2M + 140,000
 */
public class SlabTaxRule implements TaxRule {
    @Override
    public double annualTax(double income) {
        if (income <= 300_000) return 0;
        if (income <= 700_000) return 0.10 * (income - 300_000);
        if (income <= 1_200_000) return 40_000 + 0.20 * (income - 700_000);
        return 140_000 + 0.30 * (income - 1_200_000);
    }
}
