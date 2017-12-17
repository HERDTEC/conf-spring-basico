package com.next.pibelnext.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.next.pibelnext.pojo.Administrator;
import com.next.pibelnext.pojo.AdministratorRowMapper;

@Component("administratorDao")
public class AdministratorDaoImpl implements AdministratorDao {
	//evitar inyeccion sql
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new  NamedParameterJdbcTemplate(dataSource);
	} 
	@Override
	public boolean save(Administrator admin) {
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("name", admin.getName());
//		paramMap.addValue("workRole", admin.getWorkRole());
//		paramMap.addValue("creationDate", admin.getCreationDate());
//		
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.
				update("insert into Administrator(name, workRole, creationDate) values(:name, :workRole, :creationDate)", paramMap)==1;
	}
	@Override
	public List<Administrator> findAll() {
		return jdbcTemplate.query("select * from administrator", new AdministratorRowMapper());
	}
	@Override
	public Administrator findById(int idAdminitrator) {
//		return (Administrator) jdbcTemplate.query("select * from administrator where id = :id", 
//				new MapSqlParameterSource("id", idAdminitrator), 
//				new AdministratorRowMapper());
		return jdbcTemplate.queryForObject("select * from administrator where idAdministrator = :id", new MapSqlParameterSource("id", idAdminitrator), new AdministratorRowMapper());
	}
	@Override
	public List<Administrator> findByName(String name) {
		return jdbcTemplate.query("select * from administrator where name like :name",
											new MapSqlParameterSource("name", "%"+name+"%"),
										    new AdministratorRowMapper());
		
	}
	@Override
	public boolean update(Administrator admin) {
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.
				update("update Administrator set name= :name, workRole= :workRole, creationDate= :creationDate where idAdministrator= :idAdministrator", paramMap)==1;
	}
	@Override
	public boolean delete(int idAdministrator) {
		return jdbcTemplate.update("delete from administrator where idAdministrator= :idAdministrator",
				new MapSqlParameterSource("idAdministrator", idAdministrator))==1;
	}
}
