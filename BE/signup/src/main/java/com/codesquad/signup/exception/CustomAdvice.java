package com.codesquad.signup.exception;

import com.codesquad.signup.repository.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CustomAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ApiResponse handleError(UnauthorizedException unAuthorized) {
        return unAuthorized.returnErrorMessage();
    }

    @ExceptionHandler(NotUniqueException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiResponse handleError(NotUniqueException notUnique) {
        return notUnique.returnErrorMessage();
    }

    @ExceptionHandler(WrongFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse handleError(WrongFormatException wrongFormat) {
        return wrongFormat.returnErrorMessage();
    }

    @ExceptionHandler(NotFoundPathException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse handleError(NotFoundPathException notFoundPath) {
        return notFoundPath.returnErrorMessage();
    }

    @ExceptionHandler(UserJoinFailedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiResponse handleError(UserJoinFailedException userJoinFailed) {
        return userJoinFailed.returnErrorMessage();
    }
}
