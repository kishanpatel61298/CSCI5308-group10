package game_handler;

import java.util.List;
import java.util.regex.Pattern;

import dal.asdc.playing_pieces.Token;

public class Input_Parser {
	
	String input_text = "";
	
	public boolean check_input(String input) {
		if(check_pattern(input)) {
			return true;
		}else {
			return false;
		}
	}

	private boolean check_pattern(String input) {
		input_text = input.trim().toLowerCase();
		String regular_expression = "[rgby]{1}[1-4]{1}";
		boolean result = Pattern.matches(regular_expression, input_text);
		return result;
	}
	
	public char[] get_word_tokens(String input) {
		char[] tokens = new char[input.length()];
		for(int chars = 0 ; chars < input.length() ; chars++) {
			tokens[chars] = input.charAt(chars);
		}
		return tokens;
	}
	
	public Token get_player_from_input(List<Player> player_list, char[] input_tokens) {
		char first_letter = input_tokens[0];
		switch(first_letter) {
			case 'r':
				for(int player = 0 ; player < player_list.size() ; player++) {
					Player temp_player = player_list.get(player);
					if(temp_player.getColour().equals("RED")) {
						Token red_token = get_token(player_list.get(player),input_tokens[1]);
						return red_token;
					}
				}
				break;
			case 'g':
				for(int player = 0 ; player < player_list.size() ; player++) {
					Player temp_player = player_list.get(player);
					if(temp_player.getColour().equals("RED")) {
						Token green_token = get_token(player_list.get(player),input_tokens[1]);
						return green_token;
					}
				}
				break;
			case 'b':
				for(int player = 0 ; player < player_list.size() ; player++) {
					Player temp_player = player_list.get(player);
					if(temp_player.getColour().equals("RED")) {
						Token blue_token = get_token(player_list.get(player),input_tokens[1]);
						return blue_token;
					}
				}
				break;
			case 'y':
				for(int player = 0 ; player < player_list.size() ; player++) {
					Player temp_player = player_list.get(player);
					if(temp_player.getColour().equals("RED")) {
						Token yellow_token = get_token(player_list.get(player),input_tokens[1]);
						return yellow_token;
					}
				}
				break;
		}
		return null;
	}

	private Token get_token(Player player, char token_number) {
		int token_number_int = Character.getNumericValue(token_number);
		Token token = player.get_selected_token(token_number_int-1);
		return token;
	}
}
