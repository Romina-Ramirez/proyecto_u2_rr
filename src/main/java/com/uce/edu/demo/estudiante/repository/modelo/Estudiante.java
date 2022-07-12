package com.uce.edu.demo.estudiante.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")

@NamedQuery(name = "Estudiante.buscarPorApellidoDireccion", query = "SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.direccion = :datoDireccion")
@NamedQuery(name = "Estudiante.buscarPorApellidoTelefono", query = "SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.telefono = :datoTelefono")
@NamedQuery(name = "Estudiante.buscarPorNombreComienzaLetra", query = "SELECT e FROM Estudiante e WHERE e.nombre LIKE :Letra")
@NamedQuery(name = "Estudiante.OrdenarPorNombreApellidoAsc", query = "SELECT e FROM Estudiante e ORDER BY e.nombre, e.apellido")

public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	@SequenceGenerator(name = "name_generator", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_direccion")
	private String direccion;

	@Column(name = "estu_telefono")
	private String telefono;

	// Método toString
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}

	// Set y Get
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
