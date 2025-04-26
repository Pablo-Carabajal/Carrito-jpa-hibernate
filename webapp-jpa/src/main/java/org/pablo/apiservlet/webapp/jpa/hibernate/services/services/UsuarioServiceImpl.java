package org.pablo.apiservlet.webapp.jpa.hibernate.services.services;

import jakarta.inject.Inject;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.configs.Service;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.interceptors.TransactionalJpa;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Usuario;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.repositories.RepositoryJpa;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.repositories.UsuarioRepository;

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
