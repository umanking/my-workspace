package com.example.springrestapi.exception;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<ErrorResponse.FieldError> fieldErrorList = fieldErrors.stream()
            .map(error -> ErrorResponse.FieldError.builder()
                .field(error.getField())
                .value(error.getRejectedValue() != null ? error.getRejectedValue().toString() : "null")
                .reason(error.getDefaultMessage())
                .build())
            .collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.BAD_REQUEST, fieldErrorList), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(Throwable e) {
        log.error("CustomException:" + e.getMessage());
        return ResponseEntity.ok(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));

    }
}
