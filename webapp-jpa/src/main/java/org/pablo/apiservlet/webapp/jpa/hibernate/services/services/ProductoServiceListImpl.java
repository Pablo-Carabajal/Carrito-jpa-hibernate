package org.pablo.apiservlet.webapp.jpa.hibernate.services.services;

import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Categoria;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// @Alternative
public class ProductoServiceListImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 175000),
                new Producto(2L, "mesa escritorio", "oficina", 100000),
                new Producto(3L, "teclado mecanico", "computacion", 40000));
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return null;
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
