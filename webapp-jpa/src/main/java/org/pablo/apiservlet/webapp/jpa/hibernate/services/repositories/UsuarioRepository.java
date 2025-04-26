package org.pablo.apiservlet.webapp.jpa.hibernate.services.repositories;

import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
