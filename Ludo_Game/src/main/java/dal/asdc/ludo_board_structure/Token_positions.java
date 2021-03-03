package dal.asdc.ludo_board_structure;

import java.util.HashMap;
import java.util.Map;

public class Token_positions {
	
	 Map<String,String> red_token_positions_map = new HashMap<String,String>();
	 Map<String,String> green_token_positions_map = new HashMap<String,String>();
	 Map<String,String> yellow_token_positions_map = new HashMap<String,String>();
	 Map<String,String> blue_token_positions_map = new HashMap<String,String>();
	
	public void set_red_token_positions() {
		red_token_positions_map.put("R1","{2,3}");
		red_token_positions_map.put("R2","{3,3}");
		red_token_positions_map.put("R3","{3,2}");
		red_token_positions_map.put("R4","{2,2}");
	}

	public void set_green_token_positions() {
		green_token_positions_map.put("G1","{11,3}");
		green_token_positions_map.put("G2","{12,3}");
		green_token_positions_map.put("G3","{12,2}");
		green_token_positions_map.put("G4","{11,2}");
	}
	
	public void set_yellow_token_positions() {
		yellow_token_positions_map.put("Y1","{11,12}");
		yellow_token_positions_map.put("Y2","{11,11}");
		yellow_token_positions_map.put("Y3","{12,11}");
		yellow_token_positions_map.put("Y4","{12,12}");
	}

	public void set_blue_token_positions() {
		blue_token_positions_map.put("B1","{2,12}");
		blue_token_positions_map.put("B2","{2,11}");
		blue_token_positions_map.put("B3","{3,12}");
		blue_token_positions_map.put("B4","{3,11}");
	}

}
