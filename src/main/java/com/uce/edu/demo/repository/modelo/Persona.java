package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@Column(name = "pers_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	@SequenceGenerator(name = "name_generator", sequenceName = "pers_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "pers_cedula")
	private String cedula;

	@Column(name = "pers_nombre")
	private String nombre;

	@Column(name = "pers_apellido")
	private String apellido;

	@Column(name = "pers_genero")
	private String genero;

	@Override
	public String toString() {
		return "Persona [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", genero=" + genero + "]";
	}

	// Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
