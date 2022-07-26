package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.AutorOTM;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.repository.modelo.manytomany.LibroOTM;
import com.uce.edu.demo.repository.modelo.manytomany.Libro_Autor;
import com.uce.edu.demo.service.IAutorOtmService;
import com.uce.edu.demo.service.ILibroAutorService;
import com.uce.edu.demo.service.ILibroOtmService;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU2RrApplication.class);

	@Autowired
	private ILibroOtmService libroOtmService;
	
	@Autowired
	private IAutorOtmService autorOtmService;
	
	@Autowired
	private ILibroAutorService libroAutorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. Insertar un libro que tiene dos autores
		
		LibroOTM libro1 = new LibroOTM();
		libro1.setTitulo("Noches Blancas");
		libro1.setCantidadPaginas(350);
		this.libroOtmService.insertar(libro1);
		
		AutorOTM autor1 = new AutorOTM();
		autor1.setNombre("John Green");
		this.autorOtmService.insertar(autor1);
		
		AutorOTM autor2 = new AutorOTM();
		autor2.setNombre("Lauren Myracle");
		this.autorOtmService.insertar(autor2);
		
		Libro_Autor libro_Autor1 = new Libro_Autor();
		libro_Autor1.setLibro(libro1);
		libro_Autor1.setAutor(autor1);
		this.libroAutorService.insertar(libro_Autor1);
		
		Libro_Autor libro_Autor2 = new Libro_Autor();
		libro_Autor2.setLibro(libro1);
		libro_Autor2.setAutor(autor2);
		this.libroAutorService.insertar(libro_Autor2);
		
		// 2. Insertar un autor que escribió dos libros
		
		LibroOTM libro2 = new LibroOTM();
		libro2.setTitulo("Sentido y Sensibilidad");
		libro2.setCantidadPaginas(320);
		this.libroOtmService.insertar(libro2);
		
		LibroOTM libro3 = new LibroOTM();
		libro3.setTitulo("Orgullo y Prejuicio");
		libro3.setCantidadPaginas(460);
		this.libroOtmService.insertar(libro3);
		
		AutorOTM autor3 = new AutorOTM();
		autor3.setNombre("Jane Austen");
		this.autorOtmService.insertar(autor3);
		
		Libro_Autor libro_Autor3 = new Libro_Autor();
		libro_Autor3.setLibro(libro2);
		libro_Autor3.setAutor(autor3);
		this.libroAutorService.insertar(libro_Autor3);
		
		Libro_Autor libro_Autor4 = new Libro_Autor();
		libro_Autor4.setLibro(libro3);
		libro_Autor4.setAutor(autor3);
		this.libroAutorService.insertar(libro_Autor4);

	}

}
