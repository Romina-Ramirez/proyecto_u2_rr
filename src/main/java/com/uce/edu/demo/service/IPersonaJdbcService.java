package com.uce.edu.demo.service;

import com.uce.edu.demo.to.Persona;

public interface IPersonaJdbcService {

	public void guardar(Persona p);

	public Persona buscarPorCedula(int cedula);

	public void actualizar(Persona p);

	public void eliminar(int cedula);

}
