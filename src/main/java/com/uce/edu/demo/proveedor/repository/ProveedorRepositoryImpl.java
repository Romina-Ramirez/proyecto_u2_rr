package com.uce.edu.demo.proveedor.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.proveedor.repository.modelo.Proveedor;

@Repository
@Transactional
public class ProveedorRepositoryImpl implements IProveedorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Proveedor proveedor) {
		this.entityManager.persist(proveedor);
	}

	@Override
	public Proveedor leer(Integer id) {
		return this.entityManager.find(Proveedor.class, id);
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		this.entityManager.merge(proveedor);
	}

	@Override
	public void eliminar(Integer id) {
		Proveedor proveedor = this.leer(id);
		this.entityManager.remove(proveedor);
	}

}
