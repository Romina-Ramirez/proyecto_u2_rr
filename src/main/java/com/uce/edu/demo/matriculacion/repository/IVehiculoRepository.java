package com.uce.edu.demo.matriculacion.repository;

import com.uce.edu.demo.matriculacion.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void crear(Vehiculo v);

	public Vehiculo leer(String placa);

	public void actualizar(Vehiculo v);

	public void eliminar(String placa);

}
