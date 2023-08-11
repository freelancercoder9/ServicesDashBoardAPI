package com.services.dashboard.ServicesDashBoard.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorDetails extends RuntimeException{
    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;
}
