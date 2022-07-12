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
		
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Sandra");
		estudiante.setApellido("Ríos");
		estudiante.setDireccion("Av. ");
		estudiante.setTelefono("0970237431");
		
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setNombre("Pedro");
		estudiante1.setApellido("Garcés");
		estudiante1.setDireccion("Av. ");
		estudiante1.setTelefono("0963290876");

		//this.iEstudianteJpaService.guardar(estudiante);
		//this.iEstudianteJpaService.guardar(estudiante1);

		// 1. TypedQuery
		Estudiante estNomTelTyped = this.iEstudianteJpaService.buscarPorNombreTelefonoTyped("Romina", "0966451728");
		logger.info("Búsqueda por nombre y teléfono Typed:");
		logger.info("Estudiante Typed: " + estNomTelTyped);
		
		List<Estudiante> listaApellidoDescTyped = this.iEstudianteJpaService.buscarPorApellidoDescTyped("Ramírez");
		logger.info("Búsqueda por apellido desc Typed:");
		for(Estudiante item: listaApellidoDescTyped) {
			logger.info("Estudiante Typed: " + item);
		}

		// 2. NamedQuery
		List<Estudiante> listaApeDirNamed = this.iEstudianteJpaService.buscarPorApellidoDireccionNamed("Ramírez", "Av. Independencia");
		logger.info("Búsqueda por apellido y direccion Named:");
		for(Estudiante item: listaApeDirNamed) {
			logger.info("Estudiante Named: " + item);
		}
		
		Estudiante estApeTelNamed = this.iEstudianteJpaService.buscarPorApellidoTelefonoNamed("Lopez", "0987213241");
		logger.info("Búsqueda por apellido y teléfono Named:");
		logger.info("Estudiante Named: " + estApeTelNamed);

		// 3. TypedQuery + NamedQuery
		List<Estudiante> listaNomTypedNamed = this.iEstudianteJpaService.buscarPorNombreComienzaLetraTypedNamed("R");
		logger.info("Búsqueda por nombre que comienza con la letra R TypedNamed:");
		for(Estudiante item: listaNomTypedNamed) {
			logger.info("Estudiante TypedNamed: " + item);
		}
		
		List<Estudiante> listaNomApeAscTypedNamed = this.iEstudianteJpaService.OrdenarPorNombreApellidoAscTypedNamed();
		logger.info("Búsqueda de todas los estudiantes ordenados por nombre y apellido TypedNamed:");
		for(Estudiante item: listaNomApeAscTypedNamed) {
			logger.info("Estudiante TypedNamed: " + item);
		}

	}

}
