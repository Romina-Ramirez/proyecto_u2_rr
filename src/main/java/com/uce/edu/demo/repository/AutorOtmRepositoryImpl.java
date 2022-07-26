package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.AutorOTM;

@Repository
@Transactional
public class AutorOtmRepositoryImpl implements IAutorOtmRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(AutorOTM autor) {
		this.entityManager.persist(autor);
	}

}
