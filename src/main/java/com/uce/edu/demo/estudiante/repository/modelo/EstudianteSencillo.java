package com.uce.edu.demo.estudiante.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cedula;
	private String apellido;
	private int semestre;

	public EstudianteSencillo() {

	}

	public EstudianteSencillo(String cedula, String apellido, int semestre) {
		this.cedula = cedula;
		this.apellido = apellido;
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "EstudianteSencillo [cedula=" + cedula + ", apellido=" + apellido + ", semestre=" + semestre + "]";
	}

	// Set y Get
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

}
