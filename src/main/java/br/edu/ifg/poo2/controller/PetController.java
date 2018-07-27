package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.model.Pet;
import br.edu.ifg.poo2.model.Tamanho;
import br.edu.ifg.poo2.repository.PetRepository;
import br.edu.ifg.poo2.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
public class PetController {

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private PetRepository petRepository;

    @GetMapping("/cadastro-pet")
    public String cadastro(Model model) {
        model.addAttribute("tamanhos", Tamanho.values());
        model.addAttribute("racas", racaRepository.findAll());

        return "cadastro-pet";
    }

    @PostMapping(value = "/cadastro-pet")
    @Transactional
    public String cadastrar(@Valid Pet pet) {
        petRepository.save(pet);
        return "principal";
    }
}
