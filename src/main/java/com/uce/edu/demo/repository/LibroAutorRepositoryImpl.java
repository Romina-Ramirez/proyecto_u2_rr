package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro_Autor;

@Repository
@Transactional
public class LibroAutorRepositoryImpl implements ILibroAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Libro_Autor libro_Autor) {
		this.entityManager.persist(libro_Autor);
	}

}
