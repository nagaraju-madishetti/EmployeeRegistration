package com.infy.service;

import com.infy.entity.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> gellAllEmployees();
     Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmploye(Long id,Employee employee);
     void deleteEmployeeById(long id);


}
