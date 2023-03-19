package com.code.wings.exambooster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CodeWingsExamBoosterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeWingsExamBoosterApplication.class, args);
	}

}
