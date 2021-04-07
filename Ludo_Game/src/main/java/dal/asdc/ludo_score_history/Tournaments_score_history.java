package dal.asdc.ludo_score_history;

import java.util.HashMap;
import java.util.Map;

import dal.asdc.ludo_score_history.interfaces.IScore_history;
import dal.asdc.model.interfaces.ITournaments;
import dal.asdc.persistence.interfaces.IPlayer_persistence;
import dal.asdc.persistence.interfaces.ITournament_persistence;

/**
 * @author Reshma Unnikrishnan**/


public class Tournaments_score_history implements IScore_history{
	
	private final ITournament_persistence iTournament_persistence = null;
	ITournaments tournament;
	
	@Override
	public void save_history() {
		iTournament_persistence.create_record(tournament);
	}

	@Override
	public void load_history(int id) {
		iTournament_persistence.select_all_record();
	}

	@Override
	public Map<String,String> form_score_board() {
		Map<String,String> tournament_score_board = new HashMap<String,String>();
		return tournament_score_board;
		
	}

	
}
