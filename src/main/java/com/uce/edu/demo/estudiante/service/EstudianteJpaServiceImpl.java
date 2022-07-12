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

	@Override
	public void actualizar(Estudiante e) {
		this.iEstudianteJpaRepository.actualizar(e);
	}

	@Override
	public void eliminarPorId(Integer id) {
		this.iEstudianteJpaRepository.eliminar(id);
	}

}
