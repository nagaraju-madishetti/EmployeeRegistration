package com.infy.service;

import com.infy.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
     List<Employee> gellAllEmployees();
     void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmploye(Long id,Employee employee);
     void deleteEmployeeById(long id);


}
