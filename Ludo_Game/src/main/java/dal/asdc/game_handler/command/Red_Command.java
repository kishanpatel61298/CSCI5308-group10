package dal.asdc.game_handler.command;

import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;

public class Red_Command extends Command{

	@Override
	public Token execute() {
		for(Player player : player_list) {
			Player temp_player = player;
			if(temp_player.getColour().equals(Token_Colour.RED.toString())) {
				Token token = get_token(temp_player,second_letter);
				return token;
			}
		}
		return null;
	}

}