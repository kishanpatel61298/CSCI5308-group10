package dal.asdc.dao;

import java.util.List;

import dal.asdc.model.Player;

/**
 * @author Reshma Unnikrishnan
 * */

public interface IDao {
	public void create_record(Player player);
	public List<Player> select_all_record();
	public void update_record(Integer player_id, Player player);
	public void filter_by_id();
}
