package com.example.payroll;

public class Employee {
    private String id;
    private String name;
    private double basicSalary;
    private int attendanceDays;

    public Employee(String id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.attendanceDays = 0; // default
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public int getAttendanceDays() {
        return attendanceDays;
    }

    //Setter for attendance
    public void setAttendanceDays(int days) {
        this.attendanceDays = days;
    }
}
