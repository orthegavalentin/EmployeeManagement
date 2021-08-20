package com.orthega.EmployeeManagement.repo;

import com.orthega.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {


    void deleteEmployeeById(Long id);


   Optional<Employee>  findEmployeeByID(Long id);
}
