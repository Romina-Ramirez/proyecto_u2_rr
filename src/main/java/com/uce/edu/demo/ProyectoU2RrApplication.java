package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.to.Estudiante;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante estudiante = new Estudiante();
		estudiante.setId("1");
		estudiante.setNombre("Romina");
		estudiante.setApellido("Ramírez");
		estudiante.setDireccion("Av. Independencia");
		estudiante.setTelefono("0968527182");

		Estudiante estudiante1 = new Estudiante();
		estudiante1.setId("2");
		estudiante1.setNombre("Evelyn");
		estudiante1.setApellido("Loayza");
		estudiante1.setDireccion("Av. Kennedy");
		estudiante.setTelefono("0987462514");

		Estudiante estudiante2 = new Estudiante();
		estudiante2.setId("3");

		// Insertar
		this.estudianteJdbcService.guardar(estudiante);
		this.estudianteJdbcService.guardar(estudiante1);
		this.estudianteJdbcService.guardar(estudiante2);

		// Leer
		logger.info(this.estudianteJdbcService.buscarPorId("1"));

		estudiante1.setTelefono("0987462524");

		// Actualizar
		this.estudianteJdbcService.actualizar(estudiante1);

		// Eliminar
		this.estudianteJdbcService.eliminarPorId("3");

	}

}
