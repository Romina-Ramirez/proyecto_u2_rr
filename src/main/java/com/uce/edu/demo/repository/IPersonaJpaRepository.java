package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public void crear(Persona p);

	public Persona leer(Integer id);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

}
