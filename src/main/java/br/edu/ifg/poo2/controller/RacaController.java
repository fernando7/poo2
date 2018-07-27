package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.model.Raca;
import br.edu.ifg.poo2.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@Controller
public class RacaController {

    @Autowired
    private RacaRepository racaRepository;

    @Transactional
    @PostMapping("/cadastrar-raca")
    public String cadastrar(Model model, Raca raca) {
        Raca novaRaca = racaRepository.save(raca);
        model.addAttribute("racas", racaRepository.findAll());
        model.addAttribute("racaPadrao", novaRaca.getId());

        return "racas";
    }
}
