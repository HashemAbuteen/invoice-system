package com.harri.hashem.invoicesystem.repositories;

import com.harri.hashem.invoicesystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}