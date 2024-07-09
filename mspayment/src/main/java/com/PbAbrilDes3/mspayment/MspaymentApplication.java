package com.PbAbrilDes3.mspayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MspaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspaymentApplication.class, args);
	}

}
