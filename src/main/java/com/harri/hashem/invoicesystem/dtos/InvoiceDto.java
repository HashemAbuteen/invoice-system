package com.harri.hashem.invoicesystem.dtos;

import com.harri.hashem.invoicesystem.entities.Invoice;
import com.harri.hashem.invoicesystem.entities.InvoiceItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link com.harri.hashem.invoicesystem.entities.Invoice} entity
 */
@Data
@NoArgsConstructor
public class InvoiceDto implements Serializable {
    private Long id;
    private Long customerId;
    private String customerEmail;
    private Long employeeId;
    private String employeeName;
    private Date createdAt;
    private Boolean isPaid;
    private Set<InvoiceItemDto> invoiceItems;



    public InvoiceDto(Invoice invoice) {
        id = invoice.getId();
        customerId = invoice.getCustomer().getId();
        customerEmail = invoice.getCustomer().getEmail();
        employeeId = invoice.getEmployee().getId();
        employeeName = invoice.getEmployee().getFirstName()+ " " + invoice.getEmployee().getLastName();
        createdAt = invoice.getCreatedAt();
        isPaid = invoice.getIsPaid();
        invoiceItems = new HashSet<>();
        for(InvoiceItem invoiceItem : invoice.getInvoiceItems()){
            InvoiceItemDto invoiceItemDto = new InvoiceItemDto(invoiceItem.getId(), invoiceItem.getQuantity(),
                    invoice.getId(),invoiceItem.getItem().getId());
            invoiceItems.add(invoiceItemDto);
        }
    }
}