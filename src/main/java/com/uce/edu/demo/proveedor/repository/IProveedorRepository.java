package com.uce.edu.demo.proveedor.repository;

import com.uce.edu.demo.proveedor.repository.modelo.Proveedor;

public interface IProveedorRepository {

	public void crear(Proveedor proveedor);

	public Proveedor leer(Integer id);

	public void actualizar(Proveedor proveedor);

	public void eliminar(Integer id);

}
