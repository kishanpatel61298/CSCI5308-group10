package dal.asdc.playing_pieces.factoy_method;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.playing_pieces.Blue_Token;
import dal.asdc.playing_pieces.Green_Token;
import dal.asdc.playing_pieces.Red_Token;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.Yellow_Token;

public class Token_Factory {
	
	public Token crete_red_token(int number_of_token) {
		return new Red_Token(number_of_token);
	}
	
	public Token crete_green_token(int number_of_token) {
		return new Green_Token(number_of_token);
	}
	
	public Token crete_blue_token(int number_of_token) {
		return new Blue_Token(number_of_token);
	}
	
	public Token crete_yellow_token(int number_of_token) {
		return new Yellow_Token(number_of_token);
	}
}
