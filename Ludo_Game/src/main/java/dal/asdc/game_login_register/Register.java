package dal.asdc.game_login_register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dal.asdc.db_connection.Db_connection;

public class Register {
	Db_connection dbc = new Db_connection();
	Connection db_connection = null;
	PreparedStatement query_stmt = null;
	Scanner scanner = null;
	public static void main(String[] args) throws SQLException {	

		try {
			Register r = new Register();
			boolean is_user_available = false;
			// 0. read user input from command line: last name, first name and email
			r.scanner = new Scanner(System.in);

			System.out.print("Enter your name: ");
			String name = r.scanner.nextLine();

			System.out.print("Enter your email: ");
			String email = r.scanner.nextLine();
			
			System.out.print("Enter your password: ");
			String pwd = r.scanner.nextLine();

			r.db_connection = r.dbc.getConnection();

			is_user_available = r.check_user_existance(email);
		
			if(is_user_available) {
				System.out.print("User already avilable . Please login");
			}
			else {
				String sql = "insert into User "
						+ " (Name , Email_id,Password)" + " values (?, ?,?)";

				r.query_stmt = r.db_connection.prepareStatement(sql);

				// set parameters values
				r.query_stmt.setString(1, name);
				r.query_stmt.setString(2, email);
				r.query_stmt.setString(3, pwd);
				// 3. Execute SQL query
				r.query_stmt.executeUpdate();

				System.out.println("Registerd Successfull");
			}		
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			Register r = new Register();
			if (r.query_stmt != null) {
				r.query_stmt.close();
			}
			if (r.db_connection != null) {
				r.db_connection.close();
			}
			if (r.scanner != null) {
				r.scanner.close();
			}
		}
	}
	
	public boolean check_user_existance(String email) throws SQLException {
		String sql = "select * from User where Email_id = '" + email + "'";
		ResultSet rs;
		Statement query_stmt = null;
		Register r = new Register();
		r.db_connection = r.dbc.getConnection();
		query_stmt = r.db_connection.createStatement();
		rs = query_stmt.executeQuery(sql);
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
	}
}
