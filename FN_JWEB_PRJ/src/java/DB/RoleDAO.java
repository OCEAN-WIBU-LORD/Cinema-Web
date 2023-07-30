/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Role;

/**
 *
 * @author Administrator
 */
public class RoleDAO {
     BaseDAO baseDAO = new BaseDAO();
    Connection conn = null;
    public static void main(String[] args) throws SQLException {
        RoleDAO adao = new RoleDAO();
//        System.out.println(adao.getAccount("hoangadma", "123").getLastname());
    }
    
    // role
    public Role getRole(String role_id) throws SQLException  {
		Role a = null;
		try {
			BaseDAO db = new BaseDAO();
			// connnect to database 'testdb'
			 conn = db.getConnection();
			// crate statement
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Roles where role_id = ?");
                        stmt.setString(1,role_id);
                                     

			// get data from table
			ResultSet rs = stmt.executeQuery();
			// show data

			while (rs.next()) {
				a = new Role(rs.getInt("role_id"), rs.getString("role_name"));

			}
			// close connection
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
                    conn.close();
                }
		return a;
	}
    
    // end role
    
    
    
    // account role
    public Role getAccountRole(String acc_id) throws SQLException  {
		Role a = null;
		try {
			BaseDAO db = new BaseDAO();
			// connnect to database 'testdb'
			 conn = db.getConnection();
			// crate statement
			PreparedStatement stmt = conn.prepareStatement("Select r.* from Roles r  inner join Account_role ac on ac.acc_id = r.role_id where ac.acc_id = ?");
                        stmt.setString(1,acc_id);
                                     

			// get data from table
			ResultSet rs = stmt.executeQuery();
			// show data

			while (rs.next()) {
				a = new Role(rs.getInt("role_id"), rs.getString("role_name"));

			}
			// close connection
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
                    conn.close();
                }
		return a;
	}
    
    // end role
}
