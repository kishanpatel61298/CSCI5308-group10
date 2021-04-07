package dal.asdc.persistence.interfaces;

import java.util.List;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;

/**
 * @author Reshma Unnikrishnan
 * */

public interface IPlayer_persistence {
	public void save_record(IPlayer player);
	public List<Player> select_all_record();
	public void update_record(int player_id, IPlayer player);
	public Player filter_by_id(int player_id);
}

