package com.csim.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.csim.business.binders.StreamBinder;

@SpringBootApplication
@EnableBinding(StreamBinder.class)
public class BusinessBuildingManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessBuildingManagerApplication.class, args);
	}

}
