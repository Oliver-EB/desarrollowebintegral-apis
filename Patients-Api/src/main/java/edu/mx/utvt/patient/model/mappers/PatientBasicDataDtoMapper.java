package edu.mx.utvt.patient.model.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import edu.mx.utvt.patient.model.dtos.PatientBasicDataDto;
import edu.mx.utvt.patient.model.entities.Patient;

@Service
public class PatientBasicDataDtoMapper implements Function<Patient, PatientBasicDataDto> {

	@Override
	public PatientBasicDataDto apply(Patient patient) {
		return new PatientBasicDataDto(patient.getId(), 
				patient.getFirstName(), patient.getLastName());
	}

}
