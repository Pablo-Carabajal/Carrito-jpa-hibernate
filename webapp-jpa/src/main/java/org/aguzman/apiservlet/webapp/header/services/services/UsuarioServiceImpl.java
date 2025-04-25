package org.aguzman.apiservlet.webapp.header.services.services;

import jakarta.inject.Inject;
import org.aguzman.apiservlet.webapp.header.services.configs.Service;
import org.aguzman.apiservlet.webapp.header.services.interceptors.TransactionalJpa;
import org.aguzman.apiservlet.webapp.header.services.models.entities.Usuario;
import org.aguzman.apiservlet.webapp.header.services.repositories.RepositoryJpa;
import org.aguzman.apiservlet.webapp.header.services.repositories.UsuarioRepository;

import java.util.Optional;

@Service
@TransactionalJpa
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
