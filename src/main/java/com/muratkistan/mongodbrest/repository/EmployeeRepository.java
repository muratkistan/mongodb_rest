package com.muratkistan.mongodbrest.repository;

import com.muratkistan.mongodbrest.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
