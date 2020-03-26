package com.codesquad.signup.util;

import com.codesquad.signup.exception.UnauthorizedException;
import com.codesquad.signup.message.ErrorMessages;
import com.codesquad.signup.repository.User;

import javax.servlet.http.HttpSession;

public class HttpSessionUtil {
    public static final String USER_SESSION_KEY = "authorizedUser";

    public static boolean isAuthorizedUser(HttpSession session) {
        Object user = session.getAttribute(USER_SESSION_KEY);
        return user != null;
    }

    public static User getUserFromSession(HttpSession session) {
        if (!isAuthorizedUser(session)) {
            throw new UnauthorizedException(ErrorMessages.UNAUTHORIZED);
        }
        return (User)session.getAttribute(USER_SESSION_KEY);
    }
}
