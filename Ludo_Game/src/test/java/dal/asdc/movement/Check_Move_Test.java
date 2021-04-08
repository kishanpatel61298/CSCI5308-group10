package dal.asdc.movement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.factoy_method.Token_Factory;

public class Check_Move_Test {

	Token_Factory factory;
	Token token;
	
	@BeforeEach
	void initialize() {
		factory = new Token_Factory();
		token = factory.crete_red_token(0);

	}
	
	@Test
	void check_is_red_token_6_dice_movable_test() {
		Check_Move check_move = new Check_Move();
		boolean is_movable = check_move.check_is_token_movable(token,6);
		assertEquals(true,is_movable);
	}
	
	@Test
	void check_is_red_token_3_dice_at_home_movable_test() {
		Check_Move check_move = new Check_Move();
		boolean is_movable = check_move.check_is_token_movable(token,3);
		assertEquals(false,is_movable);
	}
	
	@Test
	void check_is_red_token_in_winning_square_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] new_position = new int[][]{{7,7}};
		token.set_coordinate_position(new_position);
		int[][] checking = token.get_coordinate_position();
		boolean is_movable = check_move.check_is_token_movable(token,6);
		assertEquals(false,is_movable);
	}
	
	@Test
	void check_is_red_token_near_winning_square_2_dice_only_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] token_path = token.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		token.set_coordinate_position(token_position);
		boolean is_movable = check_move.check_is_token_movable(token,4);
		assertEquals(false,is_movable);
	}
	
	@Test
	void check_is_red_token_in_winning_square_more_than_required_dice_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] token_path = token.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		token.set_coordinate_position(token_position);
		boolean is_movable = check_move.check_is_token_movable(token,2);
		assertEquals(true,is_movable);
	}
	
	
}
