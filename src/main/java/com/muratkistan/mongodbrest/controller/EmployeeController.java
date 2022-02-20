package com.muratkistan.mongodbrest.controller;

import com.muratkistan.mongodbrest.model.Employee;
import com.muratkistan.mongodbrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }



    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {

        return employeeRepository.insert(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        return ResponseEntity.ok().body(employee.get());
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String employeeId,
                                                   @Valid @RequestBody Employee employeeDetails)  {
        Optional<Employee> employee = employeeRepository.findById(employeeId);



        employee.get().setLastName(employeeDetails.getLastName());
        employee.get().setFirstName(employeeDetails.getFirstName());
        employee.get().setEmailId(employeeDetails.getEmailId());
        return ResponseEntity.ok(employeeRepository.save(employee.get()));
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);


        employeeRepository.delete(employee.get());

        return "deleted : " + employeeId;
    }


}
