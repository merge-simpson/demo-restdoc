package com.example.demo.v1.exception;

import com.example.demo.v1.exception.status2xx.NoContentException;
import com.example.demo.v1.support.exception.ApiError;
import com.example.demo.v1.support.exception.CustomException;
import com.example.demo.v1.support.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public final class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiError> handleMemberException(CustomException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        HttpStatus httpStatus = errorCode.defaultHttpStatus();
        ApiError apiError = ApiError.of(errorCode);

        return new ResponseEntity<>(apiError, httpStatus);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<?> handleNoContentException(NoContentException exception) {
        return ResponseEntity.noContent().build();
    }
}
