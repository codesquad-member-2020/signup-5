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

  @Nested
  @DisplayName("isCorrectUserIdFormat() 는 ")
  class Describe_isCorrectUserIdFormat {

    @Test
    @DisplayName("patameter 가 정상 (diane) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      String userId = "diane";
      assertTrue(VerifyFormatUtil.isCorrectUserIdFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 대문자를 가지면 false 를 리턴합니다.")
    void parameterIsWrong() {
      String userId = "dianeA";
      assertFalse(VerifyFormatUtil.isCorrectUserIdFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      String userId = "";
      assertFalse(VerifyFormatUtil.isCorrectUserIdFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      String userId = null;
      assertFalse(VerifyFormatUtil.isCorrectUserIdFormat(userId));
    }
  }

  @Nested
  @DisplayName("isCorrectPasswordFormat() 는 ")
  class Describe_isCorrectPasswordFormat {

    @Test
    @DisplayName("patameter 가 정상 (1234Qwer**) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      String userId = "123Qwer**";
      assertTrue(VerifyFormatUtil.isCorrectPasswordFormat(userId));
    }

    @Test
    @DisplayName("patameter 에 특수문자가 없으면 (1234Qwer) false 를 리턴합니다.")
    void parameterIsWrong() {
      String userId = "1234Qwer";
      assertFalse(VerifyFormatUtil.isCorrectPasswordFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      String userId = "";
      assertFalse(VerifyFormatUtil.isCorrectPasswordFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      String userId = null;
      assertFalse(VerifyFormatUtil.isCorrectPasswordFormat(userId));
    }
  }

  @Nested
  @DisplayName("isCorrectEmailFormat() 는 ")
  class Describe_isCorrectEmailFormat {

    @Test
    @DisplayName("patameter 가 정상 (abcd@gmail.com) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      String userId = "abcd@gmail.com";
      assertTrue(VerifyFormatUtil.isCorrectEmailFormat(userId));
    }

    @Test
    @DisplayName("patameter 에 @ 가 없으면 (abcdgmail.com) false 를 리턴합니다.")
    void parameterIsWrong() {
      String userId = "abcdgmail.com";
      assertFalse(VerifyFormatUtil.isCorrectEmailFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      String userId = "";
      assertFalse(VerifyFormatUtil.isCorrectEmailFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      String userId = null;
      assertFalse(VerifyFormatUtil.isCorrectEmailFormat(userId));
    }
  }

  @Nested
  @DisplayName("isCorrectPhoneNumberFormat() 는 ")
  class Describe_isCorrectPhoneNumberFormat {

    @Test
    @DisplayName("patameter 가 정상 (01022223333) 이면 ture 를 리턴합니다.")
    void parameterIsNormal() {
      String userId = "01022223333";
      assertTrue(VerifyFormatUtil.isCorrectPhoneNumberFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 11자리를 넘으면 (01022223333555) false 를 리턴합니다.")
    void parameterIsWrong() {
      String userId = "01022223333555";
      assertFalse(VerifyFormatUtil.isCorrectPhoneNumberFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 공백이면 false 를 리턴합니다.")
    void parameterIsBlank() {
      String userId = "";
      assertFalse(VerifyFormatUtil.isCorrectPhoneNumberFormat(userId));
    }

    @Test
    @DisplayName("patameter 가 Null 이면 false 를 리턴합니다.")
    void parameterIsNull() {
      String userId = null;
      assertFalse(VerifyFormatUtil.isCorrectPhoneNumberFormat(userId));
    }
  }
}
