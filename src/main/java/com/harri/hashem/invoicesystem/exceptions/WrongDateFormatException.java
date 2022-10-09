package com.harri.hashem.invoicesystem.exceptions;

import java.text.ParseException;

public class WrongDateFormatException extends RuntimeException {
    public WrongDateFormatException(ParseException e) {
    }
}
