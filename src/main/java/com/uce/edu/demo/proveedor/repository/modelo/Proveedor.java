package com.uce.edu.demo.proveedor.repository.modelo;

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
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@Column(name = "prov_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prov_id_seq")
	@SequenceGenerator(name = "prov_id_seq", sequenceName = "prov_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "prov_nombre")
	private String nombre;

	@Column(name = "prov_direccion")
	private String direccion;

	@Column(name = "prov_tipo")
	private String tipo;

	@OneToMany(mappedBy = "proveedor")
	private List<Producto> productos;

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tipo=" + tipo + "]";
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
