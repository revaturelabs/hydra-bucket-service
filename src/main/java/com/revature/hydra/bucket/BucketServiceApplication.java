package com.revature.hydra.bucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * Bucket service main class
 */
@SpringBootApplication
@ComponentScan
@EntityScan("com.revature.beans")
@EnableEurekaClient
public class BucketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BucketServiceApplication.class, args);
	}
}
