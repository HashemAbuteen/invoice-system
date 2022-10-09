package com.harri.hashem.invoicesystem.repositories;

import com.harri.hashem.invoicesystem.dtos.ReportDto;
import com.harri.hashem.invoicesystem.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {



    @Query("select new com.harri.hashem.invoicesystem.dtos.ReportDto(i.createdAt,count (distinct i),count(it)) from Invoice i left join InvoiceItem it on i.id=it.invoice.id where i.employee.id = ?1 and i.createdAt between ?2 and ?3 group by i.createdAt")
    List<ReportDto> report (Long id, Date createdAtStart, Date createdAtEnd);

}