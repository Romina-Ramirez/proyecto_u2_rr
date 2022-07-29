package com.uce.edu.demo.matriculacion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.matriculacion.repository.modelo.Matricula;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Matricula m) {
		this.entityManager.persist(m);
	}

	@Override
	public Matricula leer(Integer id) {
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	public void actualizar(Matricula m) {
		this.entityManager.merge(m);
	}

	@Override
	public void eliminar(Integer id) {
		Matricula matricula = this.leer(id);
		this.entityManager.remove(matricula);
	}

}