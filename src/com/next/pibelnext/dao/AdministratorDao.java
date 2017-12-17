package com.next.pibelnext.dao;
import java.util.List;

import com.next.pibelnext.pojo.Administrator;
public interface AdministratorDao {
	public boolean save(Administrator admin);
	public boolean update(Administrator admin);
	public boolean delete(int idAdminitrator);
	public List<Administrator> findAll();
	public Administrator findById(int idAdministrator);
	public List<Administrator> findByName(String name);
}
