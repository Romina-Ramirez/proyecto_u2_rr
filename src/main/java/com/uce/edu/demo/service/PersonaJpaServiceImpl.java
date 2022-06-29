package com.uce.edu.demo.service;

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
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.crear(p);
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.leer(id);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.actualizar(p);
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.eliminar(id);
	}

}
