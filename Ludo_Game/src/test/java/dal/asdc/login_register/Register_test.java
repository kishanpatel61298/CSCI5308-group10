package dal.asdc.login_register;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dal.asdc.dao.Player_dao;
import dal.asdc.model.Player;

public class Register_test {
	@Test
	public void register_test() {
		Player player = new Player();
		Player_dao plyr_dao = new Player_dao();
		player.setPlayer_email("test@gmail.com");
		player.setPlayer_password("Admin@123");
		player.setPlayer_name("Test User");
		plyr_dao.save_record(player);
		Player fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
		System.out.print(fatched_player);
		assertEquals(fatched_player.getPlayer_email(), player.getPlayer_email());
	}
}
