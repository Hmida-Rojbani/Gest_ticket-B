package de.tekup.rst.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.TicketDTO;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.TableEntity;
import de.tekup.rst.entities.TicketEntity;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import de.tekup.rst.repositories.TableRepository;
import de.tekup.rst.repositories.TicketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketService {
	
	private TicketRepository ticketRepository;
	private ClientRepository clientRepository;
	private TableRepository tableRepository;
	private MetRepository metRepository;
	//double addition;
	
	public double createTicket(TicketDTO ticketDTO) {
		
		ClientEntity clientEntity = clientRepository
				.findById(ticketDTO.getClientId()).get();
		TableEntity tableEntity = tableRepository
				.findById(ticketDTO.getTableNumero()).get();
		
		List<MetEntity> metEntities = metRepository
				.findAllById(Arrays.asList(ticketDTO.getMetsIds()));
		
		 double addition= metEntities.stream()
				 	.mapToDouble(met -> met.getPrix())
				 	.sum()+
				 tableEntity.getSupplement();
		
//		for (MetEntity metEntity : metEntities) {
//			addition += metEntity.getPrix();
//		}
		
		//metEntities.forEach(met -> 	addition += met.getPrix());
		
		 TicketEntity ticketEntity = new TicketEntity();
		 
		 ticketEntity.setClient(clientEntity);
		 ticketEntity.setTable(tableEntity);
		 ticketEntity.setMets(metEntities);
		 ticketEntity.setAddition(addition);
		 ticketEntity.setNbCouvert(ticketDTO.getNbCouvert());
		 ticketEntity.setDateTime(LocalDateTime.now());
		 
		 ticketRepository.save(ticketEntity);
		 
		return addition;
	}

}
