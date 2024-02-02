package com.example.BuildREST.controller;

import com.example.BuildREST.entity.Employee;
import com.example.BuildREST.service.EmployeeService;
import com.example.BuildREST.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    private EmployeeService employeeService;

    public EmployeeController() {
    }
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        try{
            LOGGER.info("Finding all employees");
            return employeeService.findAllEmployees();
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding all employees", e);
            throw e;
        }

    }

    @GetMapping("/{id}")
    public Optional<Employee> findEmployeeByID(@PathVariable("id") Integer id){
        try {
            LOGGER.info("Finding the employee");
            return employeeService.findEmployee(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding a employee", e);
            throw e;
        }

    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        try {
            LOGGER.info("Saving the employee");
            return employeeService.saveEmployee(employee);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while saving the employee", e);
            throw e;
        }

    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        try {
            LOGGER.info("Updating the employee");
            return employeeService.updateEmployee(employee);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while updating the employee", e);
            throw e;
        }

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id){
        try {
            LOGGER.info("Deleting the employee");
            employeeService.deleteEmployee(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while deleting the employee", e);
            throw e;
        }

    }


}
