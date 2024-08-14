package com.alrosa.staa.gatekeeper_server_single;

import com.alrosa.staa.gatekeeper_server_single.RabbitMQ.RabbitConfiguration;
import com.alrosa.staa.gatekeeper_server_single.service.PhotoService;
import com.alrosa.staa.gatekeeper_server_single.service.PhotoServiceImpl;
import com.alrosa.staa.gatekeeper_server_single.service.UserService;
import com.alrosa.staa.gatekeeper_server_single.service.UserServiceImpl;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
@Import(RabbitConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class GatekeeperServerSingleApplication {
	@Bean
	public PhotoService photoService() {
		return new PhotoServiceImpl();
	}
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(GatekeeperServerSingleApplication.class, args);
	}
}
