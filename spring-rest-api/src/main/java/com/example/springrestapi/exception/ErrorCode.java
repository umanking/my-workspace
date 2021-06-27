package com.example.springrestapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "bad request parameter");

    private int code;
    private HttpStatus status;
    private String message;

    ErrorCode(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
