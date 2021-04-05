package dal.asdc.game_controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dal.asdc.game_handler.Ludo_Game;
import dal.asdc.player.Player;

public class Game_Controller_Test {
	
	@Test
	void constructor_test() {
		Map<Integer, String> player_id_list = new HashMap<>();
		Ludo_Game game_controller = Ludo_Game.instance("two_player",player_id_list);
		
		assertEquals(false,game_controller.get_dice_rolled());
		Player current_player = game_controller.get_current_turn();
		assertEquals("RED",current_player.getColour());
		
		List<Player> player_list = new ArrayList<>();
		player_list = game_controller.get_total_player_list();
		assertEquals(2,player_list.size());
	}
}
