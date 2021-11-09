package de.tekup.rst.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TicketEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	private LocalDateTime dateTime;
	
	private int nbCouvert;
	
	private double addition;
	
	@ManyToOne
	private ClientEntity client;
	
	@ManyToOne
	private TableEntity table;
	
	@ManyToMany
	@JoinTable(name = "compose")
	private List<MetEntity> mets=new ArrayList<>();
	
	

}
