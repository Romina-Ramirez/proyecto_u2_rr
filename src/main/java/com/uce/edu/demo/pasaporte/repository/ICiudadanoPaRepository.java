package com.uce.edu.demo.pasaporte.repository;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPa;

public interface ICiudadanoPaRepository {

	public void crear(CiudadanoPa c);

	public CiudadanoPa leer(Integer id);

	public void actualizar(CiudadanoPa c);

	public void eliminar(Integer id);
}
