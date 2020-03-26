package com.codesquad.signup.repository;

import com.codesquad.signup.exception.WrongFormatException;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DisplayName("UserTest")
class UserTest {

  User user;

  @BeforeEach
  void setUser() {
    user = new User();
    user.setUserId("diane");
    user.setPassword("1234Qwer**");
    user.setName("다이앤");
    user.setBirthday(LocalDate.of(2000, 7, 13));
    user.setSex("female");
    user.setEmail("abcd@gmail.com");
    user.setPhoneNumber("01022225555");
    user.setInterest("야구, 농구, 축구");
  }

  @AfterEach
  void afterEach() {
    assertThrows(WrongFormatException.class, () -> {
      user.checkValidUser();
    });
  }

  @Nested
  @DisplayName("checkValidUser() 는 user 의 parameter 중 ")
  class Describe_checkValidUser {

    final String USER_ID_WRONG = "dianeA";
    final String PASSWORD_WRONG = "123Qwer";
    final String EMAIL_WRONG = "abcdgmail.com";
    final String PHONE_NUMBER_WRONG = "01022223333555";
    final String INTEREST_WRONG = "야구, 농구";

    final String STRING_NULL = null;
    final String STRING_BLANK = "";

    @Test
    @DisplayName(" userId 가 맞지 않으면 (dianeA) WrongFormatException 을 throw 합니다.")
    void userIdIsWrong() {
      user.setUserId(USER_ID_WRONG);
    }

    @Test
    @DisplayName(" password 가 맞지 않으면 (123Qwer) WrongFormatException 을 throw 합니다.")
    void passwordIsWrong() {
      user.setPassword(PASSWORD_WRONG);
    }

    @Test
    @DisplayName(" email 이 맞지 않으면 (abcdgmail.com) WrongFormatException 을 throw 합니다.")
    void emailIsWrong() {
      user.setEmail(EMAIL_WRONG);
    }

    @Test
    @DisplayName(" phoneNumber 가 맞지 않으면 (01022223333555) WrongFormatException 을 throw 합니다.")
    void phoneNumberIsWrong() {
      user.setPhoneNumber(PHONE_NUMBER_WRONG);
    }

    @Test
    @DisplayName(" interest 가 맞지 않으면 (야구, 농구) WrongFormatException 을 throw 합니다.")
    void interestIsWrong() {
      user.setInterest(INTEREST_WRONG);
    }

    @Test
    @DisplayName(" name 이 null 이면 WrongFormatException 을 throw 합니다.")
    void nameIsNULL() {
      user.setName(STRING_NULL);
    }

    @Test
    @DisplayName(" name 이 빈칸이면 WrongFormatException 을 throw 합니다.")
    void nameIsBlank() {
      user.setName(STRING_BLANK);
    }
  }
}
