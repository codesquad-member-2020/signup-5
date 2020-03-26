package com.codesquad.signup.controller;

import com.codesquad.signup.exception.NotFoundPathException;
import com.codesquad.signup.exception.NotUniqueException;
import com.codesquad.signup.exception.WrongFormatException;
import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.message.SuccessMessages;
import com.codesquad.signup.repository.ApiResponse;
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

    @GetMapping
    public Object isDuplicate(String userId, String email, String phone) {

        if (userId != null)
            return isUserIdDuplicate(userId);

        if (email != null)
            return isEmailDuplicate(email);

        if (phone != null)
            return isPhoneNumberDuplicate(phone);

        return new NotFoundPathException(ErrorMessages.NOTFOUND_PATH);
    }

    private ResponseEntity<ApiResponse> isUserIdDuplicate(String userId) {

        if (!VerifyFormatUtil.isCorrectUserIdFormat(userId)) {
            throw new WrongFormatException(ErrorMessages.WRONG_FORMAT);
        }

        Optional<User> user = userRepository.findByUserId(userId);

        if (user.isPresent())
            throw new NotUniqueException(ErrorMessages.DUPLICATED_USER_ID);

        return new ResponseEntity<>(new ApiResponse(SuccessMessages.SUCCESS, SuccessMessages.VALID_USER_ID), HttpStatus.OK);
    }


    private ResponseEntity<ApiResponse> isEmailDuplicate(@RequestParam("email") String email) {

        if (!VerifyFormatUtil.isCorrectEmailFormat(email)) {
            throw new WrongFormatException(ErrorMessages.WRONG_FORMAT);
        }

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent())
            throw new NotUniqueException(ErrorMessages.DUPLICATED_EMAIL);

        return new ResponseEntity<>(new ApiResponse(SuccessMessages.SUCCESS, SuccessMessages.VALID_EMAIL), HttpStatus.OK);
    }

    private ResponseEntity<ApiResponse> isPhoneNumberDuplicate(@RequestParam(value = "phone") String phone) {

        if (!VerifyFormatUtil.isCorrectPhoneNumberFormat(phone)) {
            throw new WrongFormatException(ErrorMessages.WRONG_FORMAT);
        }

        Optional<User> user = userRepository.findByPhoneNumber(phone);

        if (user.isPresent())
            throw new NotUniqueException(ErrorMessages.DUPLICATED_PHONE);

        return new ResponseEntity<>(new ApiResponse(SuccessMessages.SUCCESS, SuccessMessages.VALID_PHONE), HttpStatus.OK);
    }


}
