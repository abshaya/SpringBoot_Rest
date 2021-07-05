package com.javatpoint.server.main;

public class HelloWorldBean {
	
	private String message;
	
	private String name;

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "Noor";
	}

	public void setMessage(String message) {
		System.out.print(message+"message");
		this.message = "Noor";
	}

	public HelloWorldBean(String string) {
		this.message=string;  
	}
	
	@Override  
	//generate toString  
	public String toString()   
	{  
		System.out.print(message+"message");
	return String.format ("HelloWorldBean [message=%s]", message);  
	}  

}
