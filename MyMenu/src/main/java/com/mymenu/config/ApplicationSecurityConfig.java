package com.mymenu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * @author mahalakshmi
 *
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Added this configuration for basic authentication.
	 */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {   	

        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/recipe/**").authenticated()
                .and().httpBasic();
        httpSecurity.headers().frameOptions().disable();
        
    }	
}