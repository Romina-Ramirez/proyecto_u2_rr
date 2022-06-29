package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	
	public void guardar(Persona p);

	public Persona buscarPorId(Integer id);

	public void actualizar(Persona p);

	public void eliminarPorId(Integer id);

}
