package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {

	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	// Guardar
	@Override
	public void guardar(Persona p) {
		this.iPersonaJpaRepository.crear(p);
	}

	// Buscar
	@Override
	public Persona buscarPorId(Integer id) {
		return this.iPersonaJpaRepository.leer(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedula(cedula);
	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedulaTyped(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedulaTypedNamed(cedula);
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		return this.iPersonaJpaRepository.leerPorApellido(apellido);
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		return this.iPersonaJpaRepository.leerPorNombreApellido(nombre, apellido);
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedulaNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedulaNamedNative(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedulaCriteriaApi(cedula);
	}
	
	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		return this.iPersonaJpaRepository.leerDinamicamente(nombre, apellido, genero);
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		return this.iPersonaJpaRepository.leerPorGenero(genero);
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		return this.iPersonaJpaRepository.leerPorNombre(nombre);
	}

	// Actualizar
	@Override
	public void actualizar(Persona p) {
		this.iPersonaJpaRepository.actualizar(p);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		return this.iPersonaJpaRepository.actualizarPorApellido(genero, apellido);
	}

	// Eliminar
	@Override
	public void eliminarPorId(Integer id) {
		this.iPersonaJpaRepository.eliminar(id);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		return this.iPersonaJpaRepository.eliminarPorGenero(genero);
	}

}
