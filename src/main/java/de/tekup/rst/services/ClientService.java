package de.tekup.rst.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.ClientReqDTO;
import de.tekup.rst.dto.models.ClientResDTO;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
	
	private ClientRepository clientRepository;
	private ModelMapper mapper = new ModelMapper();

	
	public ClientResDTO saveToDB(ClientReqDTO clientReqDTO) {
		ClientEntity clientEntity = mapper.map(clientReqDTO, ClientEntity.class);
		/*
		 * ClientEntity clientEntity = new ClientEntity();
		 * clientEntity.setNom(clientReqDTO.getNom());
		 * clientEntity.setPrenom(clientReqDTO.getPrenom());
		 * clientEntity.setDateDeNaissance(clientReqDTO.getDateDeNaissance());
		 * clientEntity.setCourriel(clientReqDTO.getCourriel());
		 * clientEntity.setTelephone(clientReqDTO.getTelephone());
		 */
		clientRepository.save(clientEntity);
		
		/*
		 * ClientResDTO clientResDTO = new ClientResDTO();
		 * clientResDTO.setId(clientEntity.getId());
		 * clientResDTO.setNomComplet(clientEntity.getPrenom()+" "+clientEntity.getNom()
		 * ); clientResDTO.setAge((int)ChronoUnit.YEARS.between(clientEntity.
		 * getDateDeNaissance(), LocalDate.now()));
		 */
		
		ClientResDTO clientResDTO = mapper.map(clientEntity, ClientResDTO.class);
		return clientResDTO;
	}
	
	public List<ClientResDTO> getAllClient(){
		log.info("call DB clients"); 
		return clientRepository.findAll().stream()
		.map(cl-> mapper.map(cl, ClientResDTO.class))
		.collect(Collectors.toList());
	}

}
