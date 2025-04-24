package com.hooniegit.SpringInitializer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringInitializerApplication {

	public static void main(String[] args) {
		// Run Spring Application with .ini Initializer
		new SpringApplicationBuilder(SpringInitializerApplication.class)
				.initializers(new IniConfigApplicationContextInitializer())
				.run(args);
	}

}
