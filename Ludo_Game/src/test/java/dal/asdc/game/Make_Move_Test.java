package dal.asdc.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Make_Move_Test {
	

	@Test
	public void check_is_red_token_6_dice_movable_test() {
		Make_Move make_move_obj = new Make_Move();
		int[][] red_home = {{2,3}};
		boolean is_movable = make_move_obj.check_is_token_movable(red_home, "RED",6);
		assertEquals(true,is_movable);
	}
	
	@Test
	public void check_is_red_token_3_dice_at_home_movable_test() {
		Make_Move make_move_obj = new Make_Move();
		int[][] red_home = {{2,3}};
		boolean is_movable = make_move_obj.check_is_token_movable(red_home, "RED",3);
		assertEquals(false,is_movable);
	}
	
	@Test
	public void check_is_red_token_in_winning_square_movable_test() {
		Make_Move make_move_obj = new Make_Move();
		int[][] red_home = {{6,6}};
		boolean is_movable = make_move_obj.check_is_token_movable(red_home, "RED",6);
		assertEquals(false,is_movable);
	}
	
	@Test
	public void check_is_red_token_near_winning_square_2_dice_only_movable_test() {
		Make_Move make_move_obj = new Make_Move();
		int[][] red_home = {{8,8}};
		boolean is_movable = make_move_obj.check_is_token_movable(red_home, "RED",2);
		assertEquals(true,is_movable);
	}
	
	@Test
	public void check_is_red_token_in_winning_square_more_than_required_dice_movable_test() {
		Make_Move make_move_obj = new Make_Move();
		int[][] red_home = {{8,8}};
		boolean is_movable = make_move_obj.check_is_token_movable(red_home, "RED",6);
		assertEquals(false,is_movable);
	}
	
	
}
