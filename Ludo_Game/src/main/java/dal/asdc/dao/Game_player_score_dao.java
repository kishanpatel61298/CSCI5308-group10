package dal.asdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dal.asdc.model.Game_player_score;

public class Game_player_score_dao implements IGame_player_score_dao{
	
	@Override
	public void insert_score(Game_player_score game_player_score) {
		IJDBC_Connection jdbc = new JDBC_Connection();
		String create_query = "INSERT into Game_player_score (score_id, game_id, player_id, score) "
				+ "values(?,?,?,?)";
		try {
			Connection conn = jdbc.createDBConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(create_query);
			preparedStatement.setString(1, game_player_score.getScore_id());
            preparedStatement.setInt(2, game_player_score.getGame_id());
            preparedStatement.setInt(3, game_player_score.getPlayer_id());
            preparedStatement.setInt(4, game_player_score.getScore());
            preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Game_player_score get_player_score(int player_id) {
		IJDBC_Connection jdbc = new JDBC_Connection();
		String filter_by_id_query = "SELECT * from Game_player_score where player_id = ?";
		 try{
			 Connection conn = jdbc.createDBConnection();
	         PreparedStatement preparedStatement = conn.prepareStatement(filter_by_id_query);
	         preparedStatement.setInt(1, player_id);
	         try (ResultSet resultSet = preparedStatement.executeQuery()) {
	        	 Game_player_score game_player_score = null;
	             	if (resultSet.next()) {
	             		game_player_score = new Game_player_score();
	             		game_player_score.setScore_id(resultSet.getString("score_id"));
	             		game_player_score.setGame_id(resultSet.getInt("game_id"));
	             		game_player_score.setPlayer_id(resultSet.getInt("player_id"));
	             		game_player_score.setScore(resultSet.getInt("score"));
	                }
	                return game_player_score;
	            }
	        } catch (SQLException sqlException) {
	            throw new RuntimeException(sqlException);
	        }
	}

	@Override
	public Game_player_score get_game_score(int game_id) {
		IJDBC_Connection jdbc = new JDBC_Connection();
		String filter_by_id_query = "SELECT * from Game_player_score where game_id = ?";
		 try{
			 Connection conn = jdbc.createDBConnection();
	         PreparedStatement preparedStatement = conn.prepareStatement(filter_by_id_query);
	         preparedStatement.setInt(1, game_id);
	         try (ResultSet resultSet = preparedStatement.executeQuery()) {
	        	 Game_player_score game_player_score = null;
	             	if (resultSet.next()) {
	             		game_player_score = new Game_player_score();
	             		game_player_score.setScore_id(resultSet.getString("score_id"));
	             		game_player_score.setGame_id(resultSet.getInt("game_id"));
	             		game_player_score.setPlayer_id(resultSet.getInt("player_id"));
	             		game_player_score.setScore(resultSet.getInt("score"));
	                }
	                return game_player_score;
	            }
	        } catch (SQLException sqlException) {
	            throw new RuntimeException(sqlException);
	        }
	}
}
