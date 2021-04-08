package dal.asdc.ludo_board_structure;

import dal.asdc.ludo_board_structure.interfaces.IToken_paths;

/**
 * @author Reshma Unnikrishnan**/

public class Token_paths implements IToken_paths{
	int[][] red_path_1 = {{1,6},{2,6},{3,6},{4,6},{5,6}};
	int[][] red_path_2 = {{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0},{8,0}};
	int[][] red_win_path = {{1,7},{2,7},{3,7},{4,7},{5,7}};
	int[][] green_path_1 = {{8,1},{8,2},{8,3},{8,4},{8,5}};
	int[][] green_path_2 = {{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{14,8}};
	int[][] green_win_path = {{7,1},{7,2},{7,3},{7,4},{7,5}};
	int[][] yellow_path_1 = {{13,8},{12,8},{11,8},{10,8},{9,8}};
	int[][] yellow_path_2 = {{8,9},{8,10},{8,11},{8,12},{8,13},{8,14},{7,14},{6,14}};
	int[][] yellow_win_path ={{13,7},{12,7},{11,7},{10,7},{9,7}};
	int[][] blue_path_1 = {{6,13},{6,12},{6,11},{6,10},{6,9}};
	int[][] blue_path_2 = {{5,8},{4,8},{3,8},{2,8},{1,8},{0,8},{0,7},{0,6}};
	int[][] blue_win_path = {{7,13},{7,12},{7,11},{7,10},{7,9}};
	
	public int[][] red_path = {{1,6},{2,6},{3,6},{4,6},{5,6},{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},
			{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{14,8},{13,8},{12,8},{11,8},{10,8},{9,8},{8,9},{8,10},{8,11},{8,12},{8,13}
			,{8,14},{7,14},{6,14},{6,13},{6,12},{6,11},{6,10},{6,9},{5,8},{4,8},{3,8},{2,8},{1,8},{0,8},{0,7},{1,7},{2,7},{3,7},{4,7},{5,7}};
	
	public int[][] green_path = {{8,1},{8,2},{8,3},{8,4},{8,5},{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{14,8},{13,8},{12,8},{11,8},{10,8},{9,8},
			{8,9},{8,10},{8,11},{8,12},{8,13},{8,14},{7,14},{6,14},{6,13},{6,12},{6,11},{6,10},{6,9},{5,8},{4,8},{3,8},{2,8},{1,8},{0,8},{0,7},{0,6},
			{1,6},{2,6},{3,6},{4,6},{5,6},{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5}};
	
	public int[][] yellow_path = {{13,8},{12,8},{11,8},{10,8},{9,8},{8,9},{8,10},{8,11},{8,12},{8,13},{8,14},{7,14},{6,14},{6,13},{6,12},{6,11},{6,10},{6,9},
			{5,8},{4,8},{3,8},{2,8},{1,8},{0,8},{0,7},{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0},{8,0},
			{8,1},{8,2},{8,3},{8,4},{8,5},{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{13,7},{12,7},{11,7},{10,7},{9,7}};
	
	public int[][] blue_path = {{6,13},{6,12},{6,11},{6,10},{6,9},{5,8},{4,8},{3,8},{2,8},{1,8},{0,8},{0,7},{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},
			{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{14,8},
			{13,8},{12,8},{11,8},{10,8},{9,8},{8,9},{8,10},{8,11},{8,12},{8,13},{8,14},{7,14},{7,13},{7,12},{7,11},{7,10},{7,9}};

	public int[][] total_path = {{1,6},{2,6},{3,6},{4,6},{5,6},{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0},{8,0},{1,7},{2,7},{3,7},{4,7},{5,7},
			{8,1},{8,2},{8,3},{8,4},{8,5},{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{14,8},{7,1},{7,2},{7,3},{7,4},{7,5},
			{13,8},{12,8},{11,8},{10,8},{9,8},{8,9},{8,10},{8,11},{8,12},{8,13},{8,14},{7,14},{6,14},{13,7},{12,7},{11,7},{10,7},{9,7},
			{6,13},{6,12},{6,11},{6,10},{6,9},{5,8},{4,8},{3,8},{2,8},{1,8},{0,8},{0,7},{0,6},{7,13},{7,12},{7,11},{7,10},{7,9},{2,3},{3,3},
			{3,2},{2,2},{11,3},{12,3},{12,2},{11,2},{11,12},{11,11},{12,11},{12,12},{2,12},{2,11},{3,12},{3,11}};
	
	public int[][] get_red_path(){
		return red_path;
	}
	
	public int[][] get_green_path(){
		return red_path;
	}
	
	public int[][] get_yellow_path(){
		return red_path;
	}
	
	public int[][] get_blue_path(){
		return red_path;
	}
	
	public int[][] get_total_path(){
		return red_path;
	}
}
