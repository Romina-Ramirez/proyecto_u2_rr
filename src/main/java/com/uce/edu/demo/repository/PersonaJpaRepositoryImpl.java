package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
	public Persona leerPorCedulaTyped(String cedula) {
		TypedQuery<Persona> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula", Persona.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public Persona leerPorCedulaNamed(String cedula) {
		Query miNamedQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		miNamedQuery.setParameter("datoCedula", cedula);
		return (Persona) miNamedQuery.getSingleResult();
	}

	@Override
	public Persona leerPorCedulaTypedNamed(String cedula) {
		TypedQuery<Persona> miTypedNamedQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula",
				Persona.class);
		miTypedNamedQuery.setParameter("datoCedula", cedula);
		return miTypedNamedQuery.getSingleResult();
	}

	@Override
	public List<Persona> leerPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> leerPorNombreApellido(String nombre, String apellido) {
		TypedQuery<Persona> miTypedNamedQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",
				Persona.class);
		miTypedNamedQuery.setParameter("datoNombre", nombre);
		miTypedNamedQuery.setParameter("datoApellido", apellido);
		return miTypedNamedQuery.getResultList();
	}

	@Override
	public Persona leerPorCedulaNative(String cedula) {
		Query miNativeQuery = this.entityManager
				.createNativeQuery("SELECT * FROM persona WHERE pers_cedula = :datoCedula", Persona.class);
		miNativeQuery.setParameter("datoCedula", cedula);
		return (Persona) miNativeQuery.getSingleResult();
	}

	@Override
	public Persona leerPorCedulaNamedNative(String cedula) {
		TypedQuery<Persona> miNamedNativeQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",
				Persona.class);
		miNamedNativeQuery.setParameter("datoCedula", cedula);
		return miNamedNativeQuery.getSingleResult();
	}

	@Override
	public Persona leerPorCedulaCriteriaApi(String cedula) {
		CriteriaBuilder miBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> miQuery = miBuilder.createQuery(Persona.class);
		Root<Persona> personaRoot = miQuery.from(Persona.class);
		TypedQuery<Persona> miQueryFinal = this.entityManager
				.createQuery(miQuery.select(personaRoot).where(miBuilder.equal(personaRoot.get("cedula"), cedula)));
		return miQueryFinal.getSingleResult();
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
