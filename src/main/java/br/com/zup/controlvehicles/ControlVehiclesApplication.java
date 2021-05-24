package br.com.zup.controlvehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControlVehiclesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlVehiclesApplication.class, args);
	}

}
