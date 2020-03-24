package com.codesquad.signup.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyFormatUtil {
    public static boolean isCorrectUserIdFormat(String userId) {
        final String userIdFormat = "^[a-z]{5,20}";
        return isCorrectFormat(userIdFormat, userId);
    }

    public static boolean isCorrectPasswordFormat(String password) {
        final String passwordPFormat = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,16}";
        return isCorrectFormat(passwordPFormat, password);
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
