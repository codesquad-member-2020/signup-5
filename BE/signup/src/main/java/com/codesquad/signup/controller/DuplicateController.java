package com.codesquad.signup.controller;

import com.codesquad.signup.exception.NotFoundPath;
import com.codesquad.signup.exception.NotUniqueException;
import com.codesquad.signup.exception.WrongFormatException;
import com.codesquad.signup.repository.ApiResponseMessage;
import com.codesquad.signup.repository.User;
import com.codesquad.signup.repository.UserRepository;
import com.codesquad.signup.util.VerifyFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/duplicate")
public class DuplicateController {

    @Autowired
    private UserRepository userRepository;
    private final String WRONG_FORMAT = "잘못된 형식입니다";

    @GetMapping
    public Object isDuplicate(String userId, String email, String phoneNumber) {

        if (userId != null)
            return isUserIdDuplicate(userId);

        if (email != null)
            return isEmailDuplicate(email);

        if (phoneNumber != null)
            return isPhoneNumberDuplicate(phoneNumber);

        return new NotFoundPath("해당 경로를 찾을 수 없습니다");
    }

    private ResponseEntity<ApiResponseMessage> isUserIdDuplicate(String userId) {

        if (!VerifyFormatUtil.isCorrectUserIdFormat(userId)) {
            throw new WrongFormatException(WRONG_FORMAT);
        }

        Optional<User> user = userRepository.findByUserId(userId);

        if (user.isPresent())
            throw new NotUniqueException("이미 사용중인 아이디입니다");

        return new ResponseEntity<>(new ApiResponseMessage("SUCCESS", "사용할 수 있는 아이디입니다"), HttpStatus.OK);
    }


    private ResponseEntity<ApiResponseMessage> isEmailDuplicate(@RequestParam("email") String email) {

        if (!VerifyFormatUtil.isCorrectEmailFormat(email)) {
            throw new WrongFormatException(WRONG_FORMAT);
        }

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent())
            throw new NotUniqueException("이미 사용중인 이메일입니다");

        return new ResponseEntity<>(new ApiResponseMessage("SUCCESS", "사용할 수 있는 이메일입니다"), HttpStatus.OK);
    }

    private ResponseEntity<ApiResponseMessage> isPhoneNumberDuplicate(@RequestParam(value = "phone") String phone) {

        if (!VerifyFormatUtil.isCorrectPhoneNumberFormat(phone)) {
            throw new WrongFormatException(WRONG_FORMAT);
        }

        Optional<User> user = userRepository.findByPhoneNumber(phone);

        if (user.isPresent())
            throw new NotUniqueException("이미 사용중인 번호입니다");

        return new ResponseEntity<>(new ApiResponseMessage("SUCCESS", "사용할 수 있는 번호 입니다"), HttpStatus.OK);
    }


}
