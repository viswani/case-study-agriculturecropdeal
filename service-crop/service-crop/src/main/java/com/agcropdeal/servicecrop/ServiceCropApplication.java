package com.agcropdeal.servicecrop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceCropApplication {
   
	public static void main(String[] args) {
		SpringApplication.run(ServiceCropApplication.class, args);
	}

}
