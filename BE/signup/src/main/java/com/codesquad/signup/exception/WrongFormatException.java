package com.codesquad.signup.exception;

import com.codesquad.signup.repository.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WrongFormatException extends RuntimeException {
    private String errorMessage;

    public WrongFormatException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseEntity<ApiResponseMessage> returnErrorMessage() {
        return new ResponseEntity<>(new ApiResponseMessage("ERROR", errorMessage), HttpStatus.BAD_REQUEST);
    }
}
