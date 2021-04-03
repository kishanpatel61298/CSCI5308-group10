package dal.asdc.tournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dal.asdc.dao.Player_dao;
import dal.asdc.dao.interfaces.IPlayer_dao;
import dal.asdc.model.Player;

public class Tournament {
	
	public void game() {}
	public void form_groups() {}
	
	IPlayer_dao player_dao = new Player_dao();
	
	public ArrayList<Player> tournament_players_list = new ArrayList();
	
	int rounds = 0;
	
	static List<Integer> plyr1 = new ArrayList<Integer>() {{
		add(1);
		add(2);
		add(3);
	}};
	
	static List<Integer> plyr2 = new ArrayList<Integer>() {{
		add(4);
		add(5);
		add(6);
	}};
	
	static List<Integer> plyr3 = new ArrayList<Integer>() {{
		add(7);
		add(8);
		add(9);
	}};
	
	static List<Integer> plyr4 = new ArrayList<Integer>() {{
		add(10);
		add(11);
		add(12);
	}};
	
	 static Map<Integer, List<Integer>> group_map = new HashMap<Integer, List<Integer>>() {{
		 put(1,plyr1);
		 put(2,plyr2);
		 put(3,plyr3);
		 put(4,plyr4);
		}};;
	
	
	public ArrayList<Player> get_tournament_players(Map<Integer, List<Integer>> group_map){
		group_map.forEach((k,v)->{
			for(int i=0;i<v.size();i++) {
				Player player = new Player();
				player = player_dao.filter_by_id(v.get(i));
				tournament_players_list.add(player);
			}
		});
		return tournament_players_list;
	}
	
	public ArrayList<Player> form_next_round_players(List<Integer> winners_list){
		ArrayList<Player> next_round_players_list = new ArrayList();
		for(int i =0;i<winners_list.size();i++) {
			Player player = new Player();
			player = player_dao.filter_by_id(winners_list.get(i));
			System.out.println("Player id : "+player.getPlayer_id());
			next_round_players_list.add(player);
		};
		System.out.println("next_round_players_list inisde func : "+next_round_players_list.size());
		return next_round_players_list;
	}
	
	
	public void schedule_games(Map<Integer, List<Integer>> group_map) {
		int num_of_groups = group_map.size();
		
		Map<Integer,List<Integer>> next_group = new HashMap<Integer,List<Integer>>();
		if(num_of_groups != 1) {
			ArrayList<Player> next_round_players_list = new ArrayList();
			ArrayList<Integer> winners_list = new ArrayList();
		group_map.forEach((k,v) -> {
			Map<String,Integer> winner_map = new HashMap<String,Integer>();
			System.out.println("Group : "+k+ "Round : "+ rounds+1);
			winner_map = game(v);
			winner_map.forEach((w,id) -> {
				winners_list.add(id);
			}); 
		});
			next_round_players_list = form_next_round_players(winners_list);
			next_group = form_further_round_groups(next_round_players_list);
			schedule_games(next_group);
			rounds=rounds+1;
		}else {
			group_map.forEach((k,v) -> {
				Map<String,Integer> winner_map = new HashMap<String,Integer>();
				winner_map = game(v);
				winner_map.forEach((w,id) -> {
					System.out.println(w+" --- "+id);
				}); 
			});
		}
	}

	
	public Map<Integer, List<Integer>> form_further_round_groups(ArrayList<Player> next_round_players_list){
		List<Integer> player_id_list = new ArrayList<Integer>();
		System.out.println("next_round_players_list.size() : "+next_round_players_list.size());
		for(int i =0;i<next_round_players_list.size();i++) {
			Player plyr = new Player();
			plyr = next_round_players_list.get(i);
			player_id_list.add(plyr.getPlayer_id());
		}
		
		int temp = player_id_list.size()%4;
		Map<Integer,List<Integer>> next_group = new HashMap<Integer,List<Integer>>();
		if(temp > 2 || temp == 0) {
			int num_of_groups = (player_id_list.size()+3)/4;
			int start = 0;
			for(int i = 0;i<num_of_groups;i++) {
				List<Integer> group_list = new ArrayList<Integer>();
				for(int j = start; j<start+4;j++) {
					try {
					group_list.add(player_id_list.get(j));
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Reached the end of the list");
					} 
				}
				next_group.put(i, group_list);
				start+=4;
			}
			System.out.println("Next group list");
			next_group.forEach((k,v) -> {
				System.out.println(k+" -- "+v);
			});
		}else {
			int num_of_groups = (player_id_list.size()+3)/4;
			System.out.println("group size : "+num_of_groups);
			int start = 0;
			for(int i = 0;i<num_of_groups;i++) {
				List<Integer> group_list = new ArrayList<Integer>();
				System.out.println("start+(player_id_list.size()/2) : "+start+(player_id_list.size()/2));
				for(int j = start; j<start+(player_id_list.size()/2);j++) {
					System.out.println("Start value 1 : "+start);
					try {
						System.out.println("J value : "+j);
					group_list.add(player_id_list.get(j));
					
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Reached the end of the list");
					} 
				}
				next_group.put(i, group_list);
				start = start+(player_id_list.size()/2);
				System.out.println("Start value 2 : "+start);
			}
			System.out.println("Next group list");
			next_group.forEach((k,v) -> {
				System.out.println(k+" -- "+v);
			});
		}
		player_id_list.clear();
		return next_group;
	}
	
	public Map<String,Integer> game (List<Integer> players_id){
		System.out.println("Game started");
		Map<String,Integer> winner_map = new HashMap<String,Integer>();
		winner_map.put("Winner",players_id.get(1));
		winner_map.put("Runner",players_id.get(2));
		return winner_map;
	}
	
	public static void main(String args[]) {
		Tournament tr = new Tournament();
		tr.schedule_games(group_map);
	}
	
}
