package com.codesquad.signup.controller;

import com.codesquad.signup.exception.UnauthorizedException;
import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.message.SuccessMessages;
import com.codesquad.signup.repository.ApiResponse;
import com.codesquad.signup.repository.User;
import com.codesquad.signup.repository.UserRepository;
import com.codesquad.signup.util.HttpSessionUtil;
import com.codesquad.signup.util.VerifyFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class AuthController {
    static final String USER_ID = "userId";
    static final String PASSWORD = "password";

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody Map<String, String> loginInfo, HttpSession session) {

        String userId = loginInfo.get(USER_ID);
        String password = loginInfo.get(PASSWORD);

        if (!VerifyFormatUtil.isCorrectUserIdFormat(userId)){
            throw new UnauthorizedException(ErrorMessages.FAIL_LOGIN);
        }

        if (!VerifyFormatUtil.isCorrectPasswordFormat(password)) {
            throw new UnauthorizedException(ErrorMessages.FAIL_LOGIN);
        }

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UnauthorizedException(ErrorMessages.FAIL_LOGIN));

        if (!user.isCorrectPassword(password)) {
            throw new UnauthorizedException(ErrorMessages.FAIL_LOGIN);
        }

        session.setAttribute(HttpSessionUtil.USER_SESSION_KEY, user);

        return new ResponseEntity<>(new ApiResponse(SuccessMessages.SUCCESS, SuccessMessages.SUCCESS_LOGIN), HttpStatus.OK);
    }
}
