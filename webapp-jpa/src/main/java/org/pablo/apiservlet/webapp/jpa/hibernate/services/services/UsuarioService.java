package org.pablo.apiservlet.webapp.jpa.hibernate.services.services;

import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
