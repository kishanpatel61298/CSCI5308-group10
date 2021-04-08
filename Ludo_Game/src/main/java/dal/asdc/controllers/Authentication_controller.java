package dal.asdc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import dal.asdc.model.Player;

public class Authentication_controller {
	@PostMapping("/process_register")
	public String login(@RequestBody Player player) {
		//Player_dao.save_record(player);
		System.out.print(player);
		return "ticket booked : " + player;
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new Player());	     
	    return "register_form";
	}
}
