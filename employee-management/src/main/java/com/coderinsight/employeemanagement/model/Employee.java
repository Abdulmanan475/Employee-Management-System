package com.coderinsight.employeemanagement.model;

import com.coderinsight.employeemanagement.model.types.EmployeeStatus;
import com.coderinsight.employeemanagement.model.types.EmployeeType;
import com.coderinsight.employeemanagement.model.types.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String designation;

    @NotNull
    private String department;

    @NotNull
    private LocalDate dateOfJoining;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private LocalDate dateOfLastIncrement;

    @NotNull
    private Long pay;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Gender gender;

    private EmployeeStatus active;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceRecord> attendanceRecords;

    private String nationality;

    private EmployeeType employeeType;

    @NotNull
    private List<String> role;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull String getDesignation() {
        return designation;
    }

    public void setDesignation(@NotNull String designation) {
        this.designation = designation;
    }

    public @NotNull String getDepartment() {
        return department;
    }

    public void setDepartment(@NotNull String department) {
        this.department = department;
    }

    public @NotNull LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(@NotNull LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public @NotNull LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull LocalDate getDateOfLastIncrement() {
        return dateOfLastIncrement;
    }

    public void setDateOfLastIncrement(@NotNull LocalDate dateOfLastIncrement) {
        this.dateOfLastIncrement = dateOfLastIncrement;
    }

    public @NotNull Long getPay() {
        return pay;
    }

    public void setPay(@NotNull Long pay) {
        this.pay = pay;
    }

    public @NotNull String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotNull Gender getGender() {
        return gender;
    }

    public void setGender(@NotNull Gender gender) {
        this.gender = gender;
    }

    public EmployeeStatus getActive() {
        return active;
    }

    public void setActive(EmployeeStatus active) {
        this.active = active;
    }

    public List<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public @NotNull List<String> getRole() {
        return role;
    }

    public void setRole(@NotNull List<String> role) {
        this.role = role;
    }
}
