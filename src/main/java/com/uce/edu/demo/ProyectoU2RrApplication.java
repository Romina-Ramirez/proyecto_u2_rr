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

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca("ABC-123");
		vehiculo.setMarca("Audi");
		vehiculo.setModelo("R8");
		vehiculo.setPrecio(new BigDecimal(20000));
		vehiculo.setTipo("L");
		
		this.iVehiculoService.insertarVehiculo(vehiculo);
		
		logger.info(this.iVehiculoService.buscarVehiculo("ABC-123"));
		
		vehiculo.setPrecio(new BigDecimal(200000));
		this.iVehiculoService.actualizarVehiculo(vehiculo);
		
		this.iVehiculoService.eliminarVehiculo("ABB-123");
		
		
		Propietario propietario = new Propietario();
		propietario.setCedula("1723069804");
		propietario.setNombre("Romina");
		propietario.setApellido("Ramírez");
		
		this.iPropietarioService.insertarPropietario(propietario);
		
		logger.info(this.iPropietarioService.buscar("1723069804"));
		
		propietario.setNombre("Maite");
		this.iPropietarioService.actualizar(propietario);
		
		this.iPropietarioService.eliminarPropietario("1723069801");
		
		
//		this.gestorService.generarMatricula("1723069801", "AAA-123");

	}

}
