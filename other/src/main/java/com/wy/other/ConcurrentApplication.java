package com.wy.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcurrentApplication {

	public static void main(String[] args) {

//		SpringApplication.run(ConcurrentApplication.class, args);
		Float a =new Float(0.0/0.0);
		boolean naN = Float.isNaN(a);
		System.out.println(naN);
	}



}
