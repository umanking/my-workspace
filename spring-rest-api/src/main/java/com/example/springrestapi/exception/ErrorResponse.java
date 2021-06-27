package com.example.springrestapi.exception;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {

    private int code;
    private HttpStatus status;
    private String message;
    private List<FieldError> fieldErrors;

    public ErrorResponse(ErrorCode errorCode,
                         List<FieldError> fieldErrors) {
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.fieldErrors = fieldErrors;
    }

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    @Data
    @Builder
    public static class FieldError {
        private String field;
        private String value;
        private String reason;
    }
}
