package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante estudiante = new Estudiante();
		estudiante.setId("7");
		estudiante.setNombre("Romina");
		estudiante.setApellido("Ramírez");
		estudiante.setDireccion("Av. Independencia");
		estudiante.setTelefono("0968527182");

		Estudiante estudiante1 = new Estudiante();
		estudiante1.setId("8");
		estudiante1.setNombre("Evelyn");
		estudiante1.setApellido("Loayza");
		estudiante1.setDireccion("Av. Kennedy");
		estudiante1.setTelefono("0987462514");

		Estudiante estudiante2 = new Estudiante();
		estudiante2.setId("9");

		// Guardar
		this.iEstudianteJpaService.guardar(estudiante);
		this.iEstudianteJpaService.guardar(estudiante1);
		this.iEstudianteJpaService.guardar(estudiante2);

		// Buscar por Id
		logger.info(this.iEstudianteJpaService.buscarPorId("9"));

		// Actualizar
		estudiante1.setTelefono("0987462524");
		this.iEstudianteJpaService.actualizar(estudiante1);

		// Eliminar
		this.iEstudianteJpaService.eliminarPorId("9");

	}

}
