package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

public interface IPersonaJpaService {

	// Guardar
	public void guardar(Persona p);

	// Buscar
	public Persona buscarPorId(Integer id);

	public Persona buscarPorCedula(String cedula);

	public Persona buscarPorCedulaTyped(String cedula);

	public Persona buscarPorCedulaNamed(String cedula);

	public Persona buscarPorCedulaTypedNamed(String cedula);

	public Persona buscarPorCedulaNative(String cedula);

	public Persona buscarPorCedulaNamedNative(String cedula);

	public Persona buscarPorCedulaCriteriaApi(String cedula);

	public Persona buscarDinamicamente(String nombre, String apellido, String genero);

	public List<Persona> buscarPorApellido(String apellido);

	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);

	public List<Persona> buscarPorGenero(String genero);

	public List<Persona> buscarPorNombre(String nombre);

	// Buscar Objeto Sencillo
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido);

	public List<PersonaContadorGenero> consultarCantidadPorGenero();

	// Actualizar
	public void actualizar(Persona p);

	public int actualizarPorApellido(String genero, String apellido);

	// Eliminar
	public void eliminarPorId(Integer id);

	public int eliminarPorGenero(String genero);

}
