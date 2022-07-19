package com.uce.edu.demo.estudiante.repository.modelo;

import java.io.Serializable;

public class EstudianteContadorSemestre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int semestre;
	private String genero;
	private Long contador;

	public EstudianteContadorSemestre() {

	}

	public EstudianteContadorSemestre(int semestre, String genero, Long contador) {
		this.semestre = semestre;
		this.genero = genero;
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "EstudianteContadorSemestre [semestre=" + semestre + ", genero=" + genero + ", contador=" + contador
				+ "]";
	}

	// Set y Get
	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getContador() {
		return contador;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}

}
