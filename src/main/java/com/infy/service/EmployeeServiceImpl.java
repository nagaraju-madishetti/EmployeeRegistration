package com.infy.service;

import com.infy.entity.Employee;
import com.infy.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> gellAllEmployees() {

        return employeeRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
       return  employeeRepo.save(employee);

    }

    @Override
    public Employee getEmployeeById(Long id)
    {
        return employeeRepo.findById(id).get();
    }

    @Override
    public Employee updateEmploye(Long id,Employee employee) {
        Employee existingEmployee=employeeRepo.findById(id).get();
        existingEmployee.setId(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setMobile(employee.getMobile());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setLocation(employee.getLocation());
        return employeeRepo.save(existingEmployee);

    }


    @Override
    public void deleteEmployeeById(long id) {

        this.employeeRepo.deleteById(id);
    }



}
