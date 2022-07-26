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
@Table(name = "autor_otm")
public class AutorOTM {

	@Id
	@Column(name = "auto_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_otm_id_seq")
	@SequenceGenerator(name = "auto_otm_id_seq", sequenceName = "auto_otm_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "auto_nombre")
	private String nombre;

	@OneToMany(mappedBy = "autor")
	private List<Libro_Autor> libros;

	// Sey Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro_Autor> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro_Autor> libros) {
		this.libros = libros;
	}

}
