package dal.asdc.dao.factory;

import dal.asdc.dao.Game_dao;
import dal.asdc.dao.Game_player_score_dao;
import dal.asdc.dao.JDBC_Connection;
import dal.asdc.dao.Player_dao;
import dal.asdc.dao.Tournament_dao;
import dal.asdc.dao.interfaces.IGame_dao;
import dal.asdc.dao.interfaces.IGame_player_score_dao;
import dal.asdc.dao.interfaces.IJDBC_Connection;
import dal.asdc.dao.interfaces.IPlayer_dao;
import dal.asdc.dao.interfaces.ITournament_dao;

public class Dao_factory {
	
	public IGame_dao create_game_dao() {
		return new Game_dao();
	}
	
	public IGame_player_score_dao create_game_player_score_dao() {
		return new Game_player_score_dao();
	}
	
	public IJDBC_Connection create_jdbc_connection() {
		return new JDBC_Connection();
	}
	
	public IPlayer_dao create_player_dao() {
		return new Player_dao();
	}

	public ITournament_dao create_tournament_dao() {
		return new Tournament_dao();
	}
}
