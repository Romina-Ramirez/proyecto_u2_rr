package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	// Guardar
	public void guardar(Persona p);

	// Buscar
	public Persona buscarPorId(Integer id);

	public Persona buscarPorCedula(String cedula);

	public Persona buscarPorCedulaTyped(String cedula);

	public Persona buscarPorCedulaNamed(String cedula);

	public Persona buscarPorCedulaTypedNamed(String cedula);

	public List<Persona> buscarPorApellido(String apellido);

	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);

	public List<Persona> buscarPorGenero(String genero);

	public List<Persona> buscarPorNombre(String nombre);

	// Actualizar
	public void actualizar(Persona p);

	public int actualizarPorApellido(String genero, String apellido);

	// Eliminar
	public void eliminarPorId(Integer id);

	public int eliminarPorGenero(String genero);

}
