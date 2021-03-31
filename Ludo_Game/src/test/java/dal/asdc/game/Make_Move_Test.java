package dal.asdc.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dal.asdc.game_handler.Player;
import dal.asdc.playing_pieces.Token;
import dal.asdc.token_movement.Make_Move;

public class Make_Move_Test {
	 Make_Move make_move;
	List<Player> total_player_list;
	Player player1;
	Player player2;
	List<Token> output_list;
	
	@BeforeEach
	void initialize() {
		make_move = new Make_Move();
		total_player_list = new ArrayList<>(); 
		player1 = new Player("RED");
		player2 = new Player("YELLOW");
		List<Token> output_list = new ArrayList<>();
		total_player_list.add(player1);
		total_player_list.add(player2);
	}
	
	
	@Test
	void get_token_path_index_test() {
		Make_Move make_move = new Make_Move();
		int[][] token_position = {{3,4}};
		int[][] token_path = {{2,3},{3,4},{4,5}};
		
		int index = make_move.get_index_of_token_on_path(token_position, token_path);
		
		assertEquals(1,index);
	}
	
	@Test
	void play_token_out_from_home_test() {
		Token red1 = player1.get_all_tokens().get(0);
		output_list = make_move.play_move(red1, 6, total_player_list);
		assertEquals(false,output_list.get(0).is_home());
	}
	
	@Test
	void play_token_in_winning_square_test() {
		
		Token red1 = player1.get_all_tokens().get(0);
		int[][] token_path = red1.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		red1.set_coordinate_position(token_position);
		output_list = make_move.play_move(red1, 3, total_player_list);
		assertEquals(true,output_list.get(0).get_is_token_at_winning_box());
	}
	
	@Test
	void play_token_defeat() {
		Token yellow1 = player2.get_all_tokens().get(0);
		int[][] token_position = {{4,4}};
		yellow1.set_coordinate_position(token_position);
		List<Token> yellow_tokens = total_player_list.get(1).get_all_tokens();
		yellow_tokens.set(0, yellow1);
		total_player_list.get(1).set_tokens(yellow_tokens);
		
		Token red1 = player1.get_all_tokens().get(0);
		int[][] token_position_red = {{1,1}};
		red1.set_coordinate_position(token_position_red);

		output_list = make_move.play_move(red1, 3, total_player_list);
		assertEquals(2,output_list.size());
	}
}
