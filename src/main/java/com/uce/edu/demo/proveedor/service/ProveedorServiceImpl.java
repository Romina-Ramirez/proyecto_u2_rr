package com.uce.edu.demo.proveedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.proveedor.repository.IProveedorRepository;
import com.uce.edu.demo.proveedor.repository.modelo.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private IProveedorRepository proveedorRepository;

	@Override
	public void insertar(Proveedor proveedor) {
		this.proveedorRepository.crear(proveedor);
	}

	@Override
	public Proveedor buscar(Integer id) {
		return this.proveedorRepository.leer(id);
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		this.proveedorRepository.actualizar(proveedor);
	}

	@Override
	public void eliminar(Integer id) {
		this.proveedorRepository.eliminar(id);
	}

}
