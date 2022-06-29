package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.to.PersonaTo;

public interface IPersonaJdbcRepository {

	public void crear(PersonaTo p);

	public PersonaTo leer(int cedula);

	public void actualizar(PersonaTo p);

	public void eliminar(int cedula);
	
	public List<PersonaTo> buscarTodos();

}
