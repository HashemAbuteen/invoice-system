package com.harri.hashem.invoicesystem.repositories;

import com.harri.hashem.invoicesystem.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}