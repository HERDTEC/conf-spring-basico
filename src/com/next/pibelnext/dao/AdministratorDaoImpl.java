package com.next.pibelnext.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.next.pibelnext.pojo.Administrator;

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
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", admin.getName());
		paramMap.addValue("workRole", admin.getWorkRole());
		paramMap.addValue("creationDate", admin.getCreationDate());
		
		return jdbcTemplate.
				update("insert into Administrator(name, workRole, creationDate) values(:name, :workRole, :creationDate)", paramMap)==1;
	}
	@Override
	public List<Administrator> findAll() {
		return jdbcTemplate.query("select * from administrator", new RowMapper<Administrator>() {

			@Override
			public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException {
				Administrator admin  = new Administrator();
				admin.setIdAdministrator(rs.getInt("idAdministrator"));
				admin.setWorkRole(rs.getString("workRole"));
				admin.setName(rs.getString("name"));
				admin.setCreationDate(rs.getTimestamp("creationDate"));
				return admin;
			}
			
		});
	}
}
