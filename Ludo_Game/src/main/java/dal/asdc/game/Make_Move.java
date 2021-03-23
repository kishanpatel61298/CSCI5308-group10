package dal.asdc.game;

import java.util.ArrayList;
import java.util.List;

import dal.asdc.game_handler.Player;
import dal.asdc.playing_pieces.Green_Token;
import dal.asdc.playing_pieces.Red_Token;
import dal.asdc.playing_pieces.Token;

public class Make_Move {
	
	Check_Move check_move = new Check_Move();
	List<Token> return_token = null;
	List<Token> all_tokens = null;
	
	public Make_Move() {
		
	}
	
	public boolean check_moving_path(Token token, int dice_number) {
		if(check_move.check_is_token_movable(token, dice_number)){
			return true;
		}else {
			System.out.print("You can't play this token");
			return false;
		}
	}
	
	public List<Token> play_move(Token selected_token, int dice_number, List<Player> all_players) {
		int[][] token_path = selected_token.get_token_path();
		int[][] safe_box = selected_token.get_safe_boxes();
		return_token = new ArrayList<>();
		all_tokens = new ArrayList<>();
		
		if(selected_token.is_home()) {
			if(dice_number==6) {
				System.out.println("out of home move");
				int[][] new_position = {{token_path[0][0],token_path[0][1]}};
				selected_token.set_coordinate_position(new_position);
				selected_token.set_is_token_at_home(false);
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
				for(int tokens = 0 ; tokens < temp_player_tokens.size() ; tokens++) {
					if(temp_player_tokens.get(tokens).get_token_colour().equals(selected_token.get_token_colour()) && 
							temp_player_tokens.get(tokens).get_token_number() == selected_token.get_token_number()) {
					}else {
						all_tokens.add(temp_player_tokens.get(tokens));
					}
				}
			}
			
			if((token_index_on_path+dice_number) < token_path.length) {
				int[][] after_move_position = {{token_path[token_index_on_path+dice_number][0],token_path[token_index_on_path+dice_number][1]}};
				boolean is_defeat = false;
				boolean is_safe = false;

				for(int safe_box_index = 0 ; safe_box_index < safe_box.length ; safe_box_index++) {
					if(safe_box[safe_box_index][0] == after_move_position[0][0] && safe_box[safe_box_index][1] == after_move_position[0][1]) {
						is_safe = true;
						System.out.println("in safe box move");
						break;
					}
				}
				System.out.println("here2 "+all_tokens.size());

				for(int all_token_counter = 0 ; all_token_counter < all_tokens.size() ; all_token_counter++) {
					Token temp_all_token_holder = all_tokens.get(all_token_counter);
					int[][] temp_all_token_holder_position = temp_all_token_holder.get_coordinate_position();
					System.out.println(temp_all_token_holder_position[0][0]+"  "+temp_all_token_holder_position[0][1]+ "  "+temp_all_token_holder.get_token_colour());
					if(temp_all_token_holder_position[0][0] == after_move_position[0][0] && temp_all_token_holder_position[0][1] == after_move_position[0][1]) {
						if(temp_all_token_holder.get_token_colour().equals(selected_token.get_token_colour())) {
							System.out.println("if");
							is_defeat = false;
						}else {
							System.out.println("else");
							is_defeat = true;
							break;
						}
					}
				}
				System.out.println("is_defeat= "+is_defeat+"  is_safe= "+is_safe);
				if(is_defeat && !is_safe) {
					System.out.println("defeat move");
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
							return_token.add(temp_all_token_holder);
						}
					}
					return return_token;
				}else {
					System.out.println("normal move");
					selected_token.set_coordinate_position(after_move_position);
					selected_token.set_is_token_at_home(false);
					selected_token.set_is_token_at_winning_box(false);
					return_token.add(selected_token);
					return return_token;
				}	
			}else if(token_index_on_path+dice_number == token_path.length) {
				System.out.println("at winning square");
				int[][] winning_zone_coordinates = selected_token.get_winning_square();
				int[][] new_position = {{winning_zone_coordinates[0][0],winning_zone_coordinates[0][1]}};
				selected_token.set_coordinate_position(new_position);
				selected_token.set_is_token_at_winning_box(true);
				return_token.add(selected_token);
				return return_token;
			}
		}
		return return_token;
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
