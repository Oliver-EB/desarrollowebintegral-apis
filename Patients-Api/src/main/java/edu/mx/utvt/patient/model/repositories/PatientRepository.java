package edu.mx.utvt.patient.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import edu.mx.utvt.patient.model.dtos.PatientMasterDataDto;
import edu.mx.utvt.patient.model.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	public Optional<PatientMasterDataDto> findByEmail(String email);
	
	public Optional<PatientMasterDataDto> findByRfc(String rfc);
	
	public List<PatientMasterDataDto> findByLastName(String lastName);

}
