package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.Persona;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService {

	@Autowired
	private IPersonaJdbcRepository personaJdbcRepository;

	@Override
	public void guardar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.crear(p);
	}

	@Override
	public Persona buscarPorCedula(int cedula) {
		// TODO Auto-generated method stub
		return this.personaJdbcRepository.leer(cedula);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.actualizar(p);
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.eliminar(cedula);
	}

}
