package edu.mx.utvt.patient.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvt.patient.model.dtos.PatientBasicDataDto;
import edu.mx.utvt.patient.model.dtos.PatientMasterDataDto;
import edu.mx.utvt.patient.model.entities.Patient;
import edu.mx.utvt.patient.model.mappers.PatientBasicDataDtoMapper;
import edu.mx.utvt.patient.model.repositories.PatientRepository;

@Service
@Transactional(readOnly = true)
public class PatientServiceImplementation implements PatientService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8183413160667044589L;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientBasicDataDtoMapper patientBasicDataDtoMapper;

	@Override
	public List<PatientBasicDataDto> getAll() {
		return this.patientRepository.findAll().stream().map(patientBasicDataDtoMapper).toList();
	}

	@Transactional
	public Patient save(Patient patient) {
		return this.patientRepository.save(patient);
	}
	
	public List<PatientMasterDataDto> findAllByLastName(String lastName) {
		return this.patientRepository.findByLastName(lastName);		
	}

}
