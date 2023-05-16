package edu.mx.utvt.patient.model.dtos;

public class PatientBasicDataDto {
	
	public Long id;
	public String firstName;
	public String lastName;
	
	public PatientBasicDataDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PatientBasicDataDto(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}		
	
}
