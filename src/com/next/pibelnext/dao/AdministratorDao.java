package com.next.pibelnext.dao;
import java.util.List;

import com.next.pibelnext.pojo.Administrator;
public interface AdministratorDao {
	public boolean save(Administrator admin);
	public List<Administrator> findAll();
}
