package com.mindtree.areamanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AreaManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AreaManagementApplication.class, args);
		int a=87;
		int b=87;
		int s=a+b;
		System.out.println(s);
	}

}
