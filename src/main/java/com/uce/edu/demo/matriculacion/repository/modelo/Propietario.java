package com.uce.edu.demo.matriculacion.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "propietario")
public class Propietario {

	@Id
	@Column(name = "prop_celula")
	private String cedula;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	@Column(name = "prop_apellido")
	private String apellido;

	@Override
	public String toString() {
		return "Propietario [Nombre = " + nombre + ", Apellido = " + apellido + ", Cédula = " + cedula + "]";
	}

	// Set y Get
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
