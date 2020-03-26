package com.codesquad.signup.exception;

import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.repository.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class UserJoinFailedException extends RuntimeException {

  private String errorMessage;

  public UserJoinFailedException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ResponseEntity<ApiResponse> returnErrorMessage() {
    return new ResponseEntity<>(new ApiResponse(ErrorMessages.ERROR, errorMessage), HttpStatus.CONFLICT);
  }
}
