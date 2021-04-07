package dal.asdc.ludo_score_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;
import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;

/**
 * @author Reshma Unnikrishnan**/

public class Player_history{

	private final IPlayer_persistence iPlayer_persistence;

    @Autowired
    public Player_history(IPlayer_persistence player_persistence) {
        this.iPlayer_persistence = player_persistence;
    }
	
	public void save_player_history(IPlayer player) {
		this.iPlayer_persistence.save_record(player);
	}

	public List<Player> load_player_history() {
		return this.iPlayer_persistence.select_all_record();
	}
	
	public Player search_player_history_by_id(int plyr_id) {
		return this.iPlayer_persistence.filter_by_id(plyr_id);
	}
	
	public void update_record(int player_id, IPlayer player) {
		this.iPlayer_persistence.update_record(player_id, player);
	}
}
