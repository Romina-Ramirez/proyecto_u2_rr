package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hotel hotel = new Hotel();
		hotel.setNombre("Hilton Colon GUY");
		hotel.setDireccion("Malecon");
		
		// this.hotelService.insertar(hotel);
		
		// Buscar numero
		Hotel hotelid = new Hotel();
		hotelid.setId(1);
		
		Habitacion habitacion = new Habitacion();
		habitacion.setNumero("356");
		habitacion.setPiso("12");
		habitacion.setTipo("Doble");
		habitacion.setHotel(hotelid);
		
		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumero("357");
		habitacion2.setPiso("12");
		habitacion2.setTipo("Doble");
		habitacion2.setHotel(hotelid);
		
		this.habitacionService.insertar(habitacion);
		this.habitacionService.insertar(habitacion2);

	}

}
