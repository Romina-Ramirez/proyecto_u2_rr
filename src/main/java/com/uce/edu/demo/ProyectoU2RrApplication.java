package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPa;
import com.uce.edu.demo.pasaporte.repository.modelo.Pasaporte;
import com.uce.edu.demo.pasaporte.service.ICiudadanoPaService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private ICiudadanoPaService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CiudadanoPa ciudadano = new CiudadanoPa();
		ciudadano.setNombre("Jorge");
		ciudadano.setApellido("Lopez");
		ciudadano.setCedula("0701236598");
		ciudadano.setFechaNacimiento(LocalDateTime.of(2000, 05, 03, 15, 54));

		Pasaporte pasaporte = new Pasaporte();
		pasaporte.setNumero("23478561");
		pasaporte.setFechaEmision(LocalDateTime.of(2022, 07, 22, 3, 49));
		pasaporte.setFechaCaducidad(LocalDateTime.of(2032, 07, 22, 3, 49));
		pasaporte.setCiudadanoPa(ciudadano);

		ciudadano.setPasaporte(pasaporte);

		this.iCiudadanoService.insertar(ciudadano);

		CiudadanoPa encontrado = this.iCiudadanoService.buscar(3);
		logger.info("Persona encontrada: " + encontrado);

		ciudadano.setCedula("0701236597");
		this.iCiudadanoService.actualizar(ciudadano);

		this.iCiudadanoService.eliminar(3);

	}

}
