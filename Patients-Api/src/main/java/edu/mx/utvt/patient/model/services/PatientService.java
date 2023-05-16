package edu.mx.utvt.patient.model.services;

import java.io.Serializable;
import java.util.List;

import edu.mx.utvt.patient.model.dtos.PatientBasicDataDto;
import edu.mx.utvt.patient.model.dtos.PatientMasterDataDto;
import edu.mx.utvt.patient.model.entities.Patient;



public interface PatientService extends Serializable {
	
	public List<PatientBasicDataDto> getAll();
	
	public Patient save(Patient patient);
	
	public List<PatientMasterDataDto> findAllByLastName(String lastName);

}
