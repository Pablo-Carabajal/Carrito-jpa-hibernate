package org.pablo.apiservlet.webapp.jpa.hibernate.services.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.services.LoginService;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/carro/*", "/productos/form/*", "/productos/eliminar/*"})
public class LoginFiltro implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> username = service.getUsername((HttpServletRequest) request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos no estas autorizado para ingresar a esta pagina!");
        }
    }
}
