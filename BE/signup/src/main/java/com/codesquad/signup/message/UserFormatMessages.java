package com.codesquad.signup.message;

public class UserFormatMessages {
  public final static String WRONG_FORMAT = "잘못된 형식입니다. ";
  public final static String USER_ID_FORMAT = "아이디 (5~20자의 영 소문자, 숫자, 특수기호(_), (-))";
  public final static String PASSWORD_FORMAT = "비밀번호 (8~16자의 영문 대, 소문자, 숫자, 특수문자의 조합)";
  public final static String EMAIL_FORMAT = "이메일 (xxx@xxx.xxx)";
  public final static String PHONE_NUMBER_FORMAT = "전화번호 (앞 3자리의 숫자는 010 인 10자리 또는 11자리의 숫자)";
  public final static String INTEREST_FORMAT = "관심사 (3개 이상)";
  public final static String EMPTY_EXECPTION = "빈칸은 허용되지 않습니다.";
}
