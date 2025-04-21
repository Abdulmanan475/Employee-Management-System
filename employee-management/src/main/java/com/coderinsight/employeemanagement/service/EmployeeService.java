package com.coderinsight.employeemanagement.service;

import com.coderinsight.employeemanagement.dto.EmployeeRequestDTO;
import com.coderinsight.employeemanagement.dto.EmployeeResponseDTO;
import com.coderinsight.employeemanagement.exception.EmailAlreadyExistsException;
import com.coderinsight.employeemanagement.exception.EmployeeNotFoundException;
import com.coderinsight.employeemanagement.mapper.EmployeeMapper;
import com.coderinsight.employeemanagement.model.Employee;
import com.coderinsight.employeemanagement.model.types.EmployeeType;
import com.coderinsight.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        if (employeeRepository.existsByEmail(requestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Employee with this email already exists: " + requestDTO.getEmail());
        }

        Employee savedEmployee = employeeRepository.save(EmployeeMapper.toModel(requestDTO));

        return EmployeeMapper.toDTO(savedEmployee);
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(EmployeeMapper::toDTO).toList();
    }

    public Optional<EmployeeResponseDTO> getAnEmployeeWithId(UUID id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        return employeeById.map(EmployeeMapper::toDTO);
    }

    public EmployeeResponseDTO updateEmployee(UUID id, EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with ID: " + id));

        if (employeeRepository.existsByEmailAndIdNot(employeeRequestDTO.getEmail(), id)) {
            throw new EmailAlreadyExistsException("Employee with this email already exists: " + employeeRequestDTO.getEmail());
        }

        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setDesignation(employeeRequestDTO.getDesignation());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setPay(employeeRequestDTO.getPay());
        employee.setEmployeeType(EmployeeType.valueOf(employeeRequestDTO.getEmployeeType()));
        employee.setPhoneNumber(employeeRequestDTO.getPhoneNumber());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toDTO(updatedEmployee);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

}
