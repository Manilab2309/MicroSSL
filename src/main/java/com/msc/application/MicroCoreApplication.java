package com.msc.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.msc.config.MicroCoreSwaggerConfiguration;


/**
 * @author Ramón Cigüenza
 *
 */

@ComponentScan("com.msc.*")

@EntityScan(basePackages = "com.msc.entity")

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@Import(MicroCoreSwaggerConfiguration.class)

public class MicroCoreApplication {

	private static final Logger logger = LoggerFactory.getLogger(MicroCoreApplication.class);
	
	public static void main(String[] args) {

		new SpringApplicationBuilder(MicroCoreApplication.class)
		.properties("spring.config.name:MicroCore-application")
		.build()
		.run(args);

		logger.debug("-- Application API MicroCore Started --");
	}

}
