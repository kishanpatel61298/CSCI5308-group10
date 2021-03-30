package dal.asdc.dao;

import dal.asdc.model.Game_player_score;

public interface IGame_player_score_dao {
	public void insert_score(Game_player_score game_player_score);
	public Game_player_score get_player_score(int player_id);
	public Game_player_score get_game_score(int game_id);
}
