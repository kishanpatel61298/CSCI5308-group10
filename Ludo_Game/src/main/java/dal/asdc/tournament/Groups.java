package dal.asdc.tournament;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import dal.asdc.dao.Player_dao;
import dal.asdc.model.Player;

public class Groups {
 private Player_dao plyr_dao = new Player_dao();
 List<Integer> player_list = new ArrayList<>();
 
 public Map<Integer, Collection<List<Player>>> form_tournaments_group() {
	 Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
	 int no_of_players = 0;
	 do{
		 System.out.print("Enter number of players - ");  
		 no_of_players = sc.nextInt(); 
     }
     while( !(no_of_players > 1) );
	 if(no_of_players > 1) {
		 System.out.print("Input Accepted. Forming groups... ");  
	 }
	 player_list = plyr_dao.select_n_players(no_of_players);	
	 Map<Integer, Collection<List<Player>>> map = new HashMap<>();
	 final AtomicInteger counter = new AtomicInteger();
	 final Collection<List<Integer>> result = player_list.stream()
	     .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 4))
	     .values();
	 Object[] resultant_players = result.toArray();
	 for (int i = 0; i < resultant_players.length; i++) {
		  map.put(i+1 , (Collection<List<Player>>) resultant_players[i]);
	 }
	 System.out.println(map);
	 return map;
 }
}
