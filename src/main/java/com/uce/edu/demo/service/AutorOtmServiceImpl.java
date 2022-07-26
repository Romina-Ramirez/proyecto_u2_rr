package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAutorOtmRepository;
import com.uce.edu.demo.repository.modelo.manytomany.AutorOTM;

@Service
public class AutorOtmServiceImpl implements IAutorOtmService {

	@Autowired
	private IAutorOtmRepository autorOtmRepository;

	@Override
	public void insertar(AutorOTM autor) {
		this.autorOtmRepository.crear(autor);
	}

}
