package dal.asdc.login_register;

import org.mindrot.jbcrypt.BCrypt;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

public class Login {

  public Player login(IPlayer player) {
	  IPlayer_persistence plyr_dao = new Player_persistence();
	  Player fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
	  if(fatched_player!=null &&  check_password(player.getPlayer_password(), fatched_player.getPlayer_password())) {
		  return fatched_player;
	  }
	  else {
		  return null;
	  }
  }
  
  private boolean check_password(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;			
		else
			return false;
	}
}
