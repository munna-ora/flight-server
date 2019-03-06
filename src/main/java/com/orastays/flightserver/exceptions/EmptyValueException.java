package com.orastays.flightserver.exceptions;

public class EmptyValueException extends Exception {

	private static final long serialVersionUID = 8262456793170654369L;
	
	private String name;

	public EmptyValueException(String name) {
		super(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}