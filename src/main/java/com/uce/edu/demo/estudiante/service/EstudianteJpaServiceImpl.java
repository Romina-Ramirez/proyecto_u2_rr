package com.uce.edu.demo.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;

	@Override
	public void guardar(Estudiante e) {
		this.iEstudianteJpaRepository.crear(e);
	}

	@Override
	public Estudiante buscarPorId(String id) {
		return this.iEstudianteJpaRepository.leer(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.iEstudianteJpaRepository.actualizar(e);
	}

	@Override
	public void eliminarPorId(String id) {
		this.iEstudianteJpaRepository.eliminar(id);
	}

}
