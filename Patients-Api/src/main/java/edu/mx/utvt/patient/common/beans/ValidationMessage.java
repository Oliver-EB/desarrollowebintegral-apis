package edu.mx.utvt.patient.common.beans;

public class ValidationMessage {
	
	private String className;
	private String property;
	private String message;
	
	public ValidationMessage() {
		// TODO Auto-generated constructor stub
	}

	public ValidationMessage(String className, String property, String message) {
		super();
		this.className = className;
		this.property = property;
		this.message = message;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
