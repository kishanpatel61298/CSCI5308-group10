package dal.asdc.playing_pieces;

public class Green_Token extends Token implements IToken{
	
	int[][] green_home = {{11,3},{12,3},{12,2},{11,2}};
	int[][] winning_square = {{6,6},{7,7},{8,8},{6,7},{7,6}};
	int[][] green_token_path = {{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8},{9,9}};

	public Green_Token(String token_colour) {
		super(token_colour);
		// TODO Auto-generated constructor stub
	}
	
	public boolean is_home() {
		int[][] selected_token_postion = {{getX_coordinate_position(),getY_coordinate_position()}};
		for(int i=0;i<4;i++) {
			if(green_home[i][0]==selected_token_postion[0][0] && green_home[i][1]==selected_token_postion[0][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean check_move_towards_winning_square(int dice_number) {
		int[][] selected_token_postion = {{getX_coordinate_position(),getY_coordinate_position()}};
		for(int i=0;i<green_token_path.length;i++) {
			if(green_token_path[i][0]==selected_token_postion[0][0] && green_token_path[i][1]==selected_token_postion[0][1]) {
				if((i+dice_number)>green_token_path.length) {
					return false;
				}else {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean is_at_winning_square() {
		int[][] selected_token_postion = {{getX_coordinate_position(),getY_coordinate_position()}};
		for(int i=0;i<5;i++) {
			if(winning_square[i][0]==selected_token_postion[0][0] && winning_square[i][1]==selected_token_postion[0][1]) {
				return true;
			}
		}
		return false;
	}


}
