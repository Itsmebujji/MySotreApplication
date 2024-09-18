package com.vineeth.mystore.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidVendorDataException.class)
    public String getMessage(InvalidVendorDataException ex) {
        return "Error: " + ex.getMessage();
    }
}
