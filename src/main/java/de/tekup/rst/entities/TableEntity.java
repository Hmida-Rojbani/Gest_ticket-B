package de.tekup.rst.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class TableEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	private int nbCouverts;
	@Enumerated(EnumType.STRING)
	private TableType type;
	
	private double supplement;

}
