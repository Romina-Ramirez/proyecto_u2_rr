package com.uce.edu.demo.matriculacion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.matriculacion.repository.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Vehiculo v) {
		this.entityManager.persist(v);
	}

	@Override
	public Vehiculo leer(String placa) {
		return this.entityManager.find(Vehiculo.class, placa);
	}

	@Override
	public void actualizar(Vehiculo v) {
		this.entityManager.merge(v);
	}

	@Override
	public void eliminar(String placa) {
		Vehiculo vehiculo = this.leer(placa);
		this.entityManager.remove(vehiculo);
	}

}
