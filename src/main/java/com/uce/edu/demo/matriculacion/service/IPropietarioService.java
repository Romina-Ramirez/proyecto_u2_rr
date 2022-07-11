package com.uce.edu.demo.matriculacion.service;

import com.uce.edu.demo.matriculacion.repository.modelo.Propietario;

public interface IPropietarioService {

	public void insertarPropietario(Propietario p);
	
	public Propietario buscar(String cedula);
	
	public void actualizar(Propietario p);

	public void eliminarPropietario(String cedula);

}
