package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Actualizar por Apellido
		int resultado = this.iPersonaJpaService.actualizarPorApellido("FE",
		"Lopez");
		logger.info("Cantidad de registros actualizados: " + resultado );

		// Eliminar por genero
		int resultado2 = this.iPersonaJpaService.eliminarPorGenero("F");
		logger.info("Cantidad de registros eliminados: " + resultado2);

	}

}
