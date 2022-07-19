package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class PersonaContadorGenero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String genero;
	private Long contador;

	public PersonaContadorGenero() {

	}

	public PersonaContadorGenero(String genero, Long contador) {
		this.genero = genero;
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "PersonaContadorGenero [genero=" + genero + ", contador=" + contador + "]";
	}

	// Set y Get
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
