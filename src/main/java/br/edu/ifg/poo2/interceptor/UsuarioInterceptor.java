package br.edu.ifg.poo2.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioInterceptor extends HandlerInterceptorAdapter {


    private static final String LOGIN_FORM = "/login";
    private static final String USUARIO_LOGADO = "usuarioLogado";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String uri = request.getRequestURI();

        if (uri.endsWith("/login") || uri.contains("css/") || uri.contains("js/") || uri.contains("img/") || uri.contains("fonts/"))
            return true;

        if (request.getSession().getAttribute(USUARIO_LOGADO) != null)
            return true;

        response.sendRedirect(request.getContextPath() + LOGIN_FORM);
        return false;
    }
}
