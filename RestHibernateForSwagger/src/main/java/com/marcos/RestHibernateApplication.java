package com.marcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("com.marcos")
@SpringBootApplication
public class RestHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestHibernateApplication.class, args);
	}

}
