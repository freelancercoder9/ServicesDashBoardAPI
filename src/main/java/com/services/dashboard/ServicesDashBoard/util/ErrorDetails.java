package com.services.dashboard.ServicesDashBoard.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails extends RuntimeException {
    private final String errorCode;
    private final String message;

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
