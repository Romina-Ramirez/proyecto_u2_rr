package com.uce.edu.demo.matriculacion.repository;

import com.uce.edu.demo.matriculacion.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public void crear(Propietario p);
	
	public Propietario leer(String cedula);
	
	public void actualizar(Propietario p);

	public void eliminar(String cedula);

}
