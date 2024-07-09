package com.PbAbrilDes3.mscalculate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MscalculateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscalculateApplication.class, args);
	}

}
