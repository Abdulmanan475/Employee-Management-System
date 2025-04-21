package com.coderinsight.employeemanagement.mapper;

import com.coderinsight.employeemanagement.utils.Constants;
import com.coderinsight.employeemanagement.dto.EmployeeRequestDTO;
import com.coderinsight.employeemanagement.dto.EmployeeResponseDTO;
import com.coderinsight.employeemanagement.model.Employee;
import com.coderinsight.employeemanagement.model.types.EmployeeStatus;
import com.coderinsight.employeemanagement.model.types.EmployeeType;
import com.coderinsight.employeemanagement.model.types.Gender;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;



public class EmployeeMapper {
    public static EmployeeResponseDTO toDTO(Employee employee) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId().toString());
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setEmail(employee.getEmail());
        employeeResponseDTO.setDesignation(employee.getDesignation());
        employeeResponseDTO.setDepartment(employee.getDepartment());
        employeeResponseDTO.setDateOfJoining(employee.getDateOfJoining().toString());
        employeeResponseDTO.setDateOfBirth(employee.getDateOfBirth().toString());
        employeeResponseDTO.setDateOfLastIncrement(employee.getDateOfLastIncrement().toString());
        employeeResponseDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeResponseDTO.setGender(employee.getGender().name().toLowerCase(Locale.ROOT));
        employeeResponseDTO.setNationality(employee.getNationality());
        employeeResponseDTO.setEmployeeType(employee.getEmployeeType().name().replaceAll("_", "").toLowerCase(Locale.ROOT));
        employeeResponseDTO.setActive(employee.getActive().name());
        employeeResponseDTO.setPay(employee.getPay());
        return employeeResponseDTO;
    }

    public static Employee toModel(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();

        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setDesignation(employeeRequestDTO.getDesignation());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setDateOfJoining(LocalDate.parse(employeeRequestDTO.getDateOfJoining()));
        employee.setDateOfBirth(LocalDate.parse(employeeRequestDTO.getDateOfBirth()));
        employee.setDateOfLastIncrement(LocalDate.parse(employeeRequestDTO.getDateOfLastIncrement()));
        employee.setPay(employeeRequestDTO.getPay());
        employee.setPhoneNumber(employeeRequestDTO.getPhoneNumber());
        employee.setGender(Gender.valueOf(employeeRequestDTO.getGender()));
        employee.setActive(EmployeeStatus.Active);
        employee.setAttendanceRecords(Collections.emptyList());
        employee.setNationality(employeeRequestDTO.getNationality());
        employee.setEmployeeType(EmployeeType.valueOf(employeeRequestDTO.getEmployeeType()));
        ArrayList<String> roleList = new ArrayList<>();
        roleList.add(Constants.USER);
        employee.setRole(roleList);

        return employee;

    }
}
