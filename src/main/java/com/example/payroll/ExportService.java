package com.example.payroll;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportService {

    //Generate payslip as PDF
    public void generatePayslip(Employee employee, double netSalary) {
        String fileName = "Payslip_" + employee.getId() + ".pdf";

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText("Employee Payslip");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(50, 660);
            contentStream.showText("Employee ID: " + employee.getId());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Name: " + employee.getName());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Net Salary: " + netSalary);
            contentStream.endText();

            contentStream.close();
            doc.save(fileName);

            System.out.println("Payslip generated: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Export payroll list as Excel
    public void exportPayrollToExcel(List<Employee> employees) {
        String fileName = "Payroll.xlsx";
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Payroll");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Employee ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Net Salary");

            int rowIdx = 1;
            PayrollService payrollService = new PayrollService();

            for (Employee emp : employees) {
                double netSalary = payrollService.calculateSalary(emp);

                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(emp.getId());
                row.createCell(1).setCellValue(emp.getName());
                row.createCell(2).setCellValue(netSalary);
            }

            try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
                workbook.write(fos);
            }

            System.out.println("Payroll exported to Excel: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
