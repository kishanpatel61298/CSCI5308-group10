package dal.asdc.login_register;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import dal.asdc.dao.Player_dao;
import dal.asdc.model.Player;

public class Login_test {
	
	@Test
	 public void login_test() {
		  Player player = new Player();
		  boolean password_matched = false;
		  player.setPlayer_email("admin@gmail.com");
		  player.setPlayer_password("Admin@123");
		  Player_dao plyr_dao = new Player_dao();
		  Player fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
	      assertEquals(fatched_player.getPlayer_email(), player.getPlayer_email()) ;
	      password_matched = checkPass(player.getPlayer_password(), fatched_player.getPlayer_password());
	      assertEquals(password_matched, true) ;
	  }
	
	private boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}

}

