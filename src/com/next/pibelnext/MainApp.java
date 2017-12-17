package com.next.pibelnext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.next.pibelnext.dao.AdministratorDao;
import com.next.pibelnext.pojo.Administrator;

public class MainApp {
	public static void main(String[]  args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.config.xml");
		AdministratorDao adminDao = (AdministratorDao) applicationContext.getBean("administratorDao");
		Timestamp ts = new Timestamp(new Date().getTime());
		Administrator admin = new Administrator();
		admin.setName("paul");
		admin.setWorkRole("root");
		admin.setCreationDate(ts);
		
		 
			
		
		try {
			adminDao.save(admin);
			admin.setIdAdministrator(1);
			admin.setName("pedro");
			adminDao.update(admin);
			adminDao.delete(2);
			List<Administrator> admins= adminDao.findAll(); 
			for(Administrator adm : admins) {
				System.out.println(adm);
			}
			System.out.println("Otras funciones de busqueda:");
			System.out.println(adminDao.findById(1));
			System.out.println(adminDao.findByName("paul").toString());
			
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext)applicationContext).close();
	}

}
