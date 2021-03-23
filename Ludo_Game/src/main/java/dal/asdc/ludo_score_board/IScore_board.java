package dal.asdc.ludo_score_board;

public interface IScore_board {
	void save_score(int id);
	void retrieve_score(int id);
	void form_score_board();
	void display_score_board();
}
