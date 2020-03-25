package com.codesquad.signup.repository;

import com.codesquad.signup.exception.WrongFormatException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;

import static com.codesquad.signup.message.UserFormatMessages.*;
import static com.codesquad.signup.util.VerifyFormatUtil.*;


@Slf4j
@Getter
public class User {

  @Id
  private Long id;

  @Setter
  private String userId;
  @Setter
  private String password;
  @Setter
  private String name;
  @Setter
  private LocalDate birthday;
  @Setter
  private String sex;
  @Setter
  private String email;
  @Setter
  private String phoneNumber;
  @Setter
  private String interest;

  public boolean isCorrectPassword(String password) {
    return this.password.equals(password);
  }

  /**
   * Feat : 적절한 User 인지 확인 합니다.
   * Desc : userId, passwd, email, phoneNumber, interest 중 한개라도 format 에 맞지 않는다면 false 를 리턴합니다.
   * Desc : userId, passwd 가 format 에 맞지 않다면 false 를 리턴합니다.
   * Return : boolean
   */
  public void checkValidUser() {
    log.debug("### isValidUser()");

//    final String WRONG_FORMAT = "잘못된 형식입니다. ";
//    final String USER_ID_FORMAT = "아이디 (5~20자의 영 소문자, 숫자, 특수기호(_), (-))";
//    final String PASSWORD_FORMAT = "비밀번호 (8~16자의 영문 대, 소문자, 숫자, 특수문자의 조합)";
//    final String EMAIL_FORMAT = "이메일 (xxx@xxx.xxx)";
//    final String PHONE_NUMBER_FORMAT = "전화번호 (앞 3자리의 숫자는 010 인 10자리 또는 11자리의 숫자)";
//    final String INTEREST_FORMAT = "관심사 (3개 이상)";
//    final String NULL_EXECPTION = "null 은 허용되지 않습니다.";
//    final String BLANK_EXECPTION = "빈칸은 허용되지 않습니다.";

    if (!isCorrectUserIdFormat(userId)) {
      log.debug("### ERROR : isCorrectUserIdFormat");
      throw new WrongFormatException(WRONG_FORMAT + USER_ID_FORMAT);
    }
    if (!isCorrectPasswordFormat(password)) {
      log.debug("### ERROR : isCorrectPasswordFormat");
      throw new WrongFormatException(WRONG_FORMAT + PASSWORD_FORMAT);
    }
    if (!isCorrectEmailFormat(email)) {
      log.debug("### ERROR : isCorrectEmailFormat");
      throw new WrongFormatException(WRONG_FORMAT + EMAIL_FORMAT);
    }
    if (!isCorrectPhoneNumberFormat(phoneNumber)) {
      log.debug("### ERROR : isCorrectPhoneNumberFormat");
      throw new WrongFormatException(WRONG_FORMAT + PHONE_NUMBER_FORMAT);
    }
    if (!isCorrectInterestFormat(interest)) {
      log.debug("### ERROR : isCorrectInterestFormat");
      throw new WrongFormatException(WRONG_FORMAT + INTEREST_FORMAT);
    }

    if(ObjectUtils.isEmpty(name) ||ObjectUtils.isEmpty(birthday) ||ObjectUtils.isEmpty(sex)){
      throw new WrongFormatException(WRONG_FORMAT + EMPTY_EXECPTION);
    }
  }

  @Override
  public String toString() {
    return "User{" +
           "id=" + id +
           ", userId='" + userId + '\'' +
           ", password='" + password + '\'' +
           ", name='" + name + '\'' +
           ", birthday=" + birthday +
           ", sex='" + sex + '\'' +
           ", email='" + email + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           ", interest='" + interest + '\'' +
           '}';
  }
}
