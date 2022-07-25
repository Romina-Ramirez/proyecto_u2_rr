package com.uce.edu.demo.proveedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.proveedor.repository.IProductoRepository;
import com.uce.edu.demo.proveedor.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public void insertar(Producto producto) {
		this.productoRepository.crear(producto);
		;
	}

	@Override
	public Producto buscar(Integer id) {
		return this.productoRepository.leer(id);
	}

	@Override
	public void actualizar(Producto producto) {
		this.productoRepository.actualizar(producto);
	}

	@Override
	public void eliminar(Integer id) {
		this.productoRepository.eliminar(id);
	}

}
