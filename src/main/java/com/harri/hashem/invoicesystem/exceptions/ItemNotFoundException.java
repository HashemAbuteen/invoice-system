package com.harri.hashem.invoicesystem.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long itemId) {
        super("item with id: " + itemId + " does not exist");
    }
}
