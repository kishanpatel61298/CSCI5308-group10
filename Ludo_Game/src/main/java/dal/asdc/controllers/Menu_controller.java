package dal.asdc.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dal.asdc.game_handler.Ludo_Game;
import dal.asdc.login_register.Login;
import dal.asdc.login_register.Register;
import dal.asdc.login_register.interfaces.ILogin;
import dal.asdc.login_register.interfaces.IRegister;
import dal.asdc.ludo_board_structure.Ludo_board_formation;
import dal.asdc.ludo_board_structure.Token_positions;
import dal.asdc.ludo_menu.Dashboard_menu;
import dal.asdc.model.Main_menu;
import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.tournament.Groups;
import dal.asdc.tournament.interfaces.IGroups;
import dal.asdc.model.Dash_menu;
import dal.asdc.model.Game_menu;
import dal.asdc.model.Game_token_positions;

@Controller
public class Menu_controller {
	
	Dashboard_menu dash_menu = new Dashboard_menu();
	private IGroups groups = new Groups();
	private ILogin login = new Login();
	private IRegister register = new Register();

	
	@Autowired
	Main_menu m_menu;
	
	@Autowired
	Dash_menu ds_menu;
	
	@Autowired
	Game_menu gm_menu;
	
	@RequestMapping(value = "/")
	public String menu(Model model) {
		return "start_page.jsp";
	}

	@RequestMapping(value="/d_menu", method=RequestMethod.POST)
	public String dash_menu(@RequestParam("sel_menu") String smenu, Model model) {
		model.addAttribute("Dash_menu", ds_menu);
		model.addAttribute("smenu", smenu);
		return "Dashboard_menu.jsp";
	}
	

	@RequestMapping(value="/dash_menu", method=RequestMethod.POST)
	public String decide_dash_menu(@RequestParam("dash_menu") String dmenu, Model model) {
		model.addAttribute("dash_menu", dmenu);
		model.addAttribute("Game_menu", gm_menu);
		String decide_dash = dash_menu.decide_dashboard_menu_page(Integer.parseInt(dmenu));
		return decide_dash;
	}
	
	@GetMapping("/register")
	public String show_registration_form(Model model) {
		IPlayer user = new Player();
		model.addAttribute("user", user);
		return "register_form.jsp";
	}

	@GetMapping("/login")
	public String show_login_form(Model model) {
		IPlayer user = new Player();
		model.addAttribute("user", user);
		return "login_form.jsp";
	}

	@PostMapping("/process_register")
	public String processRegister(@ModelAttribute("user") Player player) {
		boolean is_registerd = register.register(player);
		player.setPlayer_email(null);
		player.setPlayer_password(null);
		if(is_registerd) {
			return "login_form.jsp";
		}
		else {
			return "error_page.jsp";
		}
	}

	@PostMapping("/process_login")
	public String process_login(@ModelAttribute("user") Player player, Model model) {
		IPlayer fatched_player = login.login(player);
		if (fatched_player != null) {
			model.addAttribute("Main_menu", m_menu);
			return "Menu_display.jsp";
		} else {
			return "error_page.jsp";
		}
	}

	@GetMapping("/start_tournament")
	public String start_tournament(Model model) {
		int no_of_players = 0;
		Map<Integer, Collection<List<IPlayer>>> players_map = groups.form_tournaments_group();
		if(players_map != null) {
			model.addAttribute("Main_menu", m_menu);
			return "Menu_display.jsp";			
		}
		else {
			return "error_page.jsp";
		}
	}
	
}
