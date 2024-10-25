package com.ijse.cmjd.springpos;

import org.springframework.boot.SpringApplication;

public class TestSpringposApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringposApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
