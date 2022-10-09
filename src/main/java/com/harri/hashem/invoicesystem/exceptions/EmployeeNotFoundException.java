package com.harri.hashem.invoicesystem.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long employeeId) {
        super("employee with id: " + employeeId + " does not exist");
    }
}
