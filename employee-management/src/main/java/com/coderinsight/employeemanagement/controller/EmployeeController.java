package com.coderinsight.employeemanagement.controller;

import com.coderinsight.employeemanagement.dto.EmployeeRequestDTO;
import com.coderinsight.employeemanagement.dto.EmployeeResponseDTO;
import com.coderinsight.employeemanagement.service.EmployeeService;
import com.coderinsight.employeemanagement.validator.CreateEmployeeValidationGroup;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<EmployeeResponseDTO> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(allEmployees);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Validated({Default.class, CreateEmployeeValidationGroup.class}) @RequestBody EmployeeRequestDTO request) {
        EmployeeResponseDTO employee = employeeService.createEmployee(request);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getAnEmployee(@PathVariable UUID id) {
        Optional<EmployeeResponseDTO> anEmployeeWithId = employeeService.getAnEmployeeWithId(id);
        return anEmployeeWithId.map(employeeResponseDTO -> ResponseEntity.ok().body(employeeResponseDTO)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable UUID id, @Validated({Default.class}) @RequestBody EmployeeRequestDTO requestDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.updateEmployee(id, requestDTO);
        return ResponseEntity.ok().body(employeeResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }


}
