package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
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

//		// 1. TypedQuery
//		Persona perTyped = this.iPersonaJpaService.buscarPorCedulaTyped("1739201782");
//		logger.info("Persona Typed: " + perTyped);
//
//		// 2. NamedQuery
//		Persona perNamed = this.iPersonaJpaService.buscarPorCedulaNamed("1739201782");
//		logger.info("Persona Named: " + perNamed);
//
//		// 3. TypedQuery + NamedQuery
//		Persona perTypedNamed = this.iPersonaJpaService.buscarPorCedulaTypedNamed("1739201782");
//		logger.info("Persona TypedNamed: " + perTypedNamed);
//
//		// 4. Varios NamedQuery
//		List<Persona> listaPersona = this.iPersonaJpaService.buscarPorNombreApellido("Romina", "Ramírez");
//		for (Persona item : listaPersona) {
//			logger.info("Persona: " + item);
//		}

		// 5. NativeQuery
		Persona perNative = this.iPersonaJpaService.buscarPorCedulaNative("1739201782");
		logger.info("Persona Native: " + perNative);

		// 6. NamedNativeQuery
		Persona perNamedNative = this.iPersonaJpaService.buscarPorCedulaNamedNative("1739201782");
		logger.info("Persona NamedNative: " + perNamedNative);

	}

}
