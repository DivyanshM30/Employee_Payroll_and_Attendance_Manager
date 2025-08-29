package com.example.payroll;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollService payrollService = new PayrollService();
        ExportService exportService = new ExportService();
        AttendanceService attendanceService = new AttendanceService();

        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Payroll System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Generate Payroll & Payslips");
            System.out.println("4. Export Payroll to Excel");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    double basic = scanner.nextDouble();

                    Employee emp = new Employee(id, name, basic);
                    employees.add(emp);

                    System.out.println("Employee added successfully!");
                }

                case 2 -> {
                    if (employees.isEmpty()) {
                        System.out.println("No employees available. Add employees first.");
                        break;
                    }
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();

                    Employee emp = employees.stream()
                            .filter(e -> e.getId().equals(id))
                            .findFirst()
                            .orElse(null);

                    if (emp == null) {
                        System.out.println("Employee not found!");
                        break;
                    }

                    YearMonth thisMonth = YearMonth.now();
                    System.out.print("Enter number of days present this month: ");
                    int presentDays = scanner.nextInt();

                    for (int i = 1; i <= presentDays; i++) {
                        attendanceService.markAttendance(
                                id,
                                LocalDate.of(thisMonth.getYear(), thisMonth.getMonth(), i),
                                true
                        );
                    }

                    emp.setAttendanceDays(attendanceService.getPresentDays(id, thisMonth));
                    System.out.println("Attendance marked for " + emp.getName());
                }

                case 3 -> {
                    if (employees.isEmpty()) {
                        System.out.println("No employees to process payroll for.");
                        break;
                    }

                    System.out.println("\n--- Payroll Summary ---");
                    for (Employee e : employees) {
                        double netSalary = payrollService.calculateSalary(e);
                        System.out.printf("Employee: %s | Net Salary: %.2f%n", e.getName(), netSalary);
                        exportService.generatePayslip(e, netSalary);
                    }
                    System.out.println("Payslips generated!");
                }

                case 4 -> {
                    if (employees.isEmpty()) {
                        System.out.println("No employees to export.");
                        break;
                    }
                    exportService.exportPayrollToExcel(employees);
                    System.out.println("Payroll exported to Excel.");
                }

                case 5 -> {
                    System.out.println("Exiting Payroll System... Goodbye!");
                    return; // exit program
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
