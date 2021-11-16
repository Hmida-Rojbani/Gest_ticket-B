package de.tekup.rst.dto.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClientReqDTO {
	
	@NotBlank(message = "Nom est vide ")
	@Size(min = 3, max = 50)
	private String nom;
	@NotBlank(message = "Prenom est vide ")
	@Size(min = 3, max = 50)
	private String prenom;
	
	@Past
	private LocalDate dateDeNaissance;
	@Email
	private String courriel;
	@Pattern(regexp = "^[0-9]{8}$")
	private String telephone;
	
	
	/*
	 * public void setDateDeNaissance(String date) { dateDeNaissance=
	 * LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")); }
	 */

}
