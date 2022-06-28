package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public void crear(Estudiante e);

	public Estudiante leer(String id);

	public void actualizar(Estudiante e);

	public void eliminar(String id);

}
