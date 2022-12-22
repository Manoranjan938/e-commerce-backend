package com.example.eCommDemo.response;

public class InvalidLoginResponse {

	private String message;

	public InvalidLoginResponse() {
		this.message = "Invalid Credentials";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
