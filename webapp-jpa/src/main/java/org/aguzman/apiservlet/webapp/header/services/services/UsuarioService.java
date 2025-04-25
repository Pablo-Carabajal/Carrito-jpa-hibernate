package org.aguzman.apiservlet.webapp.header.services.services;

import org.aguzman.apiservlet.webapp.header.services.models.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
