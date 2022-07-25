package com.uce.edu.demo.proveedor.service;

import com.uce.edu.demo.proveedor.repository.modelo.Proveedor;

public interface IProveedorService {

	public void insertar(Proveedor proveedor);

	public Proveedor buscar(Integer id);

	public void actualizar(Proveedor proveedor);

	public void eliminar(Integer id);

}
