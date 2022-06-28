package com.uce.edu.demo.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.estudiante.to.Estudiante;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService {

	@Autowired
	private IEstudianteJdbcRepository estudianteJdbcRepository;

	@Override
	public void guardar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.crear(e);
	}

	@Override
	public Estudiante buscarPorId(String id) {
		// TODO Auto-generated method stub
		return this.estudianteJdbcRepository.leer(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.actualizar(e);
	}

	@Override
	public void eliminarPorId(String id) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.eliminar(id);
	}

}
