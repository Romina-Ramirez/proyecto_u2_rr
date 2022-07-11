package com.uce.edu.demo.matriculacion.repository;

import com.uce.edu.demo.matriculacion.repository.modelo.Matricula;

public interface IMatriculaRepository {

	public void crear(Matricula m);
	
	public Matricula leer(Integer id);
	
	public void actualizar(Matricula m);
	
	public void eliminar(Integer id);

}
