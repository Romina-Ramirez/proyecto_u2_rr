package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public void crear(Persona p);

	public List<Persona> leerPorApellido(String apellido);

	public List<Persona> leerPorGenero(String genero);

	public Persona leerPorCedula(String cedula);

	public Persona leer(Integer id);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

}
