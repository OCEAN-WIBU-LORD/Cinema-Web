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
import model.AccountType;

/**
 *
 * @author Administrator
 */
public class AccountDAO {

    BaseDAO baseDAO = new BaseDAO();
    Connection conn = null;

    public static void main(String[] args) throws SQLException {
        AccountDAO a = new AccountDAO();
        System.out.println(a.checkAccount("hoadngadma"));
    }

    // account
    public String checkAdmin(String acc_id) throws SQLException {
        String role = "";
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select r.role_name from(select ar.role_id from Accounts a inner join Account_role ar on a.acc_id = ar.acc_id where a.acc_id =?) as tb1 inner join Roles r on r.role_id = tb1.role_id ");
            stmt.setString(1, acc_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                role = rs.getString("role_name");

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
        return role;
    }

    public boolean checkAccount(String username) throws SQLException {
        Account a = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Accounts where username = ?");
            stmt.setString(1, username);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                return true;

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
        return false;
    }

    public Account getAccount(String username, String password) throws SQLException {
        Account a = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Accounts where username = ? and password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                a = new Account(rs.getInt("acc_id"), rs.getString("username"), rs.getString("password"), rs.getNString("firstname"), rs.getNString("lastname"), rs.getInt("age"), rs.getInt("gender"), rs.getString("email"), rs.getInt("points"), rs.getInt("account_type_id"));

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
        return a;
    }

    // end account
    // account_type
    public AccountType getAccountType(String account_type_id) throws SQLException {
        AccountType a = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Account_type where account_type_id = ? ");
            stmt.setString(1, account_type_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                a = new AccountType(rs.getInt("account_type_id"), rs.getString("account_type"));

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
        return a;
    }

    public void updateAccount(Account a) {
        try {

            conn = baseDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement("Update Accounts set username = ?,firstname =?,lastname=?,password=?,gender=?,email=?,age=? WHERE acc_id= ?");
            stmt.setString(1, a.getUsername());
            stmt.setString(2, a.getFirstname());
            stmt.setString(3, a.getLastname());
            stmt.setString(4, a.getPassword());
            stmt.setString(5, a.getGender() + "");
            stmt.setString(6, a.getEmail() + "");
            stmt.setString(7, a.getAge() + "");
            stmt.setString(8, a.getAcc_id() + "");

            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertAccount(String username, String password, String firstname, String lastname, String age, String gender, String email, String point, String account_type_id) {
        try {

            conn = baseDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO [dbo].[Accounts]\n"
                    + "           ([username]\n"
                    + "           ,[password]\n"
                    + "           ,[firstname]\n"
                    + "           ,[lastname]\n"
                    + "           ,[age]\n"
                    + "           ,[gender]\n"
                    + "           ,[email]\n"
                    + "           ,[points]\n"
                    + "           ,[account_type_id])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, username);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);
            stmt.setString(2, password);
            stmt.setString(6, gender);
            stmt.setString(7, email);
            stmt.setString(5, age);
            stmt.setString(8, "0");
            stmt.setString(9, "1");

            stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("insertAccount" + e.getMessage());
        }
    }

    public void insertRole(String acc_id) {
        try {

            conn = baseDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO [dbo].[Account_role]\n"
                    + "           ([acc_id]\n"
                    + "           ,[role_id])\n"
                    + "     VALUES\n"
                    + "           (?,?)");
            stmt.setString(1, acc_id);
            stmt.setString(2, "2");
            stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("insertRole" + e.getMessage());
        }
    }

    public String getAccId(String username) {
        String acc_id;
        try {

            conn = baseDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select acc_id from Accounts where username = ?");
            stmt.setString(1, username);
            stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                acc_id = String.valueOf(rs.getInt(1));

                return acc_id;
            }
        } catch (Exception e) {
            System.out.println("insertRole" + e.getMessage());
        }
        return null;
    }

    //end account_type
}
