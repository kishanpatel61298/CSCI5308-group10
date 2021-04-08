package dal.asdc.tournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.asdc.model.Player;
import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

public class Mock_tournament {
	
	IPlayer_persistence player_dao = new Player_persistence();
	public static ArrayList<Player> players = new ArrayList<>();
	
	static List<Integer> group1 = new ArrayList<Integer>() {{
		add(1);
		add(2);
		add(3);
	}};
	
	static List<Integer> group2 = new ArrayList<Integer>() {{
		add(4);
		add(5);
		add(6);
	}};
	
	static List<Integer> group3 = new ArrayList<Integer>() {{
		add(7);
		add(8);
		add(9);
	}};
	
	static List<Integer> group4 = new ArrayList<Integer>() {{
		add(10);
		add(11);
		add(12);
	}};
	
	static List<Integer> group5 = new ArrayList<Integer>() {{
		add(9);
		add(10);
		add(11);
		add(12);
	}};
	
	 static Map<Integer, List<Integer>> group_map = new HashMap<Integer, List<Integer>>() {{
		 put(1,group1);
		 put(2,group2);
		 put(3,group3);
		 put(4,group4);
		}};;
		
	public void form_players() {
		Player player = new Player();
		for(int i =1; i<=12;i++) {
			player = player_dao.filter_by_id(i);
			players.add(player);
		}
	}
	
	static Map<Integer, List<Integer>> one_group_map = new HashMap<Integer, List<Integer>>() {{
		put(1,group1);
		}};;
		
	static Map<Integer, List<Integer>> group_map_ten_players = new HashMap<Integer, List<Integer>>() {{
		put(1,group1);
		put(2,group2);
		put(3,group5);
		}};;
	
	ArrayList<Integer> winners_list = new ArrayList() {{
		add(3);
		add(2);
		add(6);
		add(5);
		add(9);
		add(8);
		add(12);
		add(11);	
	}};
	
	
}
