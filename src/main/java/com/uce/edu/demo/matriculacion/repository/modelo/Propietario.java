package com.uce.edu.demo.matriculacion.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "propietario")
	private List<Matricula> matriculas;

	@Override
	public String toString() {
		return "Propietario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", matriculas="
				+ matriculas + "]";
	}

	// Set y Get
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

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

}
