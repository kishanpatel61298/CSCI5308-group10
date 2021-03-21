package dal.asdc.ludo_board_structure;

import java.util.HashMap;
import java.util.Map;

public class Token_positions {
	
	 static Map<String,String> red_token_positions_map = new HashMap<String,String>() {{
		    put("{2,3}","R1");
		    put("{3,3}","R2");
		    put("{3,2}","R3");
		    put("{2,2}","R4");
		}};;
	 static Map<String,String> green_token_positions_map = new HashMap<String,String>() {{
		 put("{11,3}","G1");
		 put("{12,3}","G2");
		 put("{12,2}","G3");
		 put("{11,2}","G4");
	 }};
	static Map<String,String> yellow_token_positions_map = new HashMap<String,String>() {{
		 put("{11,12}","Y1");
		 put("{11,11}","Y2");
		 put("{12,11}","Y3");
		 put("{12,12}","Y4");
	 }};;
	static Map<String,String> blue_token_positions_map = new HashMap<String,String>() {{
		 put("{2,12}","B1");
		 put("{2,11}","B2");
		 put("{3,12}","B3");
		 put("{3,11}","B4");
	 }};;

	
}
