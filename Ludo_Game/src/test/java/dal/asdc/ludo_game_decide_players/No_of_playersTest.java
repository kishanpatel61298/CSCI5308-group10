package dal.asdc.ludo_game_decide_players;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class No_of_playersTest {

	private No_of_players nop;
	
	@BeforeEach
	void initEach() {
		nop = new No_of_players();
	}
	
	@Test
	void testPlayer_num() {
		String input = "4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals(4,nop.player_num());
	}

}
