package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroOtmRepository;
import com.uce.edu.demo.repository.modelo.manytomany.LibroOTM;

@Service
public class LibroOtmServiceImpl implements ILibroOtmService{

	@Autowired
	private ILibroOtmRepository libroOtmRepository;
	
	@Override
	public void insertar(LibroOTM libro) {
		this.libroOtmRepository.crear(libro);
	}

}
