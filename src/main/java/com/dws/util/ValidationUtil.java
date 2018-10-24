package com.dws.util;

import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationUtil {

    public static List<String> fromBindingErrors(Errors errors) {
        return errors.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
    }
}
