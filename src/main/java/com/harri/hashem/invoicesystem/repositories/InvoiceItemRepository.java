package com.harri.hashem.invoicesystem.repositories;

import com.harri.hashem.invoicesystem.entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}