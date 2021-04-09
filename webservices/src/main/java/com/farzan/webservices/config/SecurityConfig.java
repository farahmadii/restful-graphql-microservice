package com.farzan.webservices.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        // configuring to have all requests authenticated
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // allowing the API consumers/ users to have http basic auth
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        // creating an in-memory user which will be used for authentication
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("password"))
                // giving it a simple role as user
                .roles("USER");
    }
    // in basic auth the password is encoded in base64 format, this method helps us do that
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
