package dal.asdc.playing_pieces;

public class Red_Token extends Token implements IToken{
	
	int[][] red_home = {{2,3},{3,3},{3,2},{2,2}};
	int[][] winning_square = {{6,6},{7,7},{8,8},{6,7},{7,6}};
	int[][] red_token_path = {{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8},{9,9}};

	public Red_Token(int numer_of_token,int[][] position) {
		//change the constructor by passing "red" and red_home[0]..[1].. in Prabhnoor's token.java"
		//super("RED",red_home[number_of_token])
		super("RED");
		setX_coordinate_position(position[0][0]);
		setY_coordinate_position(position[0][1]);
	}
	
	public boolean is_home() {
		int[][] selected_token_postion = {{getX_coordinate_position(),getY_coordinate_position()}};
		for(int i=0;i<4;i++) {
			if(red_home[i][0]==selected_token_postion[0][0] && red_home[i][1]==selected_token_postion[0][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean check_move_towards_winning_square(int dice_number) {
		int[][] selected_token_postion = {{getX_coordinate_position(),getY_coordinate_position()}};
		for(int i=0;i<red_token_path.length;i++) {
			if(red_token_path[i][0]==selected_token_postion[0][0] && red_token_path[i][1]==selected_token_postion[0][1]) {
				if((i+dice_number)>red_token_path.length) {
					return true;
				}else {
					return false;
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
