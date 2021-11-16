package de.tekup.rst.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.entities.Dessert;
import de.tekup.rst.entities.Entree;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.repositories.MetRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MetService {
	
	private MetRepository metRepository;
	
	public MetDTO saveToDB(MetDTO dto) {
		ModelMapper mapper = new ModelMapper();
		MetEntity entity=null;
		switch (dto.getType()) {
		case "Plat": entity = mapper.map(dto, Plat.class);
			
			break;
			
		case "Entree": entity = mapper.map(dto, Entree.class);
		
		break;
		
		case "Dessert": entity = mapper.map(dto, Dessert.class);
		
		break;

		}
		
		entity = metRepository.save(entity);
		dto.setId(entity.getId());
		return dto;
	}
	
	

}
