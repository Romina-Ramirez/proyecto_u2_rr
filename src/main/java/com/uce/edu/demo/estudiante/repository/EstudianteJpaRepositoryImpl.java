package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Estudiante e) {
		this.entityManager.persist(e);
	}

	@Override
	public Estudiante leer(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	// Typed
	@Override
	public Estudiante leerPorNombreTelefonoTyped(String nombre, String telefono) {
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre AND e.telefono = :datoTelefono",
				Estudiante.class);
		miTypedQuery.setParameter("datoNombre", nombre);
		miTypedQuery.setParameter("datoTelefono", telefono);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> leerPorApellidoDescTyped(String apellido) {
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido ORDER BY e.nombre DESC", Estudiante.class);
		miTypedQuery.setParameter("datoApellido", apellido);
		return miTypedQuery.getResultList();
	}

	// Named
	@Override
	public List<Estudiante> leerPorApellidoDireccionNamed(String apellido, String direccion) {
		Query miNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoDireccion");
		miNamedQuery.setParameter("datoApellido", apellido);
		miNamedQuery.setParameter("datoDireccion", direccion);
		return miNamedQuery.getResultList();
	}

	@Override
	public Estudiante leerPorApellidoTelefonoNamed(String apellido, String telefono) {
		Query miNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoTelefono");
		miNamedQuery.setParameter("datoApellido", apellido);
		miNamedQuery.setParameter("datoTelefono", telefono);
		return (Estudiante) miNamedQuery.getSingleResult();
	}

	// TypedNamed
	@Override
	public List<Estudiante> leerPorNombreComienzaLetraTypedNamed(String letra) {
		TypedQuery<Estudiante> miTypedNamedQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarPorNombreComienzaLetra", Estudiante.class);
		miTypedNamedQuery.setParameter("Letra", letra + "%");
		return miTypedNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> OrdenarPorNombreApellidoAscTypedNamed() {
		TypedQuery<Estudiante> miTypedNamedQuery = this.entityManager
				.createNamedQuery("Estudiante.OrdenarPorNombreApellidoAsc", Estudiante.class);
		return miTypedNamedQuery.getResultList();
	}

	// Native
	@Override
	public List<Estudiante> leerPorGeneroNative(String genero) {
		Query miNativeQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_genero = :datoGenero ORDER BY estu_apellido", Estudiante.class);
		miNativeQuery.setParameter("datoGenero", genero);
		return miNativeQuery.getResultList();
	}

	@Override
	public List<Estudiante> leerPorSemestreNative(Integer semestre) {
		Query miNativeQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_semestre = :datoSemestre ORDER BY estu_nombre", Estudiante.class);
		miNativeQuery.setParameter("datoSemestre", semestre);
		return miNativeQuery.getResultList();
	}

	// NamedNative
	@Override
	public List<Estudiante> leerPorApellidoComienzaLetraNamedNative(String letra) {
		TypedQuery<Estudiante> miNamedNativeQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarApellidoComienzaLetraNative", Estudiante.class);
		miNamedNativeQuery.setParameter("Letra", letra + "%");
		return miNamedNativeQuery.getResultList();
	}

	@Override
	public List<Estudiante> leerPorSemestreGeneroNamedNative(Integer semestre, String genero) {
		TypedQuery<Estudiante> miNamedNativeQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarSemestreGeneroNative", Estudiante.class);
		miNamedNativeQuery.setParameter("datoSemestre", semestre);
		miNamedNativeQuery.setParameter("datoGenero", genero);
		return miNamedNativeQuery.getResultList();
	}

	@Override
	public void actualizar(Estudiante e) {
		this.entityManager.merge(e);
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estudiante = this.leer(id);
		this.entityManager.remove(estudiante);
	}

}
