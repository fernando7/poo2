package br.edu.ifg.poo2.converter;

import br.edu.ifg.poo2.model.Raca;
import br.edu.ifg.poo2.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RacaConveter implements Converter<String, Raca> {

    private final RacaRepository racaRepository;

    @Autowired
    public RacaConveter(RacaRepository racaRepository) {
        this.racaRepository = racaRepository;
    }

    @Nullable
    @Override
    public Raca convert(String s) {
        return racaRepository.findById(Long.parseLong(s)).get();
    }
}
