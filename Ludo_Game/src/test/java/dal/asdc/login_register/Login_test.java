package dal.asdc.login_register;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dal.asdc.dao.Player_dao;
import dal.asdc.model.Player;

public class Login_test {
	
	@Test
	 public void login_test() {
		  Player player = new Player();
		  player.setPlayer_email("test@gmail.com");
		  player.setPlayer_password("Admin@123");
		  Player_dao plyr_dao = new Player_dao();
		  Player fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
	      assertEquals(fatched_player.getPlayer_email(), player.getPlayer_email()) ;		  
	  }
}
