package com.uce.edu.demo.matriculacion.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.matriculacion.repository.modelo.Matricula;

@Service
@Qualifier("liviano")
public class MatriculaLivianoServiceImpl implements IMatriculaService{

	@Override
	public BigDecimal calcular(BigDecimal precioVehiculo) {
		return precioVehiculo.multiply(new BigDecimal(0.14));
	}

	@Override
	public void insertar(Matricula m) {

	}

	@Override
	public Matricula buscar(Integer id) {
		return null;
	}

	@Override
	public void actualizar(Matricula m) {

	}

	@Override
	public void eliminar(Integer id) {

	}

}