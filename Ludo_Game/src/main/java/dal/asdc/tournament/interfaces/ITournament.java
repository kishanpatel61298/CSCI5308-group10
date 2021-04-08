package dal.asdc.tournament.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dal.asdc.model.Player;

public interface ITournament {
	
	public ArrayList<Player> get_tournament_players(Map<Integer, List<Integer>> group_map);
	public ArrayList<Player> form_next_round_players(List<Integer> winners_list);
	public void schedule_games(Map<Integer, List<Integer>> group_map);
	public Map<Integer, List<Integer>> form_further_round_groups(ArrayList<Player> next_round_players_list);
}
