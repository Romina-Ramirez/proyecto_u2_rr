package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	public void crear(Estudiante e);

	public Estudiante leer(Integer id);
	
	public Estudiante leerPorNombreTelefonoTyped(String nombre, String telefono);
	
	public List<Estudiante> leerPorApellidoDescTyped(String apellido);
	
	public List<Estudiante> leerPorApellidoDireccionNamed(String apellido, String direccion);
	
	public Estudiante leerPorApellidoTelefonoNamed(String apellido, String telefono);
	
	public List<Estudiante> leerPorNombreComienzaLetraTypedNamed(String letra);
	
	public List<Estudiante> OrdenarPorNombreApellidoAscTypedNamed();

	public void actualizar(Estudiante e);
	
	public void eliminar(Integer id);

}
