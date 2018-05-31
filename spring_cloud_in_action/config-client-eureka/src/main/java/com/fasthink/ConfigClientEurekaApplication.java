package com.fasthink;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientEurekaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigClientEurekaApplication.class).web(true).run(args);
	}

}
