package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.dao.UsuarioRepository;
import br.edu.ifg.poo2.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    @Transactional
    public String cadastrar(Usuario usuario) {
        Usuario usuarioPorEmail = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioPorEmail == null)
            usuarioRepository.save(usuario);
        return "principal";
    }
}
