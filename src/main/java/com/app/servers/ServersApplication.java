package com.app.servers;

import com.app.servers.model.Server;
import com.app.servers.repositories.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.app.servers.Status.*;


@SpringBootApplication
@RestController
public class ServersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServersApplication.class, args);
	}
//	@Bean
//	CommandLineRunner run(ServerRepository serverRepository){
//		return args ->{
//			serverRepository.save(new Server(null,"192.168.10.01","Ubunto Server", "65 GB", "Email Server", "http://localhost:8080/image/server1.png", SERVER_UP));
//		};
//
//	}

}
