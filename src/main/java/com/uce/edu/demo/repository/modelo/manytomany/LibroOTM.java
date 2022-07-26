package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro_otm")
public class LibroOTM {

	@Id
	@Column(name = "libr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr_otm_id_seq")
	@SequenceGenerator(name = "libr_otm_id_seq", sequenceName = "libr_otm_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "libr_titulo")
	private String titulo;

	@Column(name = "libr_paginas")
	private Integer cantidadPaginas;

	@OneToMany(mappedBy = "libro")
	private List<Libro_Autor> autores;

	// Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public List<Libro_Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Libro_Autor> autores) {
		this.autores = autores;
	}

}
