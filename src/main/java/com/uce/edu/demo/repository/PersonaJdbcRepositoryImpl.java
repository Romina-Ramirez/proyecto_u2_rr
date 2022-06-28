package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Persona;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crear(Persona p) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("INSERT INTO persona (id, nombre, apellido) VALUES (?, ?, ?)",
				new Object[] { p.getId(), p.getNombre(), p.getApellido() });
	}

	@Override
	public Persona leer(int cedula) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("SELECT * FROM persona WHERE id=?", new Object[] { cedula },
				new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("UPDATE persona SET nombre=?, apellido=? WHERE id=?",
				new Object[] { p.getNombre(), p.getApellido(), p.getId() });
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("DELETE FROM persona WHERE id=?", new Object[] { cedula });
	}

}
