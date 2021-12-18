package de.tekup.rst.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.rst.security.entites.User;
import de.tekup.rst.security.services.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AuthCtrl {
	
	private UserService userService;
	
	@GetMapping("/register")
	public String getRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "auth/signup";
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute("user") User user) {
		userService.registerUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "auth/signin";
	}

}
