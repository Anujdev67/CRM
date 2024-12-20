package com.springboot.CRM.exception;

public class ResourceNotFoundException extends Exception{


	private static final long serialVersionUID = 1L;
	
	private String msg;

	public String getMsg() {
		return msg;
	}
	public ResourceNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
