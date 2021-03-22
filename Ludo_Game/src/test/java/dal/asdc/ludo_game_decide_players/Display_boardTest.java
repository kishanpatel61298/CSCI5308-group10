package dal.asdc.ludo_game_decide_players;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Display_boardTest {
	
	private Display_board dis_board;
	
	@BeforeEach
	void initEach() {
		dis_board = new Display_board();
	}
	@Test
	void testDisplay_board() {

		assertEquals("activate_red_yellow",dis_board.display_board(2));
	}

}
