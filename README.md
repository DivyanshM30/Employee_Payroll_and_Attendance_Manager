# Employee Payroll System (Java, Maven)

Features:
- Salary calculation (Basic, HRA, Allowances, PF, Tax, LOP based on attendance)
- Attendance tracking
- Tax deduction via simple slab rule (illustrative)
- Payslip generation as PDF (Apache PDFBox)
- Monthly payroll export to Excel (Apache POI)
- Simple CLI for demo

## Build & Run

```bash
cd employee-payroll-system
mvn -q -DskipTests package
mvn -q exec:java
```

Or run `Main` from your IDE.

## Notes

- Tax slabs are **illustrative** and not official. Replace `SlabTaxRule` with your local rules if needed.
- Output files are written to `./output`.
- Java 17+, Maven required.
