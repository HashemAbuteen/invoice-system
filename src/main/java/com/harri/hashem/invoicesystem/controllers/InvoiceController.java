package com.harri.hashem.invoicesystem.controllers;

import com.harri.hashem.invoicesystem.dtos.InvoiceDto;
import com.harri.hashem.invoicesystem.dtos.ReportDto;
import com.harri.hashem.invoicesystem.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create-invoice")
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto){
        return new ResponseEntity<>(invoiceService.createInvoice(invoiceDto), HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<List<ReportDto>> getInvoicesDoneByEmployeeInRangeOfDates(@RequestParam Long employeeId, @RequestParam String startDate,
                                                                                   @RequestParam String endDate){
        return new ResponseEntity<>(invoiceService.getReport(employeeId,startDate,endDate), HttpStatus.OK);

    }
}
