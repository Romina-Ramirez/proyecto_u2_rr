package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.matriculacion.repository.modelo.Propietario;
import com.uce.edu.demo.matriculacion.repository.modelo.Vehiculo;
import com.uce.edu.demo.matriculacion.service.IMatriculaGestorService;
import com.uce.edu.demo.matriculacion.service.IPropietarioService;
import com.uce.edu.demo.matriculacion.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IMatriculaGestorService gestorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Audi");
		vehiculo.setModelo("R8");
		vehiculo.setPlaca("AAA - 123");
		vehiculo.setPrecio(new BigDecimal(200000));
		vehiculo.setTipo("L");

		this.iVehiculoService.insertarVehiculo(vehiculo);

		Propietario propietario = new Propietario();
		propietario.setCedula("1723069801");
		propietario.setNombre("Romina");
		propietario.setApellido("Ramírez");

		this.iPropietarioService.insertarPropietario(propietario);

		this.gestorService.generarMatricula("1723069801", "AAA - 123");

	}

}
