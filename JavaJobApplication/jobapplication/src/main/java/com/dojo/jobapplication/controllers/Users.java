package com.dojo.jobapplication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojo.jobapplication.models.User;
import com.dojo.jobapplication.services.UserService;

@Controller
public class Users {

	private final UserService userService;
	
	public Users(UserService userService) {
		
		this.userService = userService;
	}

	@RequestMapping("/")
	public String loginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@GetMapping("/registration_page")
	public String registrationPage(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/process_registration")
	public String process_registration(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		System.out.println("\n\n<<-------------Processing User Registration------------->>\n\n");
		
		System.out.println("First name: " + user.getFirstName());
		System.out.println("Last name: " + user.getLastName());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password: " + user.getPassword());
		
		if(result.hasErrors()) {
			System.out.println("Problem found in registration.");
			return "registration";
		}
		
		else {
			System.out.println("Registration Succesfull!");
			userService.createUser(user);
			session.setAttribute("firstName", user.getFirstName());
			session.setAttribute("id", user.getId());
			session.setAttribute("user", userService.findById(user.getId()));
			
			System.out.println("id created: " + session.getAttribute("id"));
			return "redirect:/dashboard";
		}	
	}
	
}
