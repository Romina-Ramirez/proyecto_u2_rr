package com.uce.edu.demo.matriculacion.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@Column(name = "matr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	@SequenceGenerator(name = "name_generator", sequenceName = "matr_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "matr_fecha_matricula")
	private LocalDateTime fechaMatricula;

	@Column(name = "matr_valor_matricula")
	private BigDecimal valorMatricula;

	private Propietario propietario;

	private Vehiculo vehiculo;

	@Override
	public String toString() {
		return "Matrícula [Fecha de Matrícula = " + fechaMatricula + ", Valor de Matrícula = " + valorMatricula
				+ ", Propietario = " + propietario + ", Vehículo = " + vehiculo + "]";
	}

	// Set y Get
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
