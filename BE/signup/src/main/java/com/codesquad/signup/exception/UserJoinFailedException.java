package com.codesquad.signup.exception;

import com.codesquad.signup.repository.ApiResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class UserJoinFailedException extends RuntimeException {

  private String errorMessage;

  public UserJoinFailedException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ResponseEntity<ApiResponseMessage> returnErrorMessage() {
    return new ResponseEntity<>(new ApiResponseMessage("ERROR", errorMessage), HttpStatus.CONFLICT);
  }
}
