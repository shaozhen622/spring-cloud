package com.fasthink.redis.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RedisApplication.class).web(true).run(args);
	}

}
