package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Persona p) {
		this.entityManager.persist(p);
	}

	@Override
	public Persona leer(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona p) {
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(Integer id) {
		Persona persona = this.leer(id);
		this.entityManager.remove(persona);
	}

}
