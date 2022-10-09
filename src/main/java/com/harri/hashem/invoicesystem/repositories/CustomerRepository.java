package com.harri.hashem.invoicesystem.repositories;

import com.harri.hashem.invoicesystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}