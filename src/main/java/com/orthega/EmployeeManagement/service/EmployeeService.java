package com.orthega.EmployeeManagement.service;

import com.orthega.EmployeeManagement.Exceptions.EmployeeNotFoundException;
import com.orthega.EmployeeManagement.model.Employee;
import com.orthega.EmployeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
    public Employee findEmployeeByID(Long id){
       return employeeRepo.findEmployeeByID(id).
               orElseThrow(()-> new EmployeeNotFoundException("Employee by id "+id+" was not found"));
    }
}
