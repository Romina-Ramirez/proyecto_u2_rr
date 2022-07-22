package com.uce.edu.demo.pasaporte.service;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPa;

public interface ICiudadanoPaService {
	
	public void insertar(CiudadanoPa c);

	public CiudadanoPa buscar(Integer id);

	public void actualizar(CiudadanoPa c);

	public void eliminar(Integer id);

}
