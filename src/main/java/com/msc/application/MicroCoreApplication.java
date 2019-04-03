package com.msc.application;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Bean;
import java.security.NoSuchAlgorithmException;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.msc.config.MicroCoreSwaggerConfiguration;

import java.security.NoSuchAlgorithmException;


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

    @Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
		DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
		System.setProperty("javax.net.ssl.keyStore", "src/main/resources/client.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "micro2019");
		System.setProperty("javax.net.ssl.trustStore", "src/main/resources/client.p12");
		System.setProperty("javax.net.ssl.trustStorePassword", "micro2019");
		EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName("client");
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());
		return args;
	}
}
