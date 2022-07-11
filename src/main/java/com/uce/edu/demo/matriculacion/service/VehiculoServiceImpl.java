package com.uce.edu.demo.matriculacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.matriculacion.repository.IVehiculoRepository;
import com.uce.edu.demo.matriculacion.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public void insertarVehiculo(Vehiculo v) {
		this.iVehiculoRepository.crear(v);
	}

	@Override
	public Vehiculo buscarVehiculo(String placa) {
		return this.iVehiculoRepository.leer(placa);
	}

	@Override
	public void actualizarVehiculo(Vehiculo v) {
		this.iVehiculoRepository.actualizar(v);
	}

	@Override
	public void eliminarVehiculo(String placa) {
		this.iVehiculoRepository.eliminar(placa);
	}

}
