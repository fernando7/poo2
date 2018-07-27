package br.edu.ifg.poo2.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

public class LocalDateConverter implements Converter<String, LocalDate> {

    @Nullable
    @Override
    public LocalDate convert(String s) {
        if (s != null && s.matches("\\d{4}-\\d{2}-\\d{2}"))
            return LocalDate.parse(s);

        return null;
    }
}
