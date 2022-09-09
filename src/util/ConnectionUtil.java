package util;

import java.sql.*;

public class ConnectionUtil {
	private static Connection con;
	
	public static Connection getConnection() {
		String database = "postgres";
		String url = "jdbc:postgresql://localhost:5432/" + database;
		String user = "postgres";
		String password = "postgres";

		try {
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(con != null)
			System.out.println("Conectado ao banco de dados " + database);
		
		return con;
	}
	
	public static void closeConnection() throws SQLException {
		con.close();
	}
}
