package com.uce.edu.demo.repository.modelo.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro_autor_otm")
public class Libro_Autor {
	
	@Id
	@Column(name = "liau_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liau_id_seq")
	@SequenceGenerator(name = "liau_id_seq", sequenceName = "liau_id_seq", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "liau_id_autor")
	private AutorOTM autor;
	
	@ManyToOne
	@JoinColumn(name = "liau_id_libro")
	private LibroOTM libro;

	// Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AutorOTM getAutor() {
		return autor;
	}

	public void setAutor(AutorOTM autor) {
		this.autor = autor;
	}

	public LibroOTM getLibro() {
		return libro;
	}

	public void setLibro(LibroOTM libro) {
		this.libro = libro;
	}

}
