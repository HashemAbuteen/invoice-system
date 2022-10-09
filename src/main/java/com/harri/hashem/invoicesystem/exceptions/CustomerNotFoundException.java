package com.harri.hashem.invoicesystem.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long customerId) {
        super("customer with id: " + customerId + " does not exist");
    }
}
