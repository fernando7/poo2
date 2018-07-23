package br.edu.ifg.poo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.edu.ifg.poo2.model"})
public class MayaTinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MayaTinderApplication.class, args);
	}
}
