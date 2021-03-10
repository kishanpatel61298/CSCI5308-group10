package dal.asdc.db_connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connection {
	public Connection getConnection() {
		String url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_10_DEVINT";
		String user = "CSCI5308_10_DEVINT_USER";
		String password = "c5SZhk8dfmzXT9eN";
		   Connection db_connection = null;
		   try {
			db_connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return db_connection;
		 }
}
