package dal.asdc.game_controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dal.asdc.game_handler.Input_Parser;
import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;

public class Input_Parser_Test {
	
	@Test
	void check_input_test_true() {
		Input_Parser input_parser = new Input_Parser();
		assertEquals(true,input_parser.check_input("R1"));
	}
	
	@Test
	void check_input_test_false_type1() {
		Input_Parser input_parser = new Input_Parser();
		assertEquals(false,input_parser.check_input("  r54e"));
	}
	
	@Test
	void check_input_test_false_type2() {
		Input_Parser input_parser = new Input_Parser();
		assertEquals(true,input_parser.check_input("  y1       "));
	}
	
	@Test
	void get_word_tokens_test() {
		Input_Parser input_parser = new Input_Parser();
		char[] tokens = input_parser.get_word_tokens("r1");
		assertEquals('r',tokens[0]);
		assertEquals('1',tokens[1]);
	}
	
	@Test
	void get_token_test_one() {
		Input_Parser input_parser = new Input_Parser();
		List<Player> total_player_list = new ArrayList<>(); 
		Player player1 = new Player("RED");
		Player player2 = new Player("YELLOW");
		char[] char_array = input_parser.get_word_tokens("R1");
		total_player_list.add(player1);
		total_player_list.add(player2);				
		Token token = input_parser.get_player_from_input(total_player_list, char_array);
		
		assertEquals(0,token.get_token_number());
	}
	
	@Test
	void get_token_test_four() {
		Input_Parser input_parser = new Input_Parser();
		List<Player> total_player_list = new ArrayList<>(); 
		Player player1 = new Player("RED");
		Player player2 = new Player("YELLOW");
		char[] char_array = input_parser.get_word_tokens("y4");
		total_player_list.add(player1);
		total_player_list.add(player2);				
		Token token = input_parser.get_player_from_input(total_player_list, char_array);
		
		assertEquals(3,token.get_token_number());
	}
}
