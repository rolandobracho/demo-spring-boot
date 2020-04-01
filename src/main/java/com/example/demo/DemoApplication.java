package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.repo.CourseRepo;
import com.example.demo.security.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackageClasses = {Course.class})
@EnableJpaRepositories(basePackageClasses = CourseRepo.class)
@ComponentScan(basePackageClasses = {DemoApplication.class, WebSecurityConfig.class})
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

