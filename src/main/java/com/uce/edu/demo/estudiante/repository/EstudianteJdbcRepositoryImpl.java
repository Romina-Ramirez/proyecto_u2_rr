package com.uce.edu.demo.estudiante.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {

	private static final Logger logger = Logger.getLogger(EstudianteJdbcRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crear(EstudianteTo e) {
		// TODO Auto-generated method stub
		logger.info("Se agregó a la base de datos el estudiante: " + e);
		this.jdbcTemplate.update(
				"INSERT INTO estudiante (id, nombre, apellido, direccion, telefono) VALUES (?, ?, ?, ?, ?)",
				new Object[] { e.getId(), e.getNombre(), e.getApellido(), e.getDireccion(), e.getTelefono() });
	}

	@Override
	public EstudianteTo leer(String id) {
		// TODO Auto-generated method stub
		logger.info("Se buscó el estudiante con: " + id);
		return this.jdbcTemplate.queryForObject("SELECT * FROM estudiante WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void actualizar(EstudianteTo e) {
		// TODO Auto-generated method stub
		logger.info("Se actualizó el estudiante: " + e);
		this.jdbcTemplate.update("UPDATE estudiante SET nombre=?, apellido=?, direccion=?, telefono=? WHERE id=?",
				new Object[] { e.getNombre(), e.getApellido(), e.getDireccion(), e.getTelefono(), e.getId() });
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		logger.info("Se eliminó el estudiante con id: " + id);
		this.jdbcTemplate.update("DELETE FROM estudiante WHERE id=?", new Object[] { id });
	}

}
