package com.codesquad.signup.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyFormatUtil {

    public static boolean isCorrectUserIdFormat(String userId) {
        final String userIdFormat = "^[a-z0-9-_]{5,20}";
        return isCorrectFormat(userIdFormat, userId);
    }

    public static boolean isCorrectPasswordFormat(String password) {
        final String passwordPFormat = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,16}";
        return isCorrectFormat(passwordPFormat, password);
    }

    public static boolean isCorrectEmailFormat(String email) {
        final String emailFormat = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}";
        return isCorrectFormat(emailFormat, email);
    }

    public static boolean isCorrectPhoneNumberFormat(String phone) {
        final String phoneNumberFormat = "[0-9]{11}";
        return isCorrectFormat(phoneNumberFormat, phone);
    }

    private static boolean isCorrectFormat(String pattern, String inputValue) {
        Pattern passwordPattern = Pattern.compile(pattern);
        Matcher matcher = passwordPattern.matcher(inputValue);
        if (!matcher.find()) {
            return false;
        }

        if (!matcher.group().equals(inputValue)) {
            return false;
        }
        return true;
    }
}
