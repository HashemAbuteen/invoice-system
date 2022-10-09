package com.harri.hashem.invoicesystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WrongDateFormatAdvice {
    @ResponseBody
    @ExceptionHandler(WrongDateFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String wrongDateFormatHandler (WrongDateFormatException ex){
        return ex.getMessage();
    }
}
