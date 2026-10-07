package com.anurag.emsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.emsb.entity.Employee;
import com.anurag.emsb.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired 
    private EmployeeRepository repo;

    public Employee createEmployee(Employee emp){
        return repo.save(emp);
    }
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }
    public Employee updateEmployee(Integer id,Employee newEmp){
        Employee existingEmp=repo.findById(id).orElse(null);
        if(existingEmp !=null){
            existingEmp.setName(newEmp.getName());
            existingEmp.setRole(newEmp.getRole());
            existingEmp.setEmail(newEmp.getEmail());
            existingEmp.setPassword(newEmp.getPassword());
            return repo.save(existingEmp);
        }
        return null;
    }
    public String deleteEmployee(Integer id){
        if(repo.existsById(id)){
            repo.deleteById(id);
        return "Employee deleted successfully";
        }
    return "Employee not found...!";
    }
}
