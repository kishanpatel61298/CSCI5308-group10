package dal.asdc.game;

public class Make_Move {
	
	//this variables are not suppose to be here, but using as a mock data for development
	int[][] red_home = {{2,3},{3,3},{3,2},{2,2}};
	int[][] green_home = {{11,3},{12,3},{12,2},{11,2}};
	int[][] yellow_home = {{11,12},{11,11},{12,11},{12,12}};
	int[][] blue_home = {{2,12},{2,11},{3,12},{3,11}};
	
	int[][] winnig_square = {{6,6},{7,7},{8,8},{6,7},{7,6}};
	
	int[][] red_token_path = {{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8},{9,9}};
	
	public enum Colour{
		RED,
		GREEN,
		YELLOW,
		BLUE
	}
	
	public boolean check_is_token_movable(int[][] position, String token_colour,int dice_number) {
		if(is_token_at_home(position,token_colour) && dice_number==6) {
			move_token();
			return true;
		}
		System.out.println("here9");
		if(check_move_towards_winning_square(position,token_colour,dice_number)) {
			move_token();
			return true;
		}
		
		if(is_token_at_winning_square(position)) {
			return false;
		}
		return false;
	}
	
	private boolean check_move_towards_winning_square(int[][] position, String token_colour, int dice_number) {
		System.out.println("here");
		for(int i=0;i<red_token_path.length;i++) {
			System.out.println("here 5 "+red_token_path[i][0]+"  "+red_token_path[i][1]+"  "+position[0][0]+"  "+position[0][1]);
			if(red_token_path[i][0]==position[0][0] && red_token_path[i][1]==position[0][1]) {
				System.out.println("here 1"+i);
				if((i+dice_number)>red_token_path.length) {
					System.out.println("here 2");
					return false;
				}else {
					System.out.println("here 3");
					return true;
				}
			}
		}
		return false;
	}

	private boolean is_token_at_winning_square(int[][] position) {
		for(int i=0;i<5;i++) {
			if(winnig_square[i][0]==position[0][0] && winnig_square[i][1]==position[0][1]) {
				return true;
			}
		}
		return false;
	}

	public boolean is_token_at_home(int[][] position,String token_colour) {
		/*Token_positions token_positions = new Token_positions();
		token_positions.get_red_token_position()*/
		if(token_colour.equals(Colour.RED.toString())) {
			for(int i=0;i<4;i++) {
				if(red_home[i][0]==position[0][0] && red_home[i][1]==position[0][1]) {
						return true;
				}
			}
		}else if(token_colour.equals(Colour.GREEN.toString())) {
			for(int i=0;i<4;i++) {
				if(green_home[i][0]==position[0][0] && green_home[i][1]==position[0][1]) {
						return true;
				}
			}
		}else if(token_colour.equals(Colour.YELLOW.toString())) {
			for(int i=0;i<4;i++) {
				if(yellow_home[i][0]==position[0][0] && yellow_home[i][1]==position[0][1]) {
						return true;
				}
			}
		}else if(token_colour.equals(Colour.BLUE.toString())) {
			for(int i=0;i<4;i++) {
				if(blue_home[i][0]==position[0][0] && blue_home[i][1]==position[0][1]) {
						return true;
				}
			}
		}
		return false;
	}
	

	private void move_token() {
		//here check defeat
	}

}
