package com.codesquad.signup.repository;

import lombok.Getter;

@Getter
public class ApiResponse {
    private String status;
    private Object message;

    public ApiResponse(){}
    public ApiResponse(String status, String message){
        this.status = status;
        this.message = message;
    }

    public ApiResponse(String status, User user){
        this.status = status;
        this.message = user;
    }
}
