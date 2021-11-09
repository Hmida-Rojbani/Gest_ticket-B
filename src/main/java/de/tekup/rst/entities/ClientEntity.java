package de.tekup.rst.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String nom;
	
	private String prenom;
	
	private LocalDate dateDeNaissance;
	@Column(unique = true, nullable = false)
	private String courriel;
	
	private String telephone;
	
	@OneToMany(mappedBy = "client")
	private List<TicketEntity> tickets;

}
