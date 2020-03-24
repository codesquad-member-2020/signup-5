package com.codesquad.signup.exception;

import com.codesquad.signup.repository.ApiResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponseMessage> handleError(UnauthorizedException unAuthorized) {
        return unAuthorized.returnErrorMessage();
    }

    @ExceptionHandler(NotUniqueException.class)
    public ResponseEntity<ApiResponseMessage> handleError(NotUniqueException notUnique) {
        return notUnique.returnErrorMessage();
    }

    @ExceptionHandler(WrongFormatException.class)
    public ResponseEntity<ApiResponseMessage> handleError(WrongFormatException wrongFormat) {
        return wrongFormat.returnErrorMessage();
    }

    @ExceptionHandler(NotFoundPath.class)
    public ResponseEntity<ApiResponseMessage> handleError(NotFoundPath notFoundPath) {
        return notFoundPath.returnErrorMessage();
    }

    @ExceptionHandler(UserJoinFailedException.class)
    public ResponseEntity<ApiResponseMessage> handleError(UserJoinFailedException userJoinFailed) {
        return userJoinFailed.returnErrorMessage();
    }
}
