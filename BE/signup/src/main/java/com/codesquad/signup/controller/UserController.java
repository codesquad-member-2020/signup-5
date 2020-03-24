package com.codesquad.signup.controller;

import com.codesquad.signup.exception.UserJoinFailedException;
import com.codesquad.signup.repository.ApiResponseMessage;
import com.codesquad.signup.repository.User;
import com.codesquad.signup.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/join")
  @ResponseBody
  public ResponseEntity<ApiResponseMessage> joinUser(@RequestBody User user) {
    log.debug("### joinUser : {}", user);

    final String ERROR_MESSAGE = "회원 가입에 실패했습니다.";

    user.isValidUser();
    User joinedUser = Optional.of(userRepository.save(user))
        .orElseThrow(() -> new UserJoinFailedException(ERROR_MESSAGE));
    return new ResponseEntity<>(new ApiResponseMessage("SUCCESS", joinedUser), HttpStatus.OK);
  }
}
