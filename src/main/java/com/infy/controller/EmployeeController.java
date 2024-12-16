package com.infy.controller;

import com.infy.entity.Employee;
import com.infy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("listEmployees", employeeService.gellAllEmployees());
        return "index";

    }

   // @PreAuthorize("hasRole('USER')")
    @GetMapping("/newRegister")
    public String registerEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "register";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/showUpdates/{id}")
    public String showUpdates(@PathVariable("id") Long id,Model model) {
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute( "employee",employee );
        return "update_employee";
    }


    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
        employeeService.updateEmploye(id,employee);
        return "redirect:/index";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/index";
    }

}



