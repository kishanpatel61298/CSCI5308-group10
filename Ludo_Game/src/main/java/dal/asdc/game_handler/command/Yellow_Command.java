package dal.asdc.game_handler.command;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.player.Human_player;
import dal.asdc.playing_pieces.Token;

public class Yellow_Command extends Command{

	@Override
	public Token execute() {
		for(Human_player player : player_list) {
			Human_player temp_player = player;
			if(temp_player.getColour().equals(Token_Colour.YELLOW.toString())) {
				Token token = get_token(temp_player,second_letter);
				return token;
			}
		}
		return null;
		
	}

}
