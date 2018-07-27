package br.edu.ifg.poo2;

import br.edu.ifg.poo2.converter.LocalDateConverter;
import br.edu.ifg.poo2.converter.RacaConveter;
import br.edu.ifg.poo2.converter.TamanhoConverter;
import br.edu.ifg.poo2.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@EntityScan(basePackages = {"br.edu.ifg.poo2.model"})
@ComponentScan(basePackages = {"br.edu.ifg.poo2.converter"})
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private RacaRepository racaRepository;

    @Bean
    public RacaConveter getRacaConverter() {
        return new RacaConveter(racaRepository);
    }

    @Bean
    public TamanhoConverter getTamanhoConveter() {
        return new TamanhoConverter();
    }

    @Bean
    public LocalDateConverter getLocalDateConverter() {
        return new LocalDateConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getRacaConverter());
        registry.addConverter(getTamanhoConveter());
        registry.addConverter(getLocalDateConverter());
    }
}
