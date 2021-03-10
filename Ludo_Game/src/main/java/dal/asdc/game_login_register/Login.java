package dal.asdc.game_login_register;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dal.asdc.db_connection.Db_connection;

public class Login {
	public static void main(String[] args) throws SQLException {

		Db_connection dbc = new Db_connection();
		Connection db_connection = null;
		Statement query_stmt = null;
		Scanner scanner = null;

		try {
			Register register = new Register();
			scanner = new Scanner(System.in);
			System.out.print("Enter your email: ");
			String email = scanner.nextLine();
			
			System.out.print("Enter your password: ");
			String pwd = scanner.nextLine();
			db_connection = dbc.getConnection();
			query_stmt = db_connection.createStatement();
			String sql = "select * from User where Email_id = '" + email + "' and Password = '" + pwd + "'";
			ResultSet rs = query_stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("Login success");
			}
			else {
				System.out.println("Invalid username and password");
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (query_stmt != null) {
				query_stmt.close();
			}

			if (db_connection != null) {
				db_connection.close();
			}

			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
