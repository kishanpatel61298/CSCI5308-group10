package dal.asdc.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dal.asdc.playing_pieces.IToken;
import dal.asdc.playing_pieces.Red_Token;

public class Check_Move_Test {

	@Test
	public void check_is_red_token_6_dice_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] red_home = {{2,3}};
		IToken token = new Red_Token(0,red_home);
		boolean is_movable = check_move.check_is_token_movable(token,6);
		assertEquals(true,is_movable);
	}
	
	@Test
	public void check_is_red_token_3_dice_at_home_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] red_home = {{2,3}};
		IToken token = new Red_Token(0,red_home);
		boolean is_movable = check_move.check_is_token_movable(token,3);
		assertEquals(false,is_movable);
	}
	
	@Test
	public void check_is_red_token_in_winning_square_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] red_home = {{6,6}};
		IToken token = new Red_Token(0,red_home);
		boolean is_movable = check_move.check_is_token_movable(token,6);
		assertEquals(false,is_movable);
	}
	
	@Test
	public void check_is_red_token_near_winning_square_2_dice_only_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] red_home = {{8,8}};
		IToken token = new Red_Token(0,red_home);
		boolean is_movable = check_move.check_is_token_movable(token,2);
		assertEquals(false,is_movable);
	}
	
	@Test
	public void check_is_red_token_in_winning_square_more_than_required_dice_movable_test() {
		Check_Move check_move = new Check_Move();
		int[][] red_home = {{8,8}};
		IToken token = new Red_Token(0,red_home);
		boolean is_movable = check_move.check_is_token_movable(token,6);
		assertEquals(false,is_movable);
	}
	
	
}
