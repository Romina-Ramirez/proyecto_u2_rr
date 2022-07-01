package com.uce.edu.demo.estudiante.to;

public class EstudianteTo {

	private String id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;

	// Método toString
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}

	// Constructor por defecto
	public EstudianteTo() {

	}

	// Constructor con parámetros
	public EstudianteTo(String id, String nombre, String apellido, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	// Set y Get
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
