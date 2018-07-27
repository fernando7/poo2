package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.model.Usuario;
import br.edu.ifg.poo2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    @Transactional
    public String cadastrar(HttpSession session, Usuario usuario) {
        Usuario usuarioPorEmail = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioPorEmail == null) {
            Usuario novoUsuario = usuarioRepository.save(usuario);
            session.setAttribute("usuarioLogado", novoUsuario);
        }


        return "principal";
    }
}
