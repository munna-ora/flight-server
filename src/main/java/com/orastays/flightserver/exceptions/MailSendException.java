package com.orastays.flightserver.exceptions;

public class MailSendException extends Exception {

	private static final long serialVersionUID = 3560105055839732057L;
	
	private String name;

	public MailSendException(String name) {
		super(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}