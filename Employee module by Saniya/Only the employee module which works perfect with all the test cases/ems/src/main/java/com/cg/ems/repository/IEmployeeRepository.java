package com.cg.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.entities.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {


}