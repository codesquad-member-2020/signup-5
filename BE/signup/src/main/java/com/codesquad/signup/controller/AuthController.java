package com.codesquad.signup.controller;

import com.codesquad.signup.exception.UnauthorizedException;
import com.codesquad.signup.repository.ApiResponseMessage;
import com.codesquad.signup.repository.User;
import com.codesquad.signup.repository.UserRepository;
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
    public ResponseEntity<ApiResponseMessage> login(@RequestBody Map<String, String> loginInfo, HttpSession session) {
        final String SUCCESS_MESSAGE = "로그인 성공";
        final String ERROR_MESSAGE = "아이디 혹은 비밀번호가 틀렸습니다";

        String userId = loginInfo.get(USER_ID);
        String password = loginInfo.get(PASSWORD);

        if (!VerifyFormatUtil.isCorrectUserIdFormat(userId)){
            throw new UnauthorizedException(ERROR_MESSAGE);
        }

        if (!VerifyFormatUtil.isCorrectPasswordFormat(password)) {
            throw new UnauthorizedException(ERROR_MESSAGE);
        }

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UnauthorizedException(ERROR_MESSAGE));

        if (!user.isCorrectPassword(password)) {
            throw new UnauthorizedException(ERROR_MESSAGE);
        }

        return new ResponseEntity<>(new ApiResponseMessage("SUCCESS", SUCCESS_MESSAGE), HttpStatus.OK);
    }
}
