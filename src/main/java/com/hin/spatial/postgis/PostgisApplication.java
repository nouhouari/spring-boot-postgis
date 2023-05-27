package com.hin.spatial.postgis;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostgisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgisApplication.class, args);
	}

	@Bean
	public JtsModule jtsModule(){
		return new JtsModule();
	}
}
