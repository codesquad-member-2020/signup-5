package com.codesquad.signup.exception;

import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.repository.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ForbiddenException extends RuntimeException {
  private String errorMessage;

  public ForbiddenException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ResponseEntity<ApiResponse> returnErrorMessage() {
    return new ResponseEntity<>(new ApiResponse(ErrorMessages.ERROR, errorMessage), HttpStatus.FORBIDDEN);
  }
}
