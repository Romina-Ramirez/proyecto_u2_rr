package com.uce.edu.demo.proveedor.service;

import com.uce.edu.demo.proveedor.repository.modelo.Producto;

public interface IProductoService {

	public void insertar(Producto producto);

	public Producto buscar(Integer id);

	public void actualizar(Producto producto);

	public void eliminar(Integer id);

}
