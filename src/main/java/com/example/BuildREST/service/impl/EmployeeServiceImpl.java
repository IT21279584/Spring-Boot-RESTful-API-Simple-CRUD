package com.example.BuildREST.service.impl;

import com.example.BuildREST.entity.Employee;
import com.example.BuildREST.repository.EmployeeRepository;
import com.example.BuildREST.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getName());
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployees() {

        try{
            LOGGER.info("Finding all employees");
            return employeeRepository.findAll();
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding all employees", e);
            throw e;
        }
    }

    @Override
    public Optional<Employee> findEmployee(Integer id) {

        try {
            LOGGER.info("Finding the employee");
            return employeeRepository.findById(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding a employee", e);
            throw e;
        }
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        try {
            LOGGER.info("Saving the employee");
            return employeeRepository.save(employee);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while saving the employee", e);
            throw e;
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try {
            LOGGER.info("Updating the employee");
            return employeeRepository.save(employee);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while updating the employee", e);
            throw e;
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        try {
            LOGGER.info("Deleting the employee");
            employeeRepository.deleteById(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while deleting the employee", e);
            throw e;
        }
    }
}
