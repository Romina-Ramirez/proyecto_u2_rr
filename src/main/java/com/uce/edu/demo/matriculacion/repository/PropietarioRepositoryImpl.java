package com.uce.edu.demo.matriculacion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.matriculacion.repository.modelo.Propietario;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Propietario p) {
		this.entityManager.persist(p);
	}

	@Override
	public Propietario leer(String cedula) {
		return this.entityManager.find(Propietario.class, cedula);
	}

	@Override
	public void actualizar(Propietario p) {
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(String cedula) {
		Propietario propietario = this.leer(cedula);
		this.entityManager.remove(propietario);
	}

}
