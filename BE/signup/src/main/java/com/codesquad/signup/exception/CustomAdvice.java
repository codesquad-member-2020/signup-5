package com.codesquad.signup.exception;

import com.codesquad.signup.repository.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponse> handleError(UnauthorizedException unAuthorized) {
        return unAuthorized.returnErrorMessage();
    }

    @ExceptionHandler(NotUniqueException.class)
    public ResponseEntity<ApiResponse> handleError(NotUniqueException notUnique) {
        return notUnique.returnErrorMessage();
    }

    @ExceptionHandler(WrongFormatException.class)
    public ResponseEntity<ApiResponse> handleError(WrongFormatException wrongFormat) {
        return wrongFormat.returnErrorMessage();
    }

    @ExceptionHandler(NotFoundPathException.class)
    public ResponseEntity<ApiResponse> handleError(NotFoundPathException notFoundPath) {
        return notFoundPath.returnErrorMessage();
    }

    @ExceptionHandler(UserJoinFailedException.class)
    public ResponseEntity<ApiResponse> handleError(UserJoinFailedException userJoinFailed) {
        return userJoinFailed.returnErrorMessage();
    }
}
