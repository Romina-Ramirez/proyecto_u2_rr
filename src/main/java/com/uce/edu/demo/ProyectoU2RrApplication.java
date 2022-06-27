package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Registra un mensaje de nivel de seguimiento.
		logger.trace("TRACE");

		// Para mensajes de depuración, mientras se está desarrollando la aplicación,
		// para ver cómo se comporta.
		logger.debug("DEBUG");

		// Para mensajes que muestren información del programa durante su ejecución
		// (por ejemplo, versión que se esté ejecutando, inicios o fines de procesos que
		// se lancen, etc)
		logger.info("INFO");

		// Para mensajes de alerta sobre situaciones anómalas que se produzcan, pero que
		// no afecten el
		// funcionamiento correcto del programa.
		logger.warn("WARN");

		// Para guardar constancia de errores del programa que, aunque le permitan
		// seguir funcionando,
		// afecten al funcionamiento del mismo. Por ejemplo, que un parámetro de
		// configuración tenga
		// un valor incorrecto, o que no se encuentre un fichero no crítico.
		logger.error("ERROR");

		// Se utiliza para mensajes críticos, por errores que hacen que el programa
		// generalmente aborte su ejecución.
		logger.fatal("FATAL");

	}

}
