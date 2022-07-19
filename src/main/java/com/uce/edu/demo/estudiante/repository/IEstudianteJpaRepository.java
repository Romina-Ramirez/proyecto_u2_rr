package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;

public interface IEstudianteJpaRepository {

	public void crear(Estudiante e);

	public Estudiante leer(Integer id);

	public Estudiante leerPorNombreTelefonoTyped(String nombre, String telefono);

	public List<Estudiante> leerPorApellidoDescTyped(String apellido);

	public List<Estudiante> leerPorApellidoDireccionNamed(String apellido, String direccion);

	public Estudiante leerPorApellidoTelefonoNamed(String apellido, String telefono);

	public List<Estudiante> leerPorNombreComienzaLetraTypedNamed(String letra);

	public List<Estudiante> OrdenarPorNombreApellidoAscTypedNamed();

	public List<Estudiante> leerPorGeneroNative(String genero);

	public List<Estudiante> leerPorSemestreNative(Integer semestre);

	public List<Estudiante> leerPorApellidoComienzaLetraNamedNative(String letra);

	public List<Estudiante> leerPorSemestreGeneroNamedNative(Integer semestre, String genero);
	
	public List<Estudiante> leerPorApellidoCriteriaApi(String apellido);
	
	public List<Estudiante> leerDinamicamente(Integer semestre, String nombre, String apellido, String cedula);
	
	public List<EstudianteSencillo> leerPorGeneroSencillo(String genero);

	public List<EstudianteContadorSemestre> leerEstudiantesContadorSemestre(String genero);

	public void actualizar(Estudiante e);

	public void eliminar(Integer id);

}
