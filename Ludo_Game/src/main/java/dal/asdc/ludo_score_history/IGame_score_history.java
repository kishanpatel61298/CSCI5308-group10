package dal.asdc.ludo_score_history;

public interface IGame_score_history {
	void save_game_history(int id);
	void load_game_history(int id);
	void form_game_score_board();
	void display_game_score_board();
}
