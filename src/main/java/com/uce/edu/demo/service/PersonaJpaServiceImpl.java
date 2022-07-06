package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {

	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	@Override
	public void guardar(Persona p) {
		this.iPersonaJpaRepository.crear(p);
	}

	@Override
	public Persona buscarPorId(Integer id) {
		return this.iPersonaJpaRepository.leer(id);
	}

	@Override
	public void actualizar(Persona p) {
		this.iPersonaJpaRepository.actualizar(p);
	}

	@Override
	public void eliminarPorId(Integer id) {
		this.iPersonaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		return this.iPersonaJpaRepository.leerPorCedula(cedula);
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		return this.iPersonaJpaRepository.leerPorApellido(apellido);
	}

}
