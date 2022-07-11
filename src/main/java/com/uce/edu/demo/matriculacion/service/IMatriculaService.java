package com.uce.edu.demo.matriculacion.service;

import java.math.BigDecimal;

import com.uce.edu.demo.matriculacion.repository.modelo.Matricula;

public interface IMatriculaService {

	public BigDecimal calcular(BigDecimal precioVehiculo);
	
	public void insertar(Matricula m);
	
	public Matricula buscar(Integer id);
	
	public void actualizar(Matricula m);
	
	public void eliminar(Integer id);

}
