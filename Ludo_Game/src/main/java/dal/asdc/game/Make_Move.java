package dal.asdc.game;

import dal.asdc.playing_pieces.Green_Token;
import dal.asdc.playing_pieces.IToken;
import dal.asdc.playing_pieces.Red_Token;

public class Make_Move {
	
	Check_Move check_move = new Check_Move();
	
	public void check_moving_path() {
		IToken token = new Green_Token("GREEN");
		if(check_move.check_is_token_movable(token, 6)){
			make_move(token,6);
		}else {
			System.out.print("You can't play this token");
		}
	}
	
	public void make_move(IToken selected_token, int dice_number) {
		
	}

}
