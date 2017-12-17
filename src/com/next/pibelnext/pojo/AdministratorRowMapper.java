package com.next.pibelnext.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdministratorRowMapper implements RowMapper<Administrator> {
	@Override
	public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException {
		Administrator admin  = new Administrator();
		admin.setIdAdministrator(rs.getInt("idAdministrator")); 
		admin.setWorkRole(rs.getString("workRole"));
		admin.setName(rs.getString("name"));
		admin.setCreationDate(rs.getTimestamp("creationDate"));
		return admin;
	}
}
