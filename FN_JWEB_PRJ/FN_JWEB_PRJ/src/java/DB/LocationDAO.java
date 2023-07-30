/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Actor;
import model.Location;
import model.LocationPosition;
import model.LocationType;
import model.Positions;

/**
 *
 * @author Nguyen Van Ky
 */
public class LocationDAO {

    BaseDAO baseDAO = new BaseDAO();
    Connection conn = null;

    public static void main(String[] args) throws SQLException {
        LocationDAO adao = new LocationDAO();
        System.out.println(adao.getListLocationPositions("1").get(0).getLocation_name());
    }

    // account
    public void addLocation(Location c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Locations VALUES (?,?,?,?,?,?,?)");
            stmt.setNString(1, c.getLocation_name());
            stmt.setInt(2, c.getLocation_type_id());
            stmt.setInt(3, c.getPosition_id());
            stmt.setInt(4, c.getMovie_id());
            stmt.setString(5, c.getMovie_show_time());
            stmt.setString(6, c.getMovie_show_date());
            stmt.setInt(7, c.getTicket_count());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    
    
    public void addLocatioType(LocationType c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Location_type VALUES (?)");
            stmt.setNString(1, c.getLocation_type());
            

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    public List<LocationType> getListLationType() throws SQLException {
        List<LocationType> list= null;
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Location_type");
            

            // get data from table
            ResultSet rs = stmt.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                LocationType locationType = new LocationType(rs.getInt("location_type_id"), rs.getNString("location_type"));
                list.add(locationType);
            }
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
   
    
     public void addLPosition(Positions c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Positions VALUES (?)");
            stmt.setNString(1, c.getPosition());
            

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    
    public Location getLocationById(String location_id) throws SQLException {
        Location a = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Locations where location_id = ?");
            stmt.setString(1, location_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                a = new Location(rs.getInt("location_id"),
                        rs.getNString("location_name"),
                        rs.getInt("location_type_id"),
                        rs.getInt("position_id"),
                        rs.getInt("movie_id"),
                        rs.getString("movie_show_time"),
                rs.getString("movie_show_date"),
                rs.getInt("ticket_count"));

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    
    public List<Location> getListLocation() throws SQLException {
        List<Location> list = null;
        
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Locations");

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            list = new ArrayList<>();
            while (rs.next()) {
                Location a = null;
                a = new Location(rs.getInt("location_id"),
                        rs.getNString("location_name"),
                        rs.getInt("location_type_id"),
                        rs.getInt("position_id"),
                        rs.getInt("movie_id"),
                        rs.getString("movie_show_time"),
                rs.getString("movie_show_date"),
                rs.getInt("ticket_count"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
     public List<Positions> getListPositions() throws SQLException {
        List<Positions> list = null;
        
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Positions");
    

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            list = new ArrayList<>();
            while (rs.next()) {
                Positions a = null;
                a = new Positions(rs.getInt("position_id"),
                        rs.getNString("position"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
     
     
     public List<LocationPosition> getListLocationPositions(String movie_id) throws SQLException {
        List<LocationPosition> list = null;
        
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from (select l.*,p.position from Locations l inner join Positions p on p.position_id = l.position_id) as tb1 inner join Location_type lt on tb1.location_type_id = lt.location_type_id  where movie_id = 1");
    

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            list = new ArrayList<>();
            while (rs.next()) {
                LocationPosition a = null;
                a = new LocationPosition(rs.getString("location_id"),
                rs.getNString("location_name"),
                rs.getNString("position"),
                rs.getNString("location_type"),
                rs.getString("movie_id"),
                rs.getString("movie_show_time"),
                rs.getString("movie_show_date"),
                rs.getString("ticket_count"));
                
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
