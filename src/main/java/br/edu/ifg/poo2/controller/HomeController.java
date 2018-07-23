package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.repository.AnimalRepository;
import br.edu.ifg.poo2.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AnimalRepository animalRepository;

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        List<Animal> animais = animalRepository.findAll();

        modelAndView.setViewName("principal");
        modelAndView.addObject(animais);
        return modelAndView;
    }

    @RequestMapping("/localizar")
    public ModelAndView localizar(ModelAndView modelAndView, String filtro) {
        List<Animal> animais = animalRepository.findByNomeContainingOrDescricaoContaining(filtro, filtro);

        modelAndView.setViewName("principal");
        modelAndView.addObject(animais);
        return modelAndView;
    }
}
