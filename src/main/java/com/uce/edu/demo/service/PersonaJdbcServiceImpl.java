package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.PersonaTo;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService {

	@Autowired
	private IPersonaJdbcRepository personaJdbcRepository;

	@Override
	public void guardar(PersonaTo p) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.crear(p);
	}

	@Override
	public PersonaTo buscarPorCedula(int cedula) {
		// TODO Auto-generated method stub
		return this.personaJdbcRepository.leer(cedula);
	}

	@Override
	public void actualizar(PersonaTo p) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.actualizar(p);
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.eliminar(cedula);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.personaJdbcRepository.buscarTodos();
	}

}
