package dal.asdc.ludo_board_structure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dal.asdc.ludo_score_board.Player_history;

@SpringBootApplication
public class LudoGameApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LudoGameApplication.class, args);
		//pl_his.get_all_player_history();
	}

}
