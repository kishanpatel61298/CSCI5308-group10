package dal.asdc.game;

import java.util.ArrayList;
import java.util.List;

import dal.asdc.playing_pieces.Green_Token;
import dal.asdc.playing_pieces.Red_Token;
import dal.asdc.playing_pieces.Token;
import game_handler.Player;

public class Make_Move {
	
	Check_Move check_move = new Check_Move();
	List<Token> red_tokens = new ArrayList();
	List<Token> return_token = null;
	List<Token> all_tokens = null;
	int total_player = 4;
	
	public Make_Move() {
		
	}
	
	public boolean check_moving_path(Token token) {
		if(check_move.check_is_token_movable(token, 6)){
			return true;
//			make_move(token,6);
		}else {
			//show error
			System.out.print("You can't play this token");
			return false;
		}
	}
	
	public List<Token> play_move(Token selected_token, int dice_number, List<Player> all_players) {
		int[][] token_path = selected_token.get_token_path();
		return_token = new ArrayList<>();
		all_tokens = new ArrayList<>();
		
		if(selected_token.is_home()) {
			if(dice_number==6) {
				int[][] new_position = {{token_path[0][0],token_path[0][1]}};
				selected_token.set_coordinate_position(new_position);
				selected_token.set_is_token_at_home(false);
				
				//this is list of tokens of current player
				//set this im game controller
				//red_tokens.set(selected_token.get_token_number(), selected_token);
				//set token_moved
				return_token.add(selected_token);
				return return_token;
			}
		}else{
			int token_index_on_path = -1;
			int[][] token_position = selected_token.get_coordinate_position();
			
			token_index_on_path = get_token_path_index(token_position,token_path);
			
			for(int player_count = 0 ; player_count < all_players.size() ; player_count++) {
				Player temp_player = all_players.get(player_count);
				List<Token> temp_player_tokens = temp_player.get_all_tokens();
				for(int tokens = 0 ; tokens > temp_player_tokens.size() ; tokens++) {
					if(temp_player_tokens.get(tokens).get_token_colour().equals(selected_token.get_token_colour()) && 
							temp_player_tokens.get(tokens).get_token_number() == selected_token.get_token_number()) {
						continue;
					}else {
						all_tokens.add(temp_player_tokens.get(tokens));
					}
				}
			}
			
			if((token_index_on_path+dice_number) < token_path.length) {
				int[][] after_move_position = {{token_path[token_index_on_path+dice_number][0],token_path[token_index_on_path+dice_number][1]}};
				boolean is_defeat = false;
				for(int all_token_counter = 0 ; all_token_counter < all_tokens.size() ; all_token_counter++) {
					Token temp_all_token_holder = all_tokens.get(all_token_counter);
					int[][] temp_all_token_holder_position = temp_all_token_holder.get_coordinate_position();
					if(temp_all_token_holder_position[0][0] == after_move_position[0][0] && temp_all_token_holder_position[0][1] == after_move_position[0][1]) {
						if(temp_all_token_holder.get_token_colour().equals(selected_token.get_token_colour())) {
							is_defeat = false;
						}else {
							is_defeat = true;
						}
					}
				}
				
				if(is_defeat) {
					//defeat
					selected_token.set_coordinate_position(after_move_position);
					selected_token.set_is_token_at_home(false);
					selected_token.set_is_token_at_winning_box(false);
					return_token.add(selected_token);

					for(int all_token_counter = 0 ; all_token_counter < all_tokens.size() ; all_token_counter++) {
						Token temp_all_token_holder = all_tokens.get(all_token_counter);
						int[][] temp_all_token_holder_position = temp_all_token_holder.get_coordinate_position();
						if(temp_all_token_holder_position[0][0] == after_move_position[0][0] &&
								temp_all_token_holder_position[0][1] == after_move_position[0][1]) {
							temp_all_token_holder.set_at_home();
							//red_tokens.set(temp_all_token_holder.get_token_number(), temp_all_token_holder);
							return_token.add(temp_all_token_holder);
						}
					}
					return return_token;
				}else {
					//normal move
					selected_token.set_coordinate_position(after_move_position);
					selected_token.set_is_token_at_home(false);
					selected_token.set_is_token_at_winning_box(false);
					//this is list of tokens of current player
					//red_tokens.set(selected_token.get_token_number(), selected_token);
					return_token.add(selected_token);
					return return_token;
				}
				
			}else if(token_index_on_path+dice_number == token_path.length) {
				//in winning box
				int[][] winning_zone_coordinates = selected_token.get_winning_square();
				int[][] new_position = {{winning_zone_coordinates[0][0],winning_zone_coordinates[0][1]}};
				selected_token.set_coordinate_position(new_position);
				selected_token.set_is_token_at_winning_box(true);
				//this is list of tokens of current player
				//red_tokens.set(selected_token.get_token_number(), selected_token);
				return_token.add(selected_token);
				return return_token;
				//set token_moved
			}
			
		}
		return all_tokens;
	}
	
	public int get_token_path_index(int[][] token_position, int[][] token_path) {
		int temp_path_index = 0;
		for(int path_index = 0; path_index < token_path.length ; path_index++) {
			if(token_path[path_index][0]==token_position[0][0] && token_path[path_index][1]==token_position[0][1]) {
				temp_path_index = path_index;
			}
		}
		return temp_path_index;
	}

}
