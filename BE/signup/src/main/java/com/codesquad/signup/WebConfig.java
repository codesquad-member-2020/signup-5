package com.codesquad.signup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    registry.addViewController("/main.html").setViewName("main");
    registry.addViewController("/joinForm").setViewName("signup");
    registry.addViewController("/loginForm").setViewName("login");
  }
}
