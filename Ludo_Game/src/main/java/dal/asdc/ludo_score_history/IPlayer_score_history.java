package dal.asdc.ludo_score_history;

public interface IPlayer_score_history {
	void save_player_history(int id);
	void load_player_history(int id);
	void form_player_score_board();
	void display_player_score_board();
}
