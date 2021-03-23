package dal.asdc.game_handler;

import java.util.ArrayList;
import java.util.List;

import dal.asdc.game.Make_Move;
import dal.asdc.playing_pieces.Token;

public class Game_Controller {
	
	Player player1 = null;
	Player player2 = null;
	Player player3 = null;
	Player player4 = null;
	private Player current_turn = null;
	private List<Player> total_player_list = new ArrayList<>();
	private static Game_Controller game_controller = null;
	private boolean dice_rolled = false;
	Input_Parser input_parser = null;
	Make_Move make_move = null;
	int dice_number;
	boolean is_defeat_move = false;
	
	public static Game_Controller instance(String type) {
		if(null == game_controller) {
			game_controller = new Game_Controller(type);
		}
		return game_controller;
	}
	
	private Game_Controller(String game_type) {
		input_parser = new Input_Parser();
		if(game_type.equals("two_player")) {
			initialize_two_players();
		}else if(game_type.equals("three_player")) {
			initialize_three_players();
		}else if(game_type.equals("four_player")) {
			initialize_four_players();
		}else if(game_type.equals("computer_player")) {
			initialize_computer_players();
		}
		next_turn();
		make_move = new Make_Move();
		dice_rolled = false;
	}

	public void user_input_receiver(String input) {
		is_defeat_move = false;
		assert(input_parser!=null);
		if(dice_rolled) {
			if(input_parser.check_input(input)) {
				char[] word_tokens = input_parser.get_word_tokens(input);
				Token token_from_input = input_parser.get_player_from_input(get_total_player_list(), word_tokens);
				if(check_turn(token_from_input)) {
					if(make_move.check_moving_path(token_from_input,dice_number)) {
						List<Token> updated_tokens = new ArrayList<>();
						updated_tokens = make_move.play_move(token_from_input, dice_number,get_total_player_list());
						if(updated_tokens.size()>1) {
							is_defeat_move = true;
						}
						next_turn();
						//logic to update tokens in player
					}else {
						//return that cann't play this token
					}
				}else {
					//return that not selected token's turn
				}
			}else {
				//return that input is not correct means not r1 or y4 type
			}
		}else {
			//return that first roll the dice then select token
		}
	}
	
	private boolean check_turn(Token token_from_input) {
		Player temp_current_player = get_current_turn();
		if(token_from_input.get_token_colour().equals(temp_current_player.getColour())) {
			return true;
		}
		return false;
	}

	public void next_turn() {
		Player current_player_temp = get_current_turn();
		List<Player> temp_list = get_total_player_list();
		if(current_player_temp==null) {
			current_player_temp = temp_list.get(0);
			set_current_turn(current_player_temp);
			return;
		}else {
			if(dice_number == 6) {
				return;
			}
			int index = temp_list.indexOf(current_player_temp);
			if(index == (temp_list.size()-1)) {
				current_player_temp = temp_list.get(0);
			}else {
				current_player_temp = temp_list.get(index+1);
			}

			set_current_turn(current_player_temp);

			if(current_player_temp.get_is_done()) {
				next_turn();
			}else {
				set_current_turn(current_player_temp);
			}
			return;
		}	
	}
	
	private void initialize_two_players() {
		player1 = new Player("RED");
		player2 = new Player("YELLOW");
		
		total_player_list.add(player1);
		total_player_list.add(player2);
	}
	
	private void initialize_three_players() {
		player1 = new Player("RED");
		player2 = new Player("GREEN");
		player3 = new Player("YELLOW");
		
		total_player_list.add(player1);
		total_player_list.add(player2);
		total_player_list.add(player3);
	}
	
	private void initialize_four_players() {
		player1 = new Player("RED");
		player2 = new Player("GREEN");
		player3 = new Player("YELLOW");
		player4 = new Player("FOUR");
		
		total_player_list.add(player1);
		total_player_list.add(player2);
		total_player_list.add(player3);
		total_player_list.add(player4);
	}
	
	private void initialize_computer_players() {
		player1 = new Player("RED");
		player2 = new Player("YELLOW");
		
		total_player_list.add(player1);
		total_player_list.add(player2);
	}
		

	public Player get_current_turn() {
		return current_turn;
	}

	public void set_current_turn(Player current_turn) {
		this.current_turn = current_turn;
	}
	
	public List<Player> get_total_player_list() {
		return total_player_list;
	}

	public void set_total_player_list(List<Player> total_player_list_temp_var) {
		total_player_list = total_player_list_temp_var;
	}
	
	public boolean get_dice_rolled() {
		return dice_rolled;
	}

	public void set_dice_rolled(boolean dice_rolled) {
		this.dice_rolled = dice_rolled;
	}
}
