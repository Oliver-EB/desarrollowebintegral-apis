package edu.mx.utvt.patient.model.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "te_patients", indexes = {
		@Index(columnList = "firstName"),
		@Index(columnList = "lastName")
		})
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Size(min = 2, max = 50)
	@NotNull(message = "It mustn't be null")
	@Column(length = 50)
	private String firstName;

	@Size(min = 5, max = 100)
	@NotNull(message = "It mustn't be null")
	@Column(length = 100)
	private String lastName;

	@NotNull(message = "It mustn't be null")
	private Date birthDate;

	@NotNull(message = "It mustn't be null")
	@Column(length = 3)
	private String bloodType;

	@NotNull(message = "It mustn't be null")
	@Column(length = 50, unique = true)
	@Email(regexp = ".+[@].+[\\.].+")
	private String email;
	
	@NotNull(message = "It mustn't be null")
	@Column(length = 13, unique = true)
	private String rfc;
	
	@CreatedDate
	@Column(nullable = false, insertable = false, updatable = false, columnDefinition = " DATETIME DEFAULT NOW()")
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdDate;
	
	@LastModifiedDate
	@Column(nullable = false, insertable = false, updatable = false, columnDefinition = " DATETIME DEFAULT NOW()")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	

}
