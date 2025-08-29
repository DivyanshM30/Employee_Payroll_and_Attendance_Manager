package com.example.payroll;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private final List<AttendanceRecord> records = new ArrayList<>();

    public void markAttendance(String empId, LocalDate date, boolean present) {
        records.add(new AttendanceRecord(empId, date, present));
    }

    public int getPresentDays(String empId, YearMonth month) {
        return (int) records.stream()
                .filter(r -> r.employeeId().equals(empId)
                        && YearMonth.from(r.date()).equals(month)
                        && r.present())
                .count();
    }
}
