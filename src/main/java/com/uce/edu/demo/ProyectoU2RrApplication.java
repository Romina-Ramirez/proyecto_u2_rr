package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

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

		// 7. Criteria API
		List<Estudiante> listaEstCriteria = this.iEstudianteJpaService.buscarPorApellidoCriteriaApi("Ramírez");
		logger.info("Búsqueda por apellido Criteria API:");
		for (Estudiante item : listaEstCriteria) {
			logger.info("Estudiante Criteria: " + item);
		}
		
		// 8. Criteria Dinamica
		List<Estudiante> listaEstCriteriaDin = this.iEstudianteJpaService.buscarDinamicamente(6, "Romina", "Ramírez", "1757975342");
		logger.info("Búsqueda dinámica Criteria API:");
		for (Estudiante item : listaEstCriteriaDin) {
			logger.info("Estudiante Criteria Dinamica: " + item);
		}
		
		List<Estudiante> listaEstCriteriaDin2 = this.iEstudianteJpaService.buscarDinamicamente(1, "Luisa", "Romer", "0701928374");
		logger.info("Búsqueda dinámica Criteria API 2:");
		for (Estudiante item : listaEstCriteriaDin2) {
			logger.info("Estudiante Criteria Dinamica 2: " + item);
		}

	}

}
