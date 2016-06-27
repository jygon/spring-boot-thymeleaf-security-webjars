package com.apress.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@Configuration
@EnableGlobalAuthentication
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity https) throws Exception {
    https.authorizeRequests().antMatchers("/").permitAll()
      .antMatchers("/user/**").authenticated().and().httpBasic();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER").
      and().withUser("sa").password("sa").roles("USER","ADMIN");
  }

}
