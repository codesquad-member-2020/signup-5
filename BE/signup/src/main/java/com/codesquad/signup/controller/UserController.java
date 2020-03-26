package com.codesquad.signup.controller;

import com.codesquad.signup.exception.UserJoinFailedException;
import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.message.SuccessMessages;
import com.codesquad.signup.repository.ApiResponse;
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

@Slf4j
@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/join")
  @ResponseBody
  public ResponseEntity<ApiResponse> joinUser(@RequestBody User user) {
    log.debug("### joinUser : {}", user);

    user.checkValidUser();

    try {
      User joinedUser = userRepository.save(user);
      return new ResponseEntity<>(new ApiResponse(SuccessMessages.SUCCESS, joinedUser), HttpStatus.OK);
    } catch (Exception e) {
      throw new UserJoinFailedException(ErrorMessages.FAIL_JOIN);
    }
  }
}
