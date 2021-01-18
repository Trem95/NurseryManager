package com.AntoineTrem.NurseryManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class NurseryManagerApplication {


	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
	}

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(NurseryManagerApplication.class, args);
	}

}
