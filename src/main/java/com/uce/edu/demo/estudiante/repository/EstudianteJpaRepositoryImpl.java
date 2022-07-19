package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;

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

	// Criteria API
	@Override
	public List<Estudiante> leerPorApellidoCriteriaApi(String apellido) {
		CriteriaBuilder miBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> miQuery = miBuilder.createQuery(Estudiante.class);
		Root<Estudiante> estudianteFrom = miQuery.from(Estudiante.class);
		Predicate p1 = miBuilder.equal(estudianteFrom.get("apellido"), apellido);
		miQuery.select(estudianteFrom).where(p1);
		TypedQuery<Estudiante> miQueryFinal = this.entityManager.createQuery(miQuery);
		return miQueryFinal.getResultList();
	}

	@Override
	public List<Estudiante> leerDinamicamente(Integer semestre, String nombre, String apellido, String cedula) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate predicadoCedula = myCriteria.equal(myTabla.get("cedula"), cedula);

		Predicate miPredicadoFinal = null;

		if (semestre.equals(6)) {
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido, predicadoCedula);
		} else {
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
			miPredicadoFinal = myCriteria.or(miPredicadoFinal, predicadoCedula);
		}

		myQuery.select(myTabla).where(miPredicadoFinal);

		TypedQuery<Estudiante> miQueryFinal = this.entityManager.createQuery(myQuery);

		return miQueryFinal.getResultList();
	}

	// Objeto Sencillo
	@Override
	public List<EstudianteSencillo> leerPorGeneroSencillo(String genero) {
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo(e.cedula, e.apellido, e.semestre) FROM Estudiante e WHERE e.genero = :datoGenero",
				EstudianteSencillo.class);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteContadorSemestre> leerEstudiantesContadorSemestre(String genero) {
		TypedQuery<EstudianteContadorSemestre> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorSemestre(e.semestre, e.genero, COUNT(e.semestre)) FROM Estudiante e WHERE e.genero = :datoGenero GROUP BY e.semestre, e.genero",
				EstudianteContadorSemestre.class);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
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
