package com.next.pibelnext;

import java.sql.Timestamp;
import java.util.Date;

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
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext)applicationContext).close();
	}

}
