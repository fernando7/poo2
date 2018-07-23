package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.dao.RacaRepository;
import br.edu.ifg.poo2.model.Tamanho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnimalController {

    @Autowired
    private RacaRepository racaRepository;

    @RequestMapping(name = "/cadastrar-animal", method = RequestMethod.GET)
    public ModelAndView cadastrar(ModelAndView modelAndView) {
        modelAndView.addObject("tamanhos", Tamanho.values());
        modelAndView.addObject("racas", racaRepository.findAll());
        return modelAndView;
    }
}
