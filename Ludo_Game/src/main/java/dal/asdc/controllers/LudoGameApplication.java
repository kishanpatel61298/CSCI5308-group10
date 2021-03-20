package dal.asdc.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"dal.asdc.model", "dal.asdc.controllers"})
public class LudoGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(LudoGameApplication.class, args);
	}

}
