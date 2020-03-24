package com.codesquad.signup.repository;

import lombok.Getter;

@Getter
public class ApiResponseMessage {
    private String status;
    private String message;

    public ApiResponseMessage(){}
    public ApiResponseMessage(String status, String message){
        this.status = status;
        this.message = message;
    }
}
