package com.next.pibelnext.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Adress {
	private String road;
	private String zip;
	
	public Adress() {
		
	}

	public Adress(String road, String zip) {
		this.road = road;
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Adress [road=" + road + ", zip=" + zip + "]";
	}
	@Autowired
	public void setRoad(@Value("road")String road) {
		this.road = road;
	}
	@Autowired
	public void setZip(@Value("99999")String zip) {
		this.zip = zip;
	}
	
	
}
