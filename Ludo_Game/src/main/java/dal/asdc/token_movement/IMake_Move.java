package dal.asdc.token_movement;

import java.util.List;

import dal.asdc.game_handler.Player;
import dal.asdc.playing_pieces.Token;

public interface IMake_Move {
	boolean check_moving_path(Token token, int dice_number);
	
	List<Token> play_move(Token selected_token, int dice_number, List<Player> all_players);
	
	int get_index_of_token_on_path(int[][] token_position, int[][] token_path);
	
	List<Token> add_all_tokens_other_than_selected_into_list(Token selected_token, List<Player> all_players);
	
	boolean is_defeat_move_or_not(int[][] after_move_position, Token selected_token, List<Token> all_tokens);
	 
	boolean is_move_into_safe_box_or_not(int[][] after_move_position, int[][] safe_box);
}