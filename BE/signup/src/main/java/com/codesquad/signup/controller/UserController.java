package com.codesquad.signup.controller;

import com.codesquad.signup.repository.User;
import com.codesquad.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    public User joinUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
