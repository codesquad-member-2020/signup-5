package com.codesquad.signup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignupApplication.class, args);
		log.info("### info SignupApplication Start");
		log.debug("### debug SignupApplication Start");
		log.trace("### trace SignupApplication Start");
	}
}
