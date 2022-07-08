package com.uce.edu.demo;

import java.util.List;

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

		Persona persona = new Persona();
		persona.setCedula("1739201776");
		persona.setNombre("Romina");
		persona.setApellido("Ramírez");
		persona.setGenero("F");

		Persona persona1 = new Persona();
		persona1.setCedula("0705376147");
		persona1.setNombre("Sana");
		persona1.setApellido("Lopez");
		persona1.setGenero("F");

		// Guardar
		// this.iPersonaJpaService.guardar(persona);
		// this.iPersonaJpaService.guardar(persona1);

		// Leer por Cedula
		// Persona p = this.iPersonaJpaService.buscarPorCedula("0705376147");
		// logger.info("Persona encontrada: " + p);

		// Leer por Apellido
		List<Persona> listaApellido = this.iPersonaJpaService.buscarPorApellido("Ramírez");
		for (Persona item : listaApellido) {
			logger.info("Busqueda por apellido: " + item);
		}

		// Leer por Genero
		List<Persona> listaGenero = this.iPersonaJpaService.buscarPorGenero("F");
		for (Persona item : listaGenero) {
			logger.info("Busqueda por genero: " + item);
		}

		// Leer por Nombre
		List<Persona> listaNombre = this.iPersonaJpaService.buscarPorNombre("Romina");
		for (Persona item : listaNombre) {
			logger.info("Busqueda por nombre: " + item);
		}

	}

}
