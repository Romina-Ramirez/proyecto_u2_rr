package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.LibroOTM;

@Repository
@Transactional
public class LibroOtmRepositoryImpl implements ILibroOtmRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(LibroOTM libro) {
		this.entityManager.persist(libro);
	}

}
