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
