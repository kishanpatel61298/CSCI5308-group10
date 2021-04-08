package dal.asdc.game_handler.command;
/**
 * @author Kishan Rakeshbhai Patel **/
import java.util.ArrayList;
import java.util.List;

import dal.asdc.player.Human_player;
import dal.asdc.playing_pieces.Token;

public abstract class Command {
	
	public char second_letter;
	List<Human_player> player_list = new ArrayList<>();
	enum Token_Colour{
		RED,
		BLUE,
		YELLOW,
		GREEN
	}
	
	public void set_parameters(List<Human_player> player_list_temp, char[] input_tokens) {
		second_letter = input_tokens[1];
		player_list = player_list_temp;
	}
	
	protected Token get_token(Human_player player, char token_number) {
		int token_number_int = Character.getNumericValue(token_number);
		Token token = player.get_selected_token(token_number_int-1);
		return token;
	}
	
	public abstract Token execute();
}
