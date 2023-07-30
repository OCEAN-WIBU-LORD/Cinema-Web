/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Account;
import model.Actor;
import model.Slide;

/**
 *
 * @author Administrator
 */
public class ActorDAO {

    BaseDAO baseDAO = new BaseDAO();
    Connection conn = null;

    public static void main(String[] args) throws SQLException {
        AccountDAO adao = new AccountDAO();
        System.out.println(adao.getAccount("hoangadma", "123").getLastname());
    }

    // account
    public void addMovieSlider(Actor c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Actors VALUES (?,?,?,?,?)");
            stmt.setNString(1, c.getFirstname());
            stmt.setNString(2, c.getLastname());
            stmt.setInt(3, c.getAge());
            stmt.setInt(4, c.getGender());
            stmt.setNString(5, c.getCountry());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Actor getActorById(String actor_id) throws SQLException {
        Actor a = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Actors where actor_id = ?");
            stmt.setString(1, actor_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                a = new Actor(rs.getInt("actor_id"),
                        rs.getNString("firstname"),
                        rs.getNString("lastname"),
                        rs.getInt("age"),
                        rs.getInt("gender"),
                        rs.getString("country"));

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public List<Actor> getAllActor() throws SQLException {
        List<Actor> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Actors");

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                Actor a = null;
                a = new Actor(rs.getInt("actor_id"),
                        rs.getNString("firstname"),
                        rs.getNString("lastname"),
                        rs.getInt("age"),
                        rs.getInt("gender"),
                        rs.getString("country"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // end actor
}
