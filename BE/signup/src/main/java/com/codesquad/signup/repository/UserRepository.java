package com.codesquad.signup.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM User WHERE user_id = :userId")
    Optional<User> findByUserId(String userId);

    @Query("SELECT * FROM User WHERE email = :email")
    Optional<User> findByEmail(String email);

    @Query("SELECT * FROM User WHERE phone_number = :phoneNumber")
    Optional<User> findByPhoneNumber(String phoneNumber);
}
