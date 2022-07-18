package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;

	@Override
	public void guardar(Estudiante e) {
		this.iEstudianteJpaRepository.crear(e);
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.iEstudianteJpaRepository.leer(id);
	}

	// Typed
	@Override
	public Estudiante buscarPorNombreTelefonoTyped(String nombre, String telefono) {
		return this.iEstudianteJpaRepository.leerPorNombreTelefonoTyped(nombre, telefono);
	}

	@Override
	public List<Estudiante> buscarPorApellidoDescTyped(String apellido) {
		return this.iEstudianteJpaRepository.leerPorApellidoDescTyped(apellido);
	}

	// Named
	@Override
	public List<Estudiante> buscarPorApellidoDireccionNamed(String apellido, String direccion) {
		return this.iEstudianteJpaRepository.leerPorApellidoDireccionNamed(apellido, direccion);
	}

	@Override
	public Estudiante buscarPorApellidoTelefonoNamed(String apellido, String telefono) {
		return this.iEstudianteJpaRepository.leerPorApellidoTelefonoNamed(apellido, telefono);
	}

	// TypedNamed
	@Override
	public List<Estudiante> buscarPorNombreComienzaLetraTypedNamed(String letra) {
		return this.iEstudianteJpaRepository.leerPorNombreComienzaLetraTypedNamed(letra);
	}

	@Override
	public List<Estudiante> OrdenarPorNombreApellidoAscTypedNamed() {
		return this.iEstudianteJpaRepository.OrdenarPorNombreApellidoAscTypedNamed();
	}

	// Native
	@Override
	public List<Estudiante> buscarPorGeneroNative(String genero) {
		return this.iEstudianteJpaRepository.leerPorGeneroNative(genero);
	}

	@Override
	public List<Estudiante> buscarPorSemestreNative(Integer semestre) {
		return this.iEstudianteJpaRepository.leerPorSemestreNative(semestre);
	}

	// NamedNative
	@Override
	public List<Estudiante> buscarPorApellidoComienzaLetraNamedNative(String letra) {
		return this.iEstudianteJpaRepository.leerPorApellidoComienzaLetraNamedNative(letra);
	}

	@Override
	public List<Estudiante> buscarPorSemestreGeneroNamedNative(Integer semestre, String genero) {
		return this.iEstudianteJpaRepository.leerPorSemestreGeneroNamedNative(semestre, genero);
	}
	
	// Criteria API
	@Override
	public List<Estudiante> buscarPorApellidoCriteriaApi(String apellido) {
		return this.iEstudianteJpaRepository.leerPorApellidoCriteriaApi(apellido);
	}

	@Override
	public List<Estudiante> buscarDinamicamente(Integer semestre, String nombre, String apellido, String cedula) {
		return this.iEstudianteJpaRepository.leerDinamicamente(semestre, nombre, apellido, cedula);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.iEstudianteJpaRepository.actualizar(e);
	}

	@Override
	public void eliminarPorId(Integer id) {
		this.iEstudianteJpaRepository.eliminar(id);
	}

}
