package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	// Crear
	@Override
	public void crear(Persona p) {
		this.entityManager.persist(p);
	}

	// Leer
	@Override
	public Persona leer(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public Persona leerPorCedula(String cedula) {
		// SELECT * FROM persona WHERE pers_cedula = '123456789'
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Persona) jpqlQuery.getSingleResult();
	}

	@Override
	public List<Persona> leerPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> leerPorGenero(String genero) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> leerPorNombre(String nombre) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	// Actualizar
	@Override
	public void actualizar(Persona p) {
		this.entityManager.merge(p);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// UPDATE persona SET pers_genero='F' WHERE pers_apellido = 'Ramírez'
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero = :datoGenero WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}

	// Eliminar
	@Override
	public void eliminar(Integer id) {
		Persona persona = this.leer(id);
		this.entityManager.remove(persona);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// DELETE FROM persona WHERE pers_genero='M'
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero = :genero");
		myQuery.setParameter("genero", genero);
		return myQuery.executeUpdate();
	}

}
