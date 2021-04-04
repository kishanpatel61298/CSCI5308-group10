package dal.asdc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dal.asdc.game_handler.Ludo_Game;
import dal.asdc.ludo_board_structure.Ludo_board_formation;
import dal.asdc.ludo_board_structure.Token_positions;
import dal.asdc.ludo_menu.Dashboard_menu;
import dal.asdc.model.Main_menu;
import dal.asdc.model.Dash_menu;
import dal.asdc.model.Game_menu;
import dal.asdc.model.Game_token_positions;

@Controller
public class Menu_controller {
	
	Dashboard_menu dash_menu = new Dashboard_menu();
	Ludo_board_formation l_board = new Ludo_board_formation();
	Ludo_Game ludo_game;
	
	@Autowired
	Main_menu m_menu;
	
	@Autowired
	Dash_menu ds_menu;
	
	@Autowired
	Game_menu gm_menu;
	
	@Autowired
	Game_token_positions gm_tk_pos;
		
	@RequestMapping(value = "/")
	public String menu(Model model) {
		model.addAttribute("Main_menu", m_menu);
		return "Menu_display.jsp";
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
	
	@RequestMapping(value="/game_menu", method=RequestMethod.POST)
	public String decide_game_menu(@RequestParam("game_menu") int gmenu, Model model) {
		model.addAttribute("gamemenu", gmenu);
		String type = l_board.add_game_type(gmenu);
		Map<Integer,String> player_map = new HashMap<Integer,String>(){{
			put(4, "Jay");
			put(5, "Rahul");
		}};
		ludo_game = new Ludo_Game(type,player_map);
		String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);
		return "ludo_board.jsp";
	}
	
	@RequestMapping(value="/move_token", method=RequestMethod.POST)
	public String game_moves(@RequestParam("move_token") String dmenu, Model model) {
		model.addAttribute("Game_token_positions", gm_tk_pos);
		model.addAttribute("move_token", dmenu);
		return "Moved... ";
	}


    @RequestMapping(value = "/token_select", method = RequestMethod.POST)
    public String token_select(@RequestParam String token, Model model) {
        model.addAttribute("token", token);
        String user_token_input_move = ludo_game.user_input_receiver(token);
        Map<String,String> token_positions = new HashMap<String,String>();
        if(user_token_input_move == "") {
        	token_positions = ludo_game.get_position_of_all_tokens();
        	model.addAttribute("token_path", token_positions);
			/*
			 * for(Map.Entry<String, String> entry : token_positions.entrySet()) {
			 * System.out.println(entry.getKey() + "/" + entry.getValue()); }
			 */
        }else {
        	model.addAttribute("error", user_token_input_move);
        }
        String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);
        return "ludo_board.jsp";
    }

    @RequestMapping(value = "/roll_dice", method = RequestMethod.GET)
    public String roll_dice(Model model) {
    	int dice_num = ludo_game.roll_dice();
    	model.addAttribute("dice_num", dice_num);
    	String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);
    	return "ludo_board.jsp";
    }
}
