package com.next.pibelnext;

public class Adress {
	private String road;
	private String zip;
	
	public Adress() {
		super();
	}

	public Adress(String road, String zip) {
		this.road = road;
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Adress [road=" + road + ", zip=" + zip + "]";
	}
	
	
}
