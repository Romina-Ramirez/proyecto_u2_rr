package com.uce.edu.demo.matriculacion.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.matriculacion.repository.IMatriculaRepository;
import com.uce.edu.demo.matriculacion.repository.IPropietarioRepository;
import com.uce.edu.demo.matriculacion.repository.IVehiculoRepository;
import com.uce.edu.demo.matriculacion.repository.modelo.Matricula;
import com.uce.edu.demo.matriculacion.repository.modelo.Propietario;
import com.uce.edu.demo.matriculacion.repository.modelo.Vehiculo;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;

	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Override
	public void generarMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario p = this.iPropietarioRepository.leer(cedula);
		Vehiculo v = this.iVehiculoRepository.leer(placa);
		String tipo = v.getTipo();
		BigDecimal valorMatricula;
		if (tipo.equals("L")) {
			valorMatricula = this.matriculaServiceLiviano.calcular(v.getPrecio());
		} else {
			valorMatricula = this.matriculaServicePesado.calcular(v.getPrecio());
		}

		if (valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal descuento;
			descuento = valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula = valorMatricula.subtract(descuento);
		}

		Matricula m = new Matricula();
		m.setFechaMatricula(LocalDateTime.now());
		m.setPropietario(p);
		m.setVehiculo(v);
		m.setValorMatricula(valorMatricula.setScale(0, RoundingMode.HALF_UP));
		this.iMatriculaRepository.crear(m);
	}

}
