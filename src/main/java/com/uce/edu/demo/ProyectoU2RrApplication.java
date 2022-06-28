package com.uce.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);
	//private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2RrApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Persona persona = new Persona();
		persona.setId(5);
		persona.setNombre("Romina");
		persona.setApellido("Ramírez");
		
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		
		Persona persona1 = new Persona();
		persona1.setId(6);
		persona1.setNombre("Teresa");
		persona1.setApellido("Lopez");
		
		//Actualizar
		//this.iPersonaJdbcService.actualizar(persona1);
		
		//Eliminar
		//this.iPersonaJdbcService.eliminar(4);
		
		//Leer
		logger.info(this.iPersonaJdbcService.buscarPorCedula(3));
		
	}

}
