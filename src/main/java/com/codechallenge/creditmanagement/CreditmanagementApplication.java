package com.codechallenge.creditmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CreditmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditmanagementApplication.class, args);
	}

}
