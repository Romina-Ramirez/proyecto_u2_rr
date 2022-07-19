package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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

		List<PersonaSencilla> listaPerSen = this.iPersonaJpaService.buscarPorApellidoSencillo("Ramírez");
		for (PersonaSencilla item : listaPerSen) {
			logger.info("Persona Sencilla: " + item);
		}

		List<PersonaContadorGenero> listaPerContGen = this.iPersonaJpaService.consultarCantidadPorGenero();
		for (PersonaContadorGenero item : listaPerContGen) {
			logger.info("Cantidad por género: " + item);
		}

	}

}
