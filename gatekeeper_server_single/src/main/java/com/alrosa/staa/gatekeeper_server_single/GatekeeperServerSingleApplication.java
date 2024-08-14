package com.alrosa.staa.gatekeeper_server_single;

import com.alrosa.staa.gatekeeper_server_single.RabbitMQ.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
@Import(RabbitConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class GatekeeperServerSingleApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatekeeperServerSingleApplication.class, args);
	}
}
