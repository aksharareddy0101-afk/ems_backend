package com.anurag.emsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.emsb.entity.Employee;
import com.anurag.emsb.service.EmployeeService;

@RestController
public class EmployeeController {
      @Autowired // dependency injection
      private EmployeeService service;

      // bean is injected into service variable
      // create
      @PostMapping("/add") // end point
      public Employee createEmployee(@RequestBody Employee emp) {
            return service.createEmployee(emp);
      }

      // read
      @GetMapping("/get") // end point
      public List<Employee> getAllEmployees() {
            return service.getAllEmployees();
      }

      @PutMapping("/update/{id}") // http://localhost:8080/update/2
      public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee newEmp) {
            return service.updateEmployee(id, newEmp);
      }

      @DeleteMapping("/delete/{id}")
      public String deleteEmployee(@PathVariable Integer id) {
            return service.deleteEmployee(id);
      }
}
