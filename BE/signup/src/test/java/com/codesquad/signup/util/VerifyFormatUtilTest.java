package com.codesquad.signup.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("VerifyFormatUtilTest")
class VerifyFormatUtilTest {

  final String STRING_NULL = null;
  final String STRING_BLANK = "";

  @Nested
  @DisplayName("isCorrectUserIdFormat() 는 ")
  class Describe_isCorrectUserIdFormat {

    final String USER_ID_NORMAL = "diane";
    final String USER_ID_WRONG = "dianeA";

    @Test
    @DisplayName("patameter 가 정상 (diane) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      assertTrue(VerifyFormatUtil.isCorrectUserIdFormat(USER_ID_NORMAL));
    }

    @Test
    @DisplayName("patameter 가 대문자를 가지면 false 를 리턴합니다.")
    void parameterIsWrong() {
      assertFalse(VerifyFormatUtil.isCorrectUserIdFormat(USER_ID_WRONG));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      assertFalse(VerifyFormatUtil.isCorrectUserIdFormat(STRING_BLANK));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      assertFalse(VerifyFormatUtil.isCorrectUserIdFormat(STRING_NULL));
    }
  }

  @Nested
  @DisplayName("isCorrectPasswordFormat() 는 ")
  class Describe_isCorrectPasswordFormat {

    final String PASSWORD_NORMAL = "123Qwer**";
    final String PASSWORD_WRONG = "123Qwer";

    @Test
    @DisplayName("patameter 가 정상 (1234Qwer**) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      assertTrue(VerifyFormatUtil.isCorrectPasswordFormat(PASSWORD_NORMAL));
    }

    @Test
    @DisplayName("patameter 에 특수문자가 없으면 (1234Qwer) false 를 리턴합니다.")
    void parameterIsWrong() {
      assertFalse(VerifyFormatUtil.isCorrectPasswordFormat(PASSWORD_WRONG));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      assertFalse(VerifyFormatUtil.isCorrectPasswordFormat(STRING_BLANK));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      assertFalse(VerifyFormatUtil.isCorrectPasswordFormat(STRING_NULL));
    }
  }

  @Nested
  @DisplayName("isCorrectEmailFormat() 는 ")
  class Describe_isCorrectEmailFormat {

    final String EMAIL_NORMAL = "abcd@gmail.com";
    final String EMAIL_WRONG = "abcdgmail.com";

    @Test
    @DisplayName("patameter 가 정상 (abcd@gmail.com) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      assertTrue(VerifyFormatUtil.isCorrectEmailFormat(EMAIL_NORMAL));
    }

    @Test
    @DisplayName("patameter 에 @ 가 없으면 (abcdgmail.com) false 를 리턴합니다.")
    void parameterIsWrong() {
      assertFalse(VerifyFormatUtil.isCorrectEmailFormat(EMAIL_WRONG));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      assertFalse(VerifyFormatUtil.isCorrectEmailFormat(STRING_BLANK));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      assertFalse(VerifyFormatUtil.isCorrectEmailFormat(STRING_NULL));
    }
  }

  @Nested
  @DisplayName("isCorrectPhoneNumberFormat() 는 ")
  class Describe_isCorrectPhoneNumberFormat {

    final String PHONE_NUMBER_NORMAL = "01022223333";
    final String PHONE_NUMBER_WRONG = "01022223333555";

    @Test
    @DisplayName("patameter 가 정상 (01022223333) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      assertTrue(VerifyFormatUtil.isCorrectPhoneNumberFormat(PHONE_NUMBER_NORMAL));
    }

    @Test
    @DisplayName("patameter 가 11자리를 넘으면 (01022223333555) false 를 리턴합니다.")
    void parameterIsWrong() {
      assertFalse(VerifyFormatUtil.isCorrectPhoneNumberFormat(PHONE_NUMBER_WRONG));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      assertFalse(VerifyFormatUtil.isCorrectPhoneNumberFormat(STRING_BLANK));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      assertFalse(VerifyFormatUtil.isCorrectPhoneNumberFormat(STRING_NULL));
    }
  }

  @Nested
  @DisplayName("isCorrectInterestFormat() 는 ")
  class Describe_isCorrectInterestFormat {

    final String INTEREST_NORMAL = "축구, 농구, 배구, 야구";
    final String INTEREST_WRONG = "야구, 농구";

    @Test
    @DisplayName("patameter 가 정상 (축구, 농구, 야구, 배구) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {

      assertTrue(VerifyFormatUtil.isCorrectInterestFormat(INTEREST_NORMAL));
    }

    @Test
    @DisplayName("patameter 가 ',' 로 3개 미만으로 구분되면 (야구, 농구) false 를 리턴합니다.")
    void parameterIsWrong() {
      assertFalse(VerifyFormatUtil.isCorrectInterestFormat(INTEREST_WRONG));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      assertFalse(VerifyFormatUtil.isCorrectInterestFormat(STRING_BLANK));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      assertFalse(VerifyFormatUtil.isCorrectInterestFormat(STRING_NULL));
    }
  }
}
