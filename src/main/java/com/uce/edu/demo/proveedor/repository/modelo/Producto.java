package com.uce.edu.demo.proveedor.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
	@SequenceGenerator(name = "prod_id_seq", sequenceName = "prod_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_tipo")
	private String tipo;

	@Column(name = "prod_fecha_caducidad")
	private LocalDateTime fechaCaducidad;

	@Column(name = "prod_cantidad")
	private Integer cantidad;

	@Column(name = "prod_precio")
	private BigDecimal precio;

	@ManyToOne
	@JoinColumn(name = "prod_id_prov")
	private Proveedor proveedor;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaCaducidad=" + fechaCaducidad
				+ ", cantidad=" + cantidad + ", precio=" + precio + "]";
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
