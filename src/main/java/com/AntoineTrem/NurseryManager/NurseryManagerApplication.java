package com.AntoineTrem.NurseryManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NurseryManagerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(NurseryManagerApplication.class, args);
	}

}
