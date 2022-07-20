package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("Romina");
		ciudadano.setApellido("Ramírez");

		Empleado empleado = new Empleado();
		empleado.setCodigoIess("12323");
		empleado.setSalario(new BigDecimal(100));
		empleado.setCiudadano(ciudadano);

		ciudadano.setEmpleado(empleado);

		this.ciudadanoService.insertar(ciudadano);

		Ciudadano ciudadano2 = new Ciudadano();
		ciudadano2.setNombre("Maria");
		ciudadano2.setApellido("Gomez");

		Empleado empleado2 = new Empleado();
		empleado2.setCodigoIess("45257");
		empleado2.setSalario(new BigDecimal(200));
		empleado2.setCiudadano(ciudadano2);

		ciudadano.setEmpleado(empleado2);

		// this.ciudadanoService.insertar(empleado2);

	}

}
