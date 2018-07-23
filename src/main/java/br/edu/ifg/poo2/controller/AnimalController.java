package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.model.Tamanho;
import br.edu.ifg.poo2.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnimalController {

    @Autowired
    private RacaRepository racaRepository;

    @RequestMapping(value = "/cadastro-animal", method = RequestMethod.GET)
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("cadastro-animal");
        modelAndView.addObject("tamanhos", Tamanho.values());
        modelAndView.addObject("racas", racaRepository.findAll());
        return modelAndView;
    }

}
