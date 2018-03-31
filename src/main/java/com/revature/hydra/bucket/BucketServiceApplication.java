package com.revature.hydra.bucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Bucket service main class
 */
@EnableSwagger2
@SpringBootApplication
@ComponentScan
@EntityScan("com.revature.beans")
@EnableEurekaClient
public class BucketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BucketServiceApplication.class, args);
	}
}
