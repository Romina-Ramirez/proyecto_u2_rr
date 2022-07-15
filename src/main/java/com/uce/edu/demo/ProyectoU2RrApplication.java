package com.uce.edu.demo;

import java.util.List;

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

//		Estudiante estudiante = new Estudiante();
//		estudiante.setCedula("1793837261");
//		estudiante.setNombre("Maria");
//		estudiante.setApellido("Ramírez");
//		estudiante.setDireccion("Av. Independencia");
//		estudiante.setTelefono("0976566655");
//		estudiante.setGenero("F");
//		estudiante.setSemestre(6);
//
//		Estudiante estudiante1 = new Estudiante();
//		estudiante1.setCedula("1787639009");
//		estudiante1.setNombre("Jorge");
//		estudiante1.setApellido("Aguilar");
//		estudiante1.setDireccion("Av. Kennedy");
//		estudiante1.setTelefono("0965379483");
//		estudiante1.setGenero("M");
//		estudiante1.setSemestre(6);
//
//		this.iEstudianteJpaService.guardar(estudiante);
//		this.iEstudianteJpaService.guardar(estudiante1);

		// 5. NativeQuery
		List<Estudiante> listaGeneroNative = this.iEstudianteJpaService.buscarPorGeneroNative("F");
		logger.info("Búsqueda por género Native:");
		for (Estudiante item : listaGeneroNative) {
			logger.info("Estudiante Native: " + item);
		}

		List<Estudiante> listaSemestreNative = this.iEstudianteJpaService.buscarPorSemestreNative(6);
		logger.info("Búsqueda por semestre Native:");
		for (Estudiante item : listaSemestreNative) {
			logger.info("Estudiante Native: " + item);
		}

		// 6. NamedNativeQuery
		List<Estudiante> listaApellidoLetraNamedNative = this.iEstudianteJpaService
				.buscarPorApellidoComienzaLetraNamedNative("R");
		logger.info("Búsqueda por apellidos que comienzan con R NamedNative:");
		for (Estudiante item : listaApellidoLetraNamedNative) {
			logger.info("Estudiante NamedNative: " + item);
		}

		List<Estudiante> listaSemestreGeneroNamedNative = this.iEstudianteJpaService
				.buscarPorSemestreGeneroNamedNative(6, "M");
		logger.info("Búsqueda por semestre y genero NamedNative:");
		for (Estudiante item : listaSemestreGeneroNamedNative) {
			logger.info("Estudiante NamedNative: " + item);
		}

	}

}
