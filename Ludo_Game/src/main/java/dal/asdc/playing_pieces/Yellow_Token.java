package dal.asdc.playing_pieces;

import dal.asdc.ludo_board_structure.Token_paths;

public class Yellow_Token extends Token{
	
	static int[][] yellow_home = {{11,12},{11,11},{12,11},{12,12}};
	int[][] winning_square = {{7,7}};
	int[][] yellow_token_path ;

	public Yellow_Token(int numer_of_token) {
		super("YELLOW",numer_of_token,yellow_home[numer_of_token][0],yellow_home[numer_of_token][1]);
		create_path();
	}
	
	private void create_path() {
		Token_paths paths = new Token_paths();
		//int[][] first_partial_path = new int();
		yellow_token_path = paths.yellow_path;
	}
	
	public boolean is_home() {
		int[][] selected_token_postion = get_coordinate_position();
		for(int i=0;i<4;i++) {
			if(yellow_home[i][0]==selected_token_postion[0][0] && yellow_home[i][1]==selected_token_postion[0][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean check_move_towards_winning_square(int dice_number) {
		int[][] selected_token_postion = get_coordinate_position();
		for(int i=0;i<yellow_token_path.length;i++) {
			if(yellow_token_path[i][0]==selected_token_postion[0][0] && yellow_token_path[i][1]==selected_token_postion[0][1]) {
				if((i+dice_number)>yellow_token_path.length) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean is_at_winning_square() {
		int[][] selected_token_postion = get_coordinate_position();
		for(int i=0;i<5;i++) {
			if(winning_square[i][0]==selected_token_postion[0][0] && winning_square[i][1]==selected_token_postion[0][1]) {
				return true;
			}
		}
		return false;
	}
	
	public int[][] get_token_path(){
		return yellow_token_path;
	}
	
	public int[][] get_winning_square(){
		return yellow_token_path;
	}
	
	public void set_at_home() {
		int token_number = get_token_number();
		int[][] perfect_home_cordinates = {{yellow_home[token_number][0],yellow_home[token_number][1]}};
		set_coordinate_position(perfect_home_cordinates);
		set_is_token_at_home(true);
	}
}
