/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDAO {

	private static String DB_URL = "jdbc:sqlserver://LAPTOP-08QLRN5V\\SQLEXPRESS:1433;" + "databaseName=CGV";
			
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123";

	/**
	 * main
	 * 
	 * @author viettuts.vn
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			// connnect to database 'testdb'
			Connection conn = getConnection();
			// crate statement
			Statement stmt = conn.createStatement();
			// get data from table 'student'
			ResultSet rs = stmt.executeQuery("select * from Categories");
			// show data
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " );
			}
			// close connection
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

       
}
