package com.anubratads.dsmqserver.model;

public class Message {

	private String message;

	public Message() {
		super();
		this.message = "";
	}

	public Message(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
