package dal.asdc.ludo_game_decide_players;

public class Display_board {
//	No_of_players num = new No_of_players();
//	int num_of_players = num.player_num();

	public String display_board(int num_of_players) {
		
		String board_type = "";
		
		if(num_of_players>0) {
			switch (num_of_players) 
			{
				case 2 :
					board_type="activate_red_yellow";
					break;
				case 3 :
					board_type="activate_red_green_yellow";
					break;
				case 4 :
					board_type="activate_all";
					break;
			}
		}
		
			return board_type;
		
	}
	
}
