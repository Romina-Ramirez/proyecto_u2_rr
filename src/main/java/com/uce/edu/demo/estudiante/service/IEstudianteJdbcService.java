package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcService {
	
	public void guardar(EstudianteTo e);

	public EstudianteTo buscarPorId(String id);

	public void actualizar(EstudianteTo e);

	public void eliminarPorId(String id);

}
