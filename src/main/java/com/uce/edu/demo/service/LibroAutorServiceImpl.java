package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroAutorRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro_Autor;

@Service
public class LibroAutorServiceImpl implements ILibroAutorService {

	@Autowired
	private ILibroAutorRepository libroAutorRepository;

	@Override
	public void insertar(Libro_Autor libro_Autor) {
		this.libroAutorRepository.crear(libro_Autor);
	}

}
