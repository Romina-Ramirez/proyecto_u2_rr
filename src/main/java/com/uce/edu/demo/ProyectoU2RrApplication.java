package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
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
		persona.setNombre("Luis");
		persona.setApellido("Ramírez");

		Persona persona1 = new Persona();
		persona1.setNombre("Sana");
		persona1.setApellido("Lopez");

		// Guardar
		this.iPersonaJpaService.guardar(persona);
		this.iPersonaJpaService.guardar(persona1);
		
		//Leer
		//this.iPersonaJpaService.buscarPorId(10);

		// Actualizar
		persona1.setNombre("Maite");
		//this.iPersonaJpaService.actualizar(persona1);

		// Eliminar
		//this.iPersonaJpaService.eliminarPorId(11);

	}

}
