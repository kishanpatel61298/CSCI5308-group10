package dal.asdc.controllers;

import java.util.Collection;
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

import dal.asdc.dao.Player_dao;
import dal.asdc.ludo_board_structure.Ludo_board_formation;
import dal.asdc.ludo_menu.Dashboard_menu;
import dal.asdc.model.Main_menu;
import dal.asdc.model.Player;
import dal.asdc.tournament.Groups;
import dal.asdc.model.Dash_menu;
import dal.asdc.model.Game_menu;

@Controller
public class Menu_controller {

	Dashboard_menu dash_menu = new Dashboard_menu();
	Ludo_board_formation l_board = new Ludo_board_formation();
	private Player_dao plyr_dao = new Player_dao();
	private Groups grps = new Groups();

	@Autowired
	Main_menu m_menu;

	@Autowired
	Dash_menu ds_menu;

	@Autowired
	Game_menu gm_menu;

	@RequestMapping(value = "/")
	public String menu(Model model) {
		model.addAttribute("Main_menu", m_menu);
		return "Menu_display.jsp";
	}

	@RequestMapping(value = "/d_menu", method = RequestMethod.POST)
	public String dash_menu(@RequestParam("sel_menu") String smenu, Model model) {
		model.addAttribute("Dash_menu", ds_menu);
		model.addAttribute("smenu", smenu);
		return "Dashboard_menu.jsp";
	}

	@RequestMapping(value = "/dash_menu", method = RequestMethod.POST)
	public String decide_dash_menu(@RequestParam("dash_menu") String dmenu, Model model) {
		model.addAttribute("dash_menu", dmenu);
		model.addAttribute("Game_menu", gm_menu);
		String decide_dash = dash_menu.decide_dashboard_menu_page(Integer.parseInt(dmenu));
		return decide_dash;
	}

	@RequestMapping(value = "/game_menu", method = RequestMethod.POST)
	public String decide_game_menu(@RequestParam("game_menu") int gmenu, Model model) {
		model.addAttribute("gamemenu", gmenu);
		l_board.add_game_type(gmenu);
		return "ludo_board.jsp";
	}

	@GetMapping("/register")
	public String show_registration_form(Model model) {
		Player user = new Player();
		model.addAttribute("user", user);
		return "register_form.jsp";
	}

	@GetMapping("/login")
	public String show_login_form(Model model) {
		Player user = new Player();
		model.addAttribute("user", user);
		return "login_form.jsp";
	}

	@PostMapping("/process_register")
	public String processRegister(@ModelAttribute("user") Player player) {
		plyr_dao.save_record(player);
		return "login_form.jsp";
	}

	@PostMapping("/process_login")
	public String process_login(@ModelAttribute("user") Player player, Model model) {
		Player fatched_player = new Player();
		fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
		if (fatched_player != null && fatched_player.getPlayer_password().equals(player.getPlayer_password())) {
			model.addAttribute("Main_menu", m_menu);
			return "Menu_display.jsp";
		} else {
			return "error_page.jsp";
		}
	}

	@GetMapping("/start_tournament")
	public String start_tournament(Model model) {
		int no_of_players = 0;
		model.addAttribute("no_of_players", no_of_players);
		Map<Integer, Collection<List<Player>>> players_map = grps.form_tournaments_group();
		if(players_map != null) {
			return "error_page.jsp";
		}
		else {
			return "error_page.jsp";
		}
	}

	@PostMapping("/show_player_list")
	public String show_player_list(@RequestParam("no_of_players") int no_of_players, Model model) {
		System.out.println(no_of_players);
		return "player_list.jsp";
	}
}
