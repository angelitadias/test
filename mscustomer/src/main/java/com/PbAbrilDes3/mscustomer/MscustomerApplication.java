package com.PbAbrilDes3.mscustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MscustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscustomerApplication.class, args);
	}

}
