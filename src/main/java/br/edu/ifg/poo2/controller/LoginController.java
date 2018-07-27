package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.model.Usuario;
import br.edu.ifg.poo2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    public static final String USUARIO_LOGADO = "usuarioLogado";
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView efetuarLogin(HttpSession session, String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuario == null) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("usuarioInvalido", true);
            return modelAndView;

        } else {
            session.setAttribute("usuarioLogado", usuario);
            return new ModelAndView("redirect:home");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
