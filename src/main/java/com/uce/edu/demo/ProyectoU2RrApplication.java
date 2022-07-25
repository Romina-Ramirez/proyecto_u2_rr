package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.proveedor.repository.modelo.Proveedor;
import com.uce.edu.demo.proveedor.service.IProveedorService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private IProveedorService proveedorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Proveedor proveedor = new Proveedor();
		proveedor.setNombre("Prov3");
		proveedor.setDireccion("Av. Loja");
		proveedor.setTipo("Importador");

		this.proveedorService.insertar(proveedor);

		Proveedor proveedor1 = new Proveedor();
		proveedor1.setNombre("Prov4");
		proveedor1.setDireccion("Av. América");
		proveedor1.setTipo("Fabricante");

		this.proveedorService.insertar(proveedor1);

		Proveedor provEncontrado = this.proveedorService.buscar(3);
		logger.info(provEncontrado);

		proveedor1.setTipo("Independiente");
		this.proveedorService.actualizar(proveedor1);

		this.proveedorService.eliminar(5);
	}

}
