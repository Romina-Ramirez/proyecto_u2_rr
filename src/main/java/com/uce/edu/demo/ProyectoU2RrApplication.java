package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.Detalle;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Factura fact = this.facturaService.consultar(1);
		logger.info("Número: " + fact.getNumero());
		logger.info("Fecha: " + fact.getFecha());
		logger.info("Cliente: " + fact.getCliente().getNumeroTarjeta());

		List<Detalle> detalles = fact.getDetalles();
		for (Detalle deta : detalles) {
			logger.info("Detalle: " + deta);
		}

	}

}
