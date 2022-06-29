package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.to.PersonaTo;

public interface IPersonaJdbcService {

	public void guardar(PersonaTo p);

	public PersonaTo buscarPorCedula(int cedula);

	public void actualizar(PersonaTo p);

	public void eliminar(int cedula);
	
	public List<PersonaTo> buscarTodos();

}
