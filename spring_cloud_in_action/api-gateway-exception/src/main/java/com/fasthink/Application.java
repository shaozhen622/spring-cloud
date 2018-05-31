package com.fasthink;

import com.fasthink.filter.DidiErrorAttributes;
import com.fasthink.filter.DidiFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class Application {

	public static void main(String[] args) {
		FilterProcessor.setProcessor(new DidiFilterProcessor());
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Bean
	public DefaultErrorAttributes errorAttributes() {
		return new DidiErrorAttributes();
	}

}
