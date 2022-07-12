package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	// Crear
	public void crear(Persona p);

	// Leer
	public Persona leer(Integer id);

	public Persona leerPorCedula(String cedula);

	public Persona leerPorCedulaTyped(String cedula);

	public Persona leerPorCedulaNamed(String cedula);

	public Persona leerPorCedulaTypedNamed(String cedula);

	public List<Persona> leerPorApellido(String apellido);

	public List<Persona> leerPorNombreApellido(String nombre, String apellido);

	public List<Persona> leerPorGenero(String genero);

	public List<Persona> leerPorNombre(String nombre);

	// Actualizar
	public void actualizar(Persona p);

	public int actualizarPorApellido(String genero, String apellido);

	// Eliminar
	public void eliminar(Integer id);

	public int eliminarPorGenero(String genero);

}
