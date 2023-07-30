/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Bookings;
import model.Location;
import model.LocationType;

/**
 *
 * @author Nguyen Van Ky
 */
public class BookingDAO {

    BaseDAO baseDAO = new BaseDAO();
    Connection conn = null;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String getTime = (dtf.format(now));

    public static void main(String[] args) throws SQLException {
        BookingDAO bdao = new BookingDAO();

        System.out.println(bdao.getTime);
    }

    // account
    public void addBooking(Bookings c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Booking VALUES (?,?,?,?,?)");
            stmt.setInt(1, c.getAcc_id());
            stmt.setInt(2, c.getLocation_id());
            stmt.setString(3, getTime);
            stmt.setInt(4, c.getMovie_id());
            stmt.setString(5, c.getTitle());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void updateBooking(Bookings c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("UPDATE Bookings set acc_id = ?,location_id=?,booking_date=? where booking_id=?");
            stmt.setInt(1, c.getAcc_id());
            stmt.setInt(2, c.getLocation_id());
            stmt.setString(3, c.getBooking_date());
            stmt.setInt(4, c.getBooking_id());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteBooking(String booking_id) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("Delete from Bookings where  booking_id=?");
            stmt.setString(1, booking_id);

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Bookings> bookingList(String acc_id) throws SQLException {
        List<Bookings> list = null;
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("Select * from Bookings  where acc_id = ?");
            stmt.setString(1, acc_id);

            list = new ArrayList<>();
            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            while (rs.next()) {
                Bookings bookings = new Bookings(rs.getInt("booking_id"), rs.getInt("acc_id"), rs.getInt("location_id"), rs.getNString("booking_date"), rs.getInt("movie_id"), rs.getString("title"));
                list.add(bookings);
            }
            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Bookings> getListBooking(int acc_id) throws SQLException {
        ArrayList<Bookings> bookings1 = new ArrayList<>();
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("Select * from Bookings  where acc_id  = ?");
            stmt.setInt(1, acc_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            while (rs.next()) {
                Bookings book = new Bookings(rs.getInt("booking_id"), rs.getInt("acc_id"), rs.getInt("location_id"), String.valueOf(rs.getDate("booking_date")), rs.getInt("movie_id"), rs.getString("title"));
                bookings1.add(book);
            }
            return bookings1;
            // close connection
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());;
        }
        return null;
    }
    
    public int getBookingIdByAccId(int acc_Id2){
        int BookingId;
        try {
            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("Select booking_id from Bookings  where acc_id  = ?");
            stmt.setInt(1, acc_Id2);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BookingId = rs.getInt("booking_id");
                return BookingId;
            }
            
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int getLocationIdByBookingId(int booking_id){
        int location_Id;
        try {
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("Select location_id from Bookings  where booking_id  = ?");
            stmt.setInt(1, booking_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                location_Id = rs.getInt("location_id");
                return location_Id;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    
    

}
