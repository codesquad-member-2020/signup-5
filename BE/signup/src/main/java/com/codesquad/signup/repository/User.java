package com.codesquad.signup.repository;

import com.codesquad.signup.exception.WrongFormatException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

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
   * Desc : userId, passwd, name 중 한개라도 nunll 또는 공백이라면 false 를 리턴합니다.
   * Desc : userId, passwd 가 format 에 맞지 않다면 false 를 리턴합니다.
   * Return : boolean
   */
  public boolean isValidUser() {
    log.debug("### isValidUser()");

    final String WRONG_FORMAT = "잘못된 형식입니다.";
    final String USER_ID_FORMAT = " 아이디 (5~20자의 영 소문자, 숫자, 특수기호(_), (-))";
    final String PASSWORD_FORMAT = " 비밀번호 (8~16자의 영문 대, 소문자, 숫자, 특수문자의 조합)";
    final String EMAIL_FORMAT = " 이메일 (xxx@xxx.xxx)";
    final String PHONE_NUMBER_FORMAT = " 전화번호 (앞 3자리의 숫자는 010 인 10자리 또는 11자리의 숫자)";

    if (!isCorrectUserIdFormat(this.userId)) {
      log.debug("### isCorrectUserIdFormat");
      throw new WrongFormatException(WRONG_FORMAT + USER_ID_FORMAT);
    }
    if (!isCorrectPasswordFormat(this.password)) {
      log.debug("### isCorrectPasswordFormat");
      throw new WrongFormatException(WRONG_FORMAT + PASSWORD_FORMAT);
    }
    if (!isCorrectEmailFormat(this.email)) {
      log.debug("### isCorrectEmailFormat");
      throw new WrongFormatException(WRONG_FORMAT + EMAIL_FORMAT);
    }
    if (!isCorrectPhoneNumberFormat(this.phoneNumber)) {
      log.debug("### isCorrectEmailFormat");
      throw new WrongFormatException(WRONG_FORMAT + PHONE_NUMBER_FORMAT);
    }

    return true;
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
