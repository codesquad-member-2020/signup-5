package com.codesquad.signup.repository;

import lombok.Getter;

@Getter
public class ApiResponseMessage {
    private String status;
    private Object message;

    public ApiResponseMessage(){}
    public ApiResponseMessage(String status, String message){
        this.status = status;
        this.message = message;
    }

    public ApiResponseMessage(String status, User user){
        this.status = status;
        this.message = user;
    }
}
