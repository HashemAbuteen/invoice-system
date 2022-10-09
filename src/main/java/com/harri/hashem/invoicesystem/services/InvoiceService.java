package com.harri.hashem.invoicesystem.services;

import com.harri.hashem.invoicesystem.dtos.InvoiceDto;
import com.harri.hashem.invoicesystem.dtos.InvoiceItemDto;
import com.harri.hashem.invoicesystem.dtos.ReportDto;
import com.harri.hashem.invoicesystem.entities.Invoice;
import com.harri.hashem.invoicesystem.entities.InvoiceItem;
import com.harri.hashem.invoicesystem.exceptions.CustomerNotFoundException;
import com.harri.hashem.invoicesystem.exceptions.EmployeeNotFoundException;
import com.harri.hashem.invoicesystem.exceptions.ItemNotFoundException;
import com.harri.hashem.invoicesystem.exceptions.WrongDateFormatException;
import com.harri.hashem.invoicesystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    InvoiceItemRepository invoiceItemRepository;
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        long customerId = invoiceDto.getCustomerId();
        long employeeId = invoiceDto.getEmployeeId();
        if(!customerRepository.existsById(customerId)){
            throw new CustomerNotFoundException(customerId);
        }
        if(!employeeRepository.existsById(employeeId)){
            throw new EmployeeNotFoundException(employeeId);
        }
        Invoice invoice = new Invoice();
        invoice.setEmployee(employeeRepository.getReferenceById(employeeId));
        invoice.setCustomer(customerRepository.getReferenceById(customerId));
        invoice.setCreatedAt(invoiceDto.getCreatedAt());
        invoice.setIsPaid(invoiceDto.getIsPaid());
        Set<InvoiceItem> invoiceItems = new HashSet<>();
        //save invoice before invoice_item because invoice_item has  not null constraint on field invoice
        invoice = invoiceRepository.save(invoice);
        for(InvoiceItemDto invoiceItemDto : invoiceDto.getInvoiceItems()){
            long itemId = invoiceItemDto.getItemId();
            if(!itemRepository.existsById(itemId)){
                //delete the invoiced saved and throw an exception due to failed in completing the invoice
                invoiceRepository.delete(invoice);
                throw new ItemNotFoundException(itemId);
            }
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setItem(itemRepository.getReferenceById(itemId));
            invoiceItem.setQuantity(invoiceItemDto.getQuantity());
            invoiceItem.setInvoice(invoice);
            invoiceItems.add(invoiceItem);
            invoiceItemRepository.save(invoiceItem);
        }
        invoice.setInvoiceItems(invoiceItems);

        invoice = invoiceRepository.save(invoice);

        return new InvoiceDto(invoice);
    }


    public List<ReportDto> getReport(Long employeeId, String startDate, String endDate) {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date start;
        Date end;
        try {
            start = formatter.parse(startDate);
            end = formatter.parse(endDate);
        } catch (ParseException e) {
            throw new WrongDateFormatException(e);
        }
        if(!employeeRepository.existsById(employeeId)){
            throw new EmployeeNotFoundException(employeeId);
        }
        return invoiceRepository.report(employeeId,start,end);
    }
}
