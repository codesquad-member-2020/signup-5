package com.codesquad.signup.exception;

import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.repository.ApiResponse;

public class BaseException extends RuntimeException {
    private String errorMessage;

    public BaseException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ApiResponse returnErrorMessage() {
        return new ApiResponse(ErrorMessages.ERROR, errorMessage);
    }
}
