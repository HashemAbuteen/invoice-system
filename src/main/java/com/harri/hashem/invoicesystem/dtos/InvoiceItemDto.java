package com.harri.hashem.invoicesystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.harri.hashem.invoicesystem.entities.InvoiceItem} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemDto implements Serializable {
    private Long id;
    private Integer quantity;
    private Long invoiceId;
    private Long itemId;
}