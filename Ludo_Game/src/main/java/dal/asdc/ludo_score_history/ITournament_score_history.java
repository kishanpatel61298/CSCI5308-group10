package dal.asdc.ludo_score_history;

public interface ITournament_score_history {
	void save_tournament_history(int id);
	void load_tournament_history(int id);
	void form_tournament_score_board();
	void display_tournament_score_board();
}
