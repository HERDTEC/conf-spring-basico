package com.next.pibelnext;

public class Administrator {
	private int idAdministrator;
	private String name;
	
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
		return "Administrator [idAdministrator=" + idAdministrator + ", name=" + name + "]";
	}


	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
