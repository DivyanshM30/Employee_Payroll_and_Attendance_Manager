# Employee Payroll & Attendance System  

A Java & Maven-based payroll management system that automates salary calculation, attendance tracking, tax deductions, and payslip generation. Designed as a simple demo project with extensible architecture.  

---

## ✨ Features  

- 🧾 **Payroll Processing**  
  - Salary calculation including **Basic, HRA, Allowances, PF, Tax**, and **Loss of Pay (LOP)** based on attendance.  
- 📅 **Attendance Tracking**  
  - Mark daily attendance and auto-calculate present days per employee.  
- 💰 **Tax Deduction**  
  - Configurable **slab-based tax rules** (example slabs included).  
- 📑 **Payslip Generation**  
  - Generate **professional PDF payslips** using Apache PDFBox.  
- 📊 **Excel Export**  
  - Export monthly payroll details to Excel using Apache POI.  
- 💻 **Command-Line Interface (CLI)**  
  - Add employees, mark attendance, and process payroll via simple CLI prompts.  

---

## 🚀 Getting Started  

### Prerequisites  
- Java 17 or higher  
- Maven 3.8+  

### Build & Run  

```bash
# Clone repository
git clone https://github.com/your-username/employee-payroll-system.git
cd employee-payroll-system

# Build project
mvn -q -DskipTests package

# Run Main class
mvn -q exec:java
