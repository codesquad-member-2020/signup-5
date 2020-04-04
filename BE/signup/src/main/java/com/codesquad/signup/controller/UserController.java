package com.codesquad.signup.controller;

import com.codesquad.signup.exception.ForbiddenException;
import com.codesquad.signup.exception.UserJoinFailedException;
import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.message.SuccessMessages;
import com.codesquad.signup.repository.ApiResponse;
import com.codesquad.signup.repository.User;
import com.codesquad.signup.repository.UserRepository;
import com.codesquad.signup.util.HttpSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

  @GetMapping("/user/{id}")
  public ResponseEntity<ApiResponse> show(@PathVariable Long id, HttpSession session) {
    log.debug("### show : {}", HttpSessionUtil.getUserFromSession(session));

    User sessionedUser = HttpSessionUtil.getUserFromSession(session);

    if (!sessionedUser.getId().equals(id)) {
      throw new ForbiddenException(ErrorMessages.FORBIDDEN);
    }

    return new ResponseEntity<>(new ApiResponse(SuccessMessages.SUCCESS, sessionedUser), HttpStatus.OK);
  }
}
