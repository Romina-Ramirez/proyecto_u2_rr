package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcService {
	
	public void guardar(Estudiante e);

	public Estudiante buscarPorId(String id);

	public void actualizar(Estudiante e);

	public void eliminarPorId(String id);

}
