package com.coderinsight.employeemanagement.model;

import com.coderinsight.employeemanagement.model.types.AttendanceStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date; // The date of the attendance
    private AttendanceStatus status;
    private Long workedHours; // The number of hours worked on that day (optional)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "employee_id")  // This column in the attendance table will reference Employee
    private Employee employee;  // Reference to the employee this record belongs to

    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    public Long getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Long workedHours) {
        this.workedHours = workedHours;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
