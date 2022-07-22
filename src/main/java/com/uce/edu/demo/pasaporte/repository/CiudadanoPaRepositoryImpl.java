package com.uce.edu.demo.pasaporte.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPa;

@Repository
@Transactional
public class CiudadanoPaRepositoryImpl implements ICiudadanoPaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(CiudadanoPa c) {
		this.entityManager.persist(c);
	}

	@Override
	public CiudadanoPa leer(Integer id) {
		return this.entityManager.find(CiudadanoPa.class, id);
	}

	@Override
	public void actualizar(CiudadanoPa c) {
		this.entityManager.merge(c);
	}

	@Override
	public void eliminar(Integer id) {
		CiudadanoPa ciudadano = this.leer(id);
		this.entityManager.remove(ciudadano);
	}

}
