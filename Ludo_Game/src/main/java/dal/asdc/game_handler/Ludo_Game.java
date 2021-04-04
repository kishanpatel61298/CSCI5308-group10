package dal.asdc.game_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.asdc.playing_pieces.Token;
import dal.asdc.game.Dice;
import dal.asdc.game.Make_Move;
import dal.asdc.player.Player;

public class Ludo_Game {
	
	Player player1 = null;
	Player player2 = null;
	Player player3 = null;
	Player player4 = null;
	private Player current_turn = null;
	private List<Player> total_player_list = new ArrayList<>();
	private static Ludo_Game ludo_game = null;
	private boolean dice_rolled = false;
	Input_Parser input_parser = null;
	Make_Move make_move = null;
	Dice dice = new Dice();
	int dice_number;
	boolean is_defeat_move = false;
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
		set_dice_rolled(false);
	}

	public String user_input_receiver(String input) {
        is_defeat_move = false;
        Token token_from_input;
        char[] word_tokens;
        assert(input_parser!=null);
        if(dice_rolled) {
            if(input_parser.check_input(input)) {
                word_tokens = input_parser.get_word_tokens(input);
                token_from_input = input_parser.get_player_from_input(get_total_player_list(), word_tokens);
            }else {
                //return that input is not correct means not r1 or y4 type
                return "input is not correct";
            }
        }else {
            //return that first roll the dice then select token
            return "first roll the dice then select token";
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
                return "";
            }else {
                //return that cann't play this token
                return "cann't play this token";
            }
        }else {
            //return that not selected token's turn
            return "not selected token's turn";
        }
    }
	
	public Map<String,String> get_position_of_all_tokens(){
        Map<String,String> positions = new HashMap<>();
        for(Player player : get_total_player_list()) {
            List<Token> four_tokens = player.get_all_tokens();
            for(Token token : four_tokens) {
                int[][] coordinates = token.get_coordinate_position();
                String token_name = token.get_token_colour().substring(0, 1)+(token.get_token_number()+1);
                positions.put("{"+ coordinates[0][0]+","+coordinates[0][1] +"}", token_name);
            }
        }
        return positions;
    }
	
	public void update_player(List<Token> updated_tokens) {
		List<Player> all_players = get_total_player_list();
		for(int player_index = 0 ; player_index < all_players.size() ; player_index++) {
			Player temp_player = all_players.get(player_index);
			List<Token> four_tokens = temp_player.get_all_tokens();
			
			for(Token token : four_tokens) {
				Token temp_token = token;
				int updated_token_index = 0;
				for(Token updated_token : updated_tokens) {
					if(temp_token.get_token_colour().equals(updated_token.get_token_colour()) &&
							temp_token.get_token_number() == updated_token.get_token_number()) {
						four_tokens.set(updated_token_index, updated_token);
					}
					updated_token_index++;
				}
			}
			temp_player = check_player_is_done(four_tokens,temp_player);
			all_players.set(player_index, temp_player);
		}
		set_total_player_list(all_players);
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
			
			get_next_player(temp_list,current_player_temp);
			
			set_current_turn(current_player_temp);

			if(current_player_temp.get_is_done()) {
				next_turn();
			}else {
				set_current_turn(current_player_temp);
			}
			return;
		}	
	}
	
	private Player get_next_player(List<Player> temp_list, Player current_player_temp) {
		int index = temp_list.indexOf(current_player_temp);
		if(index == (temp_list.size()-1)) {
			current_player_temp = temp_list.get(0);
		}else {
			current_player_temp = temp_list.get(index+1);
		}
		return current_player_temp;
	}

	public int roll_dice() {
        int number = dice.roll_dice();
        if(number <= 6 && number >= 1) {
            dice_number = number;
            set_dice_rolled(true);
            return number;
        }
        return 0;
    }
	
	private void send_data_to_controller() {
		//String current_turn_text = get_current_turn().getColour().concat("'s turn");
		
	}

	private boolean check_turn(Token token_from_input) {
		Player temp_current_player = get_current_turn();
		if(token_from_input.get_token_colour().equals(temp_current_player.getColour())) {
			return true;
		}
		return false;
	}
		
	private Player check_player_is_done(List<Token> four_tokens, Player temp_player) {
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
	
	private void set_winner_in_map(Player temp_player) {
		if(winner_map.isEmpty()) {
			//winner_map.put("Winner", temp_player.get_id);
			return;
		}
		if(winner_map.containsKey("winner") && winner_map.size()==1) {
			//winner_map.put("Runner", temp_player.get_id());
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
