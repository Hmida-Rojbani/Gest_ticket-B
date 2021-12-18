package de.tekup.rst.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.tekup.rst.services.ClientService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ClientCtrlVue {
	
	private ClientService clientService;
	
	@GetMapping("/clients/show")
	public String getShowClient(Model model) {
		model.addAttribute("listClient", clientService.getAllClient());
		return "clients/show-client";
	}

}
