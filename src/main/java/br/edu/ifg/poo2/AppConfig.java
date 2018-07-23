package br.edu.ifg.poo2;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@EntityScan(basePackages = {"br.edu.ifg.poo2.model"})
@Configuration
public class AppConfig implements WebMvcConfigurer {
}
