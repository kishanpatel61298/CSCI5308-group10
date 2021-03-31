package dal.asdc.game;

import dal.asdc.playing_pieces.Token;

public interface ICheck_Move {
	boolean check_is_token_movable(Token selected_token,int dice_number);
}
