package com.uce.edu.demo.pasaporte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.pasaporte.repository.ICiudadanoPaRepository;
import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPa;

@Service
public class CiudadanoPaServiceImpl implements ICiudadanoPaService {

	@Autowired
	private ICiudadanoPaRepository ciudadanoRepository;

	@Override
	public void insertar(CiudadanoPa c) {
		this.ciudadanoRepository.crear(c);
	}

	@Override
	public CiudadanoPa buscar(Integer id) {
		return this.ciudadanoRepository.leer(id);
	}

	@Override
	public void actualizar(CiudadanoPa c) {
		this.ciudadanoRepository.actualizar(c);
	}

	@Override
	public void eliminar(Integer id) {
		this.ciudadanoRepository.eliminar(id);
	}

}
