package dal.asdc.game_handler;
/**
 * @author Kishan Rakeshbhai Patel **/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.asdc.player.Factory_classes.Player_factory_normal;
import dal.asdc.playing_pieces.Token;
import dal.asdc.ludo_board_structure.Token_paths;
import dal.asdc.movement.Dice;
import dal.asdc.movement.Make_Move;
import dal.asdc.player.IPlayer_intialiser;
import dal.asdc.player.Human_player;
import dal.asdc.player.Factory_classes.Player_factory;

public class Ludo_Game {
	
	Human_player player1 = null;
	Human_player player2 = null;
	Human_player player3 = null;
	Human_player player4 = null;
	private Human_player current_turn = null;
	private List<Human_player> total_player_list = new ArrayList<>();
	private static Ludo_Game ludo_game = null;
	private boolean dice_rolled = false;
	private String error_message = "";
	Input_Parser input_parser = null;
	Make_Move make_move = null;
	Dice dice = new Dice();
	int dice_number;
	boolean is_defeat_move = false;
	Token_paths token_paths = new Token_paths();
	Map<String,Integer> winner_map = new HashMap<>();
	
	public static Ludo_Game instance(String type, Map<Integer,String> player_list) {
		if(null == ludo_game) {
			ludo_game = new Ludo_Game(type, player_list);
		}
		return ludo_game;
	}
	
	public String get_current_turn_text() {
        String turn_text = get_current_turn().getColour()+"'s turn";
        return turn_text;
    }
	
	public Ludo_Game(String game_type, Map<Integer,String> player_list) {
		Player_factory factory = new Player_factory_normal();
		IPlayer_intialiser initialiser = factory.create_player_intialiser();
		
		input_parser = new Input_Parser();
		if(game_type.equals("two_player")) {
			initialiser.intialise(2);
		}else if(game_type.equals("three_player")) {
			initialiser.intialise(3);
		}else if(game_type.equals("four_player")) {
			initialiser.intialise(4);
		}else if(game_type.equals("computer_player")) {
			//initialize_computer_players();
		}
		Map<String, Human_player> map = initialiser.getPlayer_list();
		for(Map.Entry<String, Human_player> iterate : map.entrySet()) {
			total_player_list.add(iterate.getValue());
		}
		next_turn();
		make_move = new Make_Move();
		set_dice_rolled(false);
	}

	public boolean user_input_receiver(String input) {
        is_defeat_move = false;
        Token token_from_input;
        char[] word_tokens;
        assert(input_parser!=null);
        if(dice_rolled) {
            if(input_parser.check_input(input)) {
                word_tokens = input_parser.get_word_tokens(input);
                token_from_input = input_parser.get_player_from_input(get_total_player_list(), word_tokens);
            }else {
            	set_error_message("Input is not correct");
                return false;
            }
        }else {
        	set_error_message("First roll the dice then select token");
            return false;
        }
       
        if(check_turn(token_from_input)) {
            if(make_move.check_moving_path(token_from_input,dice_number)) {
                List<Token> updated_tokens = new ArrayList<>();
                updated_tokens = make_move.play_move(token_from_input, dice_number,get_total_player_list());
                if(updated_tokens.size()>1) {
                    is_defeat_move = true;
                }
                update_player(updated_tokens);
                next_turn();
                send_data_to_controller();
                set_dice_rolled(false);
                return true;
            }else {
            	set_error_message("You cann't play this token");
                return false;
            }
        }else {
        	set_error_message("It's not selected token's turn");
            return false;
        }
    }
	
	public Map<String,String> get_position_of_all_tokens(){
        Map<String,String> positions = new HashMap<>();
		int[][] tokens_position = new int[get_total_player_list().size()*4][2];
		int counter=0;
		List<Token> all_tokens = new ArrayList<>();
        for(Human_player player : get_total_player_list()) {
		  List<Token> four_tokens =player.get_all_tokens();
		  for(Token token : four_tokens) { 
			  int[][] coordinates = token.get_coordinate_position();
			  tokens_position[counter][0]=coordinates[0][0];
			  tokens_position[counter][1]=coordinates[0][1];
			  counter++;
			  all_tokens.add(token);
			  //String token_name = token.get_token_colour().substring(0, 1)+(token.get_token_number()+1);
			  //positions.put("{"+ coordinates[0][0]+","+coordinates[0][1] +"}", token_name);
		  }
		}
		 
        int[][] total_path = token_paths.total_path;
        for(int i=0;i<total_path.length;i++) {
        	int[][] temp_position = {{total_path[i][0],total_path[i][1]}};
			/*
			 * for(int j=0;j<tokens_position.length;j++) { if(temp_position[0][0] ==
			 * tokens_position[j][0] && temp_position[0][1] == tokens_position[j][1]) {
			 * String token_name = token.get_token_colour().substring(0,
			 * 1)+(token.get_token_number()+1); positions.put("{"+
			 * coordinates[0][0]+","+coordinates[0][1] +"}", token_name); } }
			 */
        	boolean is_set = false;
        	String token_name = "";
        	for(Token token : all_tokens) {
        		int[][] position = token.get_coordinate_position();
        		
        		if(temp_position[0][0] == position[0][0] && temp_position[0][1] == position[0][1]) {
        			token_name = token_name + token.get_token_colour().substring(0, 1)+(token.get_token_number()+1);
      			  	is_set = true;
      			  	break;
        		}
        	}
        	if(!is_set) {
  			  	positions.put("{"+ temp_position[0][0]+","+temp_position[0][1] +"}", " ");
        	}else {
  			  	positions.put("{"+ temp_position[0][0]+","+temp_position[0][1] +"}", token_name);
        	}
        }
        return positions;
    }
	
	public void update_player(List<Token> updated_tokens) {
		List<Human_player> all_players = get_total_player_list();
		for(int player_index = 0 ; player_index < all_players.size() ; player_index++) {
			Human_player temp_player = all_players.get(player_index);
			List<Token> four_tokens = temp_player.get_all_tokens();
			int updated_token_index = 0;

			for(Token token : four_tokens) {
				Token temp_token = token;
				for(Token updated_token : updated_tokens) {
					if(temp_token.get_token_colour().equals(updated_token.get_token_colour()) &&
							temp_token.get_token_number() == updated_token.get_token_number()) {
						four_tokens.set(updated_token_index, updated_token);
					}
				}
				updated_token_index++;
			}
			temp_player = check_player_is_done(four_tokens,temp_player);
			all_players.set(player_index, temp_player);
		}
		set_total_player_list(all_players);
	}

	public void next_turn() {
		Human_player current_player_temp = get_current_turn();
		List<Human_player> temp_list = get_total_player_list();
		if(current_player_temp==null) {
			current_player_temp = temp_list.get(0);
			set_current_turn(current_player_temp);
			return;
		}else {
			if(dice_number == 6 || is_defeat_move) {
				return;
			}
			
			Human_player next_player = get_next_player(temp_list,current_player_temp);
			if(next_player.get_is_done()) {
				//next_turn();
				//do something here
			}else {
				set_current_turn(next_player);
			}
			return;
		}	
	}
	
	public boolean roll_dice() {
		if(get_dice_rolled()) {
			set_error_message("Play a token first");
            return false;
		}
        int number = dice.roll_dice();
        if(number <= 6 && number >= 1) {
        	int all_home_count = 0;
        	List<Token> four_tokens = get_current_turn().get_all_tokens();
        	for(Token token : four_tokens) {
        		if(token.is_home()) {
        			all_home_count++;
        		}
        	}
        	if(all_home_count==4 && number != 6) {
        		System.out.println("next turn");
        		next_turn();
        		dice_number = number;
        	}else {
        		dice_number = number;
                set_dice_rolled(true);
        	}
        	return true;
        }
        return false;
		
    }
	
	private Human_player get_next_player(List<Human_player> temp_list, Human_player current_player_temp) {
		int index = temp_list.indexOf(current_player_temp);
		Human_player next_player;
		if(index == (temp_list.size()-1)) {
			next_player = temp_list.get(0);
		}else {
			next_player = temp_list.get(index+1);
		}
		return next_player;
	}
	
	private void send_data_to_controller() {
		//String current_turn_text = get_current_turn().getColour().concat("'s turn");
		
	}

	private boolean check_turn(Token token_from_input) {
		Human_player temp_current_player = get_current_turn();
		if(token_from_input.get_token_colour().equals(temp_current_player.getColour())) {
			return true;
		}
		return false;
	}
		
	private Human_player check_player_is_done(List<Token> four_tokens, Human_player temp_player) {
		int tokens_at_winning_box = 0;
		for(Token token : four_tokens) {
			if(token.get_is_token_at_winning_box()) {
				tokens_at_winning_box++;
			}
		}
		if(tokens_at_winning_box==4) {
			set_winner_in_map(temp_player);
			temp_player.set_is_done(true);
		}else {
			temp_player.set_is_done(false);
		}
		temp_player.set_tokens(four_tokens);
		return temp_player;
	}
	
	private void set_winner_in_map(Human_player temp_player) {
		if(winner_map.isEmpty()) {
			//winner_map.put("Winner", temp_player.get_id);
			return;
		}
		if(winner_map.containsKey("winner") && winner_map.size()==1) {
			//winner_map.put("Runner", temp_player.get_id());
			return;
		}
	}
	
	public Human_player get_current_turn() {
		return current_turn;
	}

	public void set_current_turn(Human_player current_turn) {
		this.current_turn = current_turn;
	}
	
	public List<Human_player> get_total_player_list() {
		return total_player_list;
	}

	public void set_total_player_list(List<Human_player> total_player_list_temp_var) {
		total_player_list = total_player_list_temp_var;
	}
	
	public boolean get_dice_rolled() {
		return dice_rolled;
	}

	public void set_dice_rolled(boolean dice_rolled) {
		this.dice_rolled = dice_rolled;
	}
	
	public void set_error_message(String error_message) {
		this.error_message = error_message;
	}
	
	public String get_error_message() {
		return error_message;
	}
	
	public void set_dice_number(int number) {
		dice_number = number;
	}
	
	public int get_dice_number() {
		return dice_number;
	}
}
