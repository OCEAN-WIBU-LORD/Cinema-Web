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
import model.Account;
import model.Category;
import model.Movie_category;

/**
 *
 * @author Administrator
 */
public class CategoryDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection conn = null;

    public static void main(String[] args) throws SQLException {
        CategoryDAO adao = new CategoryDAO();
        System.out.println(adao.getMovieCategory("1").get(0).getCate_id());
    }

    // category
     public void addCategory(Category c) throws SQLException {
        try {
          
            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Categories VALUES (?)");
            stmt.setNString(1, c.getCate_name());
            // get data from table
           stmt.executeUpdate();
            // show data
            
           
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
       
    }
     
     
    
    
    
    public List<Category> getAllCategory() throws SQLException {
        List<Category> list = null;
        try {
          
            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Categories");
   
            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Category a =  new Category(rs.getInt("cate_id"), rs.getString("cate_name"));
                list.add(a);

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return list;
    }
    
    
    public Category getCategoryByID(String cate_id) throws SQLException {
        Category a = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Categories where cate_id =  ?");
            stmt.setString(1, cate_id);


            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                a = new Category(rs.getInt("cate_id"), rs.getString("cate_name"));

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    
    //end category
    
    
        public List<Movie_category> getMovieCategory() throws SQLException {
        List<Movie_category> list = null;
        try {
          
            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Movie_category");
   
            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie_category a =  new Movie_category(rs.getInt("movie_id"), rs.getInt("cate_id"));
                list.add(a);

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return list;
    }
        
        
        public List<Movie_category> getMovieCategory(String movie_id) throws SQLException {
        List<Movie_category> list = null;
        try {
          
            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Movie_category where movie_id = ?");
   stmt.setString(1, movie_id);
            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie_category a =  new Movie_category(rs.getInt("movie_id"), rs.getInt("cate_id"));
                list.add(a);

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return list;
    }
        
        public boolean getCheckMovieCategory(Movie_category c) throws SQLException {
   boolean check = false;
        try {
          
            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Movie_category where movie_id=? and cate_id= ?");
            stmt.setInt(1,c.getMovie_id());
                    stmt.setInt(2,c.getCate_id());
            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            Movie_category a = null;
             while (rs.next()) {
                 a =  new Movie_category(rs.getInt("movie_id"), rs.getInt("cate_id"));
               

            }
             if(a != null ){
                 return true;
             }else{
                 return false;
             }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }

}
