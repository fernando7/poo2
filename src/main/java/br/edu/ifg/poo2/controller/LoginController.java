package br.edu.ifg.poo2.controller;

import br.edu.ifg.poo2.repository.UsuarioRepository;
import br.edu.ifg.poo2.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    public static final String USUARIO_LOGADO = "usuarioLogado";
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
