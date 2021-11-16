package de.tekup.rst.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.services.MetService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mets")
public class MetController {
	
	private MetService metService;
	
	@PostMapping()
	public MetDTO addMet(@RequestBody MetDTO dto) {
		return metService.saveToDB(dto);
	}
	
	

}
