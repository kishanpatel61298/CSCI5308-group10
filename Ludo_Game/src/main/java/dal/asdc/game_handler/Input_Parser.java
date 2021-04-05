package dal.asdc.game_handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;
import dal.asdc.game_handler.command.*;

public class Input_Parser {
	
	Map<Character,Command> input_commands = new HashMap<>();
	
	String input_text = "";
	public Input_Parser(){
		input_commands.put('r', new Red_Command());
		input_commands.put('g', new Green_Command());
		input_commands.put('y', new Yellow_Command());
		input_commands.put('b', new Blue_Command());

	}
	
	public boolean check_input(String input) {
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
	
	public Token get_player_from_input(List<Player> player_list_temp, char[] input_tokens) {
		char first_letter = input_tokens[0];
		first_letter = Character.toLowerCase(first_letter);
		Command command = input_commands.get(first_letter);
		command.set_parameters(player_list_temp, input_tokens);
		return command.execute();
	}
}
