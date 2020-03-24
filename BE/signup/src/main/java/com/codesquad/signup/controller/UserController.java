package com.codesquad.signup.controller;

import com.codesquad.signup.repository.ApiResponseMessage;
import com.codesquad.signup.repository.User;
import com.codesquad.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity<ApiResponseMessage> joinUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(new ApiResponseMessage("SUCCESS",newUser), HttpStatus.OK);
    }
}
