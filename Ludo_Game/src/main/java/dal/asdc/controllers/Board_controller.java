package dal.asdc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dal.asdc.game_handler.Ludo_Game;
import dal.asdc.ludo_board_structure.Ludo_board_formation;
import dal.asdc.ludo_board_structure.Token_positions;
import dal.asdc.model.Game_token_positions;

@Controller
public class Board_controller {
	
	Ludo_board_formation l_board = new Ludo_board_formation();
	Ludo_Game ludo_game;
	Token_positions token_pos = new Token_positions();
	
	@Autowired
	Game_token_positions gm_tk_pos;

	@RequestMapping("home")
	public String home() {
		return "ludo_board.jsp";
	}
	
	@RequestMapping("/start_game")
	public String display_board() {
		return "ludo_board.jsp";
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
        Map<String,String> token_positions = new HashMap<String,String>();
        token_positions = ludo_game.get_position_of_all_tokens();
    	model.addAttribute("token_path", token_positions);
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
        boolean is_succeed = ludo_game.user_input_receiver(token);
        String error_message = "";
        if(!is_succeed) {
        	error_message = ludo_game.get_error_message();
        	model.addAttribute("error", error_message);
        }
        Map<String,String> token_positions = new HashMap<String,String>();
        token_positions = ludo_game.get_position_of_all_tokens();
    	model.addAttribute("token_path", token_positions);
        String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);
        return "ludo_board.jsp";
    }

    @RequestMapping(value = "/roll_dice", method = RequestMethod.GET)
    public String roll_dice(Model model) {
    	boolean is_rolled = ludo_game.roll_dice();
    	if(is_rolled) {
        	model.addAttribute("dice_num", ludo_game.get_dice_number());
    	}else {
    		String error_message = ludo_game.get_error_message();
        	model.addAttribute("error", error_message);
        	model.addAttribute("dice_num", ludo_game.get_dice_number());
    	}
    	String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);
		
		Map<String,String> token_positions = new HashMap<String,String>();
        token_positions = ludo_game.get_position_of_all_tokens();
    	model.addAttribute("token_path", token_positions);
    	
    	return "ludo_board.jsp";
    }
	
}
