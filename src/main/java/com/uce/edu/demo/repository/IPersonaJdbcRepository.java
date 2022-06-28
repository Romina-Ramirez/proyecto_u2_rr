package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.Persona;

public interface IPersonaJdbcRepository {

	public void crear(Persona p);

	public Persona leer(int cedula);

	public void actualizar(Persona p);

	public void eliminar(int cedula);

}
