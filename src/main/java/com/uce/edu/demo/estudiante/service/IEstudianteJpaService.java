package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaService {

	public void guardar(Estudiante e);

	public Estudiante buscarPorId(Integer id);

	public Estudiante buscarPorNombreTelefonoTyped(String nombre, String telefono);

	public List<Estudiante> buscarPorApellidoDescTyped(String apellido);

	public List<Estudiante> buscarPorApellidoDireccionNamed(String apellido, String direccion);

	public Estudiante buscarPorApellidoTelefonoNamed(String apellido, String telefono);

	public List<Estudiante> buscarPorNombreComienzaLetraTypedNamed(String letra);

	public List<Estudiante> OrdenarPorNombreApellidoAscTypedNamed();

	public List<Estudiante> buscarPorGeneroNative(String genero);

	public List<Estudiante> buscarPorSemestreNative(Integer semestre);

	public List<Estudiante> buscarPorApellidoComienzaLetraNamedNative(String letra);

	public List<Estudiante> buscarPorSemestreGeneroNamedNative(Integer semestre, String genero);

	public void actualizar(Estudiante e);

	public void eliminarPorId(Integer id);

}
