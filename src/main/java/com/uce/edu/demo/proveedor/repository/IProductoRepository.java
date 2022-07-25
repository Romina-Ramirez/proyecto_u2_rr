package com.uce.edu.demo.proveedor.repository;

import com.uce.edu.demo.proveedor.repository.modelo.Producto;

public interface IProductoRepository {

	public void crear(Producto producto);

	public Producto leer(Integer id);

	public void actualizar(Producto producto);

	public void eliminar(Integer id);

}
