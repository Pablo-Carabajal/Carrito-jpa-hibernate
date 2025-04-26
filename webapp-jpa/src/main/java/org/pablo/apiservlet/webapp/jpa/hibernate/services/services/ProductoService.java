package org.pablo.apiservlet.webapp.jpa.hibernate.services.services;

import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Categoria;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
