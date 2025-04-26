package org.pablo.apiservlet.webapp.jpa.hibernate.services.services;

import jakarta.inject.Inject;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.configs.ProductoServicePrincipal;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.configs.Service;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.interceptors.TransactionalJpa;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Categoria;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.models.entities.Producto;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.repositories.CrudRepository;
import org.pablo.apiservlet.webapp.jpa.hibernate.services.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
@TransactionalJpa
public class ProductoServiceImpl implements ProductoService{
    @Inject
    @RepositoryJpa
    private CrudRepository<Producto> crudRepositoryJdbc;

    @Inject
    @RepositoryJpa
    private CrudRepository<Categoria> crudRepositoryCategoriaJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return crudRepositoryJdbc.listar();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(crudRepositoryJdbc.porId(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            crudRepositoryJdbc.guardar(producto);
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            crudRepositoryJdbc.eliminar(id);
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return crudRepositoryCategoriaJdbc.listar();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(crudRepositoryCategoriaJdbc.porId(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
