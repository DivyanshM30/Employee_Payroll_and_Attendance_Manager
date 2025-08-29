package com.example.payroll;

import java.time.LocalDate;

public record AttendanceRecord(String employeeId, LocalDate date, boolean present) {}
