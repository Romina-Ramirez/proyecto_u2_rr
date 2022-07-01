package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcRepository {

	public void crear(EstudianteTo e);

	public EstudianteTo leer(String id);

	public void actualizar(EstudianteTo e);

	public void eliminar(String id);

}
