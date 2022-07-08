package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	public void guardar(Persona p);

	public List<Persona> buscarPorApellido(String apellido);
	
	public List<Persona> buscarPorGenero(String genero);
	
	public List<Persona> buscarPorNombre(String nombre);

	public Persona buscarPorCedula(String cedula);

	public Persona buscarPorId(Integer id);

	public void actualizar(Persona p);

	public void eliminarPorId(Integer id);

}
