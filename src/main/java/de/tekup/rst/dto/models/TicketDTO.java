package de.tekup.rst.dto.models;

import lombok.Data;

@Data
public class TicketDTO {
	
	private Integer clientId;
	
	private Long tableNumero;
	
	private Integer[] metsIds;
	
	private int nbCouvert;

}
