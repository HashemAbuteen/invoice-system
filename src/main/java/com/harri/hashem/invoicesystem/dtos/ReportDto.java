package com.harri.hashem.invoicesystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@Data
public class ReportDto implements Serializable {
    Date date;
    Long invoiceCount;
    Long totalItems;
}
