package dal.asdc.playing_pieces;

public interface IToken {
	boolean is_home();
	boolean check_move_towards_winning_square( int dice_number);
	boolean is_at_winning_square();
}
