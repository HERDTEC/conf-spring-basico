package com.next.pibelnext;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrator {
	private int idAdministrator;
	private String name;
	@Autowired
	private Adress adress;
	
	public Administrator(int idAdministrator, String name) {
		this.idAdministrator = idAdministrator;
		this.name = name;
	}
	
	public Administrator() {
		
	}

	public void printDirection() {
		 System.out.println("Encino 1000");
	}


	@Override
	public String toString() {
		return "Administrator [idAdministrator=" + idAdministrator + ", name=" + name + ", adress=" + adress + "]";
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
