package br.edu.ifg.poo2.converter;

import br.edu.ifg.poo2.model.Tamanho;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class TamanhoConverter implements Converter<String, Tamanho> {

    @Nullable
    @Override
    public Tamanho convert(String s) {
        if (s != null)
            return Tamanho.valueOf(s.toUpperCase());

        return null;
    }
}
