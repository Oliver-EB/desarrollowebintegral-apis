package edu.mx.utvt.patient.model.dtos;

import java.util.Date;

public interface PatientMasterDataDto {
	
	public Long getId();

	public String getFirstName();

	public String getLastName();

	public String getBloodType();
	
	public Date getBirthDate();
}
