package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.model.Pet;
import br.edu.ifg.poo2.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        List<Pet> animais = petRepository.findAll();

        modelAndView.setViewName("principal");
        modelAndView.addObject(animais);
        return modelAndView;
    }

    @GetMapping("/localizar")
    public ModelAndView localizar(ModelAndView modelAndView, String filtro) {
        List<Pet> animais = petRepository.findByNomeContainingOrDescricaoContaining(filtro, filtro);

        modelAndView.setViewName("principal");
        modelAndView.addObject(animais);
        return modelAndView;
    }
}
