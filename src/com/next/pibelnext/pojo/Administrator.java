package com.next.pibelnext.pojo;
import java.sql.Timestamp;

public class Administrator {
	private int idAdministrator;
	private String name;
	private String workRole;
	private Timestamp creationDate;

	@Override
	public String toString() {
		return "Administrator [idAdministrator=" + idAdministrator + ", name=" + name + ", workRole=" + workRole
				+ ", creationDate=" + creationDate + "]";
	}

	public int getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkRole() {
		return workRole;
	}

	public void setWorkRole(String workRole) {
		this.workRole = workRole;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	


	

}
