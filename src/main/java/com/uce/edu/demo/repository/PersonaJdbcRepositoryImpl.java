package com.uce.edu.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.PersonaTo;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crear(PersonaTo p) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("INSERT INTO persona (id, nombre, apellido) VALUES (?, ?, ?)",
				new Object[] { p.getId(), p.getNombre(), p.getApellido() });
	}

	@Override
	public PersonaTo leer(int cedula) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("SELECT * FROM persona WHERE id=?", new Object[] { cedula },
				new BeanPropertyRowMapper<PersonaTo>(PersonaTo.class));
	}

	@Override
	public void actualizar(PersonaTo p) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("UPDATE persona SET nombre=?, apellido=? WHERE id=?",
				new Object[] { p.getNombre(), p.getApellido(), p.getId() });
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("DELETE FROM persona WHERE id=?", new Object[] { cedula });
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query("SELECT * FROM persona ORDER BY id DESC", new PersonaRowMapper());
	}
	
	class PersonaRowMapper implements RowMapper<PersonaTo> {

		@Override
		public PersonaTo mapRow(ResultSet rs, int rowNum) throws SQLException {
			PersonaTo persona = new PersonaTo();
			persona.setId(rs.getInt("id"));
			persona.setNombre(rs.getString("nombre"));
			persona.setApellido(rs.getString("apellido"));
			return persona;
		}
		
	}

}
