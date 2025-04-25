package org.aguzman.apiservlet.webapp.header.services.repositories;

import org.aguzman.apiservlet.webapp.header.services.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
