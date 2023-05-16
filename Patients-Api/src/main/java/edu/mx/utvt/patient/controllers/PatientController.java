package edu.mx.utvt.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mx.utvt.patient.model.dtos.PatientBasicDataDto;
import edu.mx.utvt.patient.model.dtos.PatientMasterDataDto;
import edu.mx.utvt.patient.model.entities.Patient;
import edu.mx.utvt.patient.model.services.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<PatientBasicDataDto>> findAll() {
		return ResponseEntity.ok().body(patientService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Patient> save(@RequestBody Patient patient) {
		return ResponseEntity.created(null).body(this.patientService.save(patient));
	}
	
	@GetMapping("/all/lastname/{lastName}")
	public List<PatientMasterDataDto> findAllByLastName(@PathVariable String lastName) {
		return this.patientService.findAllByLastName(lastName);
	}
	

}
