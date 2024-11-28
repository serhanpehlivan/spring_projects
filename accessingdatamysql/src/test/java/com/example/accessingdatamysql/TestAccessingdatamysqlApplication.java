package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;

public class TestAccessingdatamysqlApplication {

	public static void main(String[] args) {
		SpringApplication.from(AccessingDataMysqlApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
