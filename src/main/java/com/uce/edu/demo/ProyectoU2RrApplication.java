package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;
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

		List<EstudianteSencillo> listaEstSen = this.iEstudianteJpaService.buscarPorGeneroSencillo("M");
		for (EstudianteSencillo item : listaEstSen) {
			logger.info("Estudiante Sencillo: " + item);
		}

		List<EstudianteContadorSemestre> listaEstContSem = this.iEstudianteJpaService.consultarCantidadPorSemestre("M");
		for (EstudianteContadorSemestre item : listaEstContSem) {
			logger.info("Cantidad por semestre: " + item);
		}

	}

}
