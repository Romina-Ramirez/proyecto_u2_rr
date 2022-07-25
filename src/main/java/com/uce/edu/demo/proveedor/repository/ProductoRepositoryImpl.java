package com.uce.edu.demo.proveedor.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.proveedor.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Producto producto) {
		this.entityManager.persist(producto);
	}

	@Override
	public Producto leer(Integer id) {
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
	}

}
