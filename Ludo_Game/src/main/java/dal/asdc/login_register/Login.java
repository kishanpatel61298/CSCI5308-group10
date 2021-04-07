package dal.asdc.login_register;

import dal.asdc.dao.Player_dao;
import dal.asdc.model.Player;

public class Login {

  public Player login(Player player) {
	  Player_dao plyr_dao = new Player_dao();
	  Player fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
	  return fatched_player;
  }
}
