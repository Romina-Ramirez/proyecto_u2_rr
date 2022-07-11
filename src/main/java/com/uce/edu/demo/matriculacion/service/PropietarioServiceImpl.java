package com.uce.edu.demo.matriculacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.matriculacion.repository.IPropietarioRepository;
import com.uce.edu.demo.matriculacion.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public void insertarPropietario(Propietario p) {
		this.iPropietarioRepository.crear(p);
	}

	@Override
	public void eliminarPropietario(String cedula) {
		this.iPropietarioRepository.eliminar(cedula);
	}

	@Override
	public Propietario buscar(String cedula) {
		return null;
	}

	@Override
	public void actualizar(Propietario p) {
		
	}

}
