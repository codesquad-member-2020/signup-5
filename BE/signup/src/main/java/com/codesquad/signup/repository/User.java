package com.codesquad.signup.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

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

}
