package dal.asdc.ludo_game_decide_players;

import java.util.Scanner;

public class No_of_players {
	
	public int player_num() {
		System.out.println("Enter number of players from 2-4 : ");
		Scanner sc= new Scanner(System.in);
		int players_num = sc.nextInt();
		sc.close();
		return players_num;
	}

}
