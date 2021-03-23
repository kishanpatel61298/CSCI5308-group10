package dal.asdc.game_conroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dal.asdc.game_handler.Game_Controller;
import dal.asdc.game_handler.Player;

public class Game_Controller_Test {
	
	@Test
	void constructor_test() {
		Game_Controller game_controller = Game_Controller.instance("two_player");
		
		assertEquals(false,game_controller.get_dice_rolled());
		Player current_player = game_controller.get_current_turn();
		assertEquals("RED",current_player.getColour());
		
		List<Player> player_list = new ArrayList<>();
		player_list = game_controller.get_total_player_list();
		assertEquals(2,player_list.size());
	}
}
