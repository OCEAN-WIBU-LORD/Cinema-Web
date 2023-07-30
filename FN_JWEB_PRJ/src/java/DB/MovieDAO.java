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
import javafx.scene.control.Slider;
import model.Account;
import model.Category;
import model.Movie;
import model.MovieActor;
import model.Movie_category;
import model.Slide;

/**
 *
 * @author Administrator
 */
public class MovieDAO {

    BaseDAO baseDAO = new BaseDAO();
    Connection conn = null;

    public static void main(String[] args) throws SQLException {
        MovieDAO adao = new MovieDAO();
        adao.deleteMovie("11");
    }

    // Movie
    public void deleteMovieCategory(String movie_id, String cate_id) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement(" delete from Movie_category where movie_id =? and cate_id =? ");

            stmt.setString(1, movie_id);
            stmt.setString(2, cate_id);
            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteMovie(String movie_id) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement(" delete from Movies where movie_id =? ");

            stmt.setString(1, movie_id);
            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteMovieCate(String movie_id, String cate_id) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement(" delete from Movie_category where movie_id =? and cate_id=?");

            stmt.setString(1, movie_id);
            stmt.setString(2, cate_id);
            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void updateMovie(Movie c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement(" update Movies set title = ?, [description] = ?,time_show=?,subtitle=?,poster=?,request=?,rated=?,viewers=?,premiere=?,country=?,directed_by=?,status_movie=?   where movie_id =? ");

            stmt.setString(1, c.getTitle());
            stmt.setNString(2, c.getDescription());
            stmt.setString(3, c.getTime_show());
            stmt.setNString(4, c.getSubtitle());
            stmt.setString(5, c.getPoster());
            stmt.setNString(6, c.getRequest());
            stmt.setDouble(7, c.getRated());
            stmt.setInt(8, c.getViewer());
            stmt.setString(9, c.getPremiere());
            stmt.setNString(10, c.getCountry());
            stmt.setNString(11, c.getDirected_by());
            stmt.setString(12, c.getStatus_movie());
            stmt.setInt(13, c.getMovie_id());
            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addMovie(Movie c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Movies VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, c.getTitle());
            stmt.setNString(2, c.getDescription());
            stmt.setString(3, c.getTime_show());
            stmt.setNString(4, c.getSubtitle());
            stmt.setString(5, c.getPoster());
            stmt.setNString(6, c.getRequest());
            stmt.setDouble(7, c.getRated());
            stmt.setInt(8, c.getViewer());
            stmt.setString(9, c.getPremiere());
            stmt.setNString(10, c.getCountry());
            stmt.setNString(11, c.getDirected_by());
            stmt.setString(12, c.getStatus_movie());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addMovieCategory(Movie_category c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Movie_category VALUES (?,?)");
            stmt.setInt(1, c.getMovie_id());
            stmt.setInt(2, c.getCate_id());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addMovieActor(MovieActor c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Movie_actor VALUES (?,?,?)");
            stmt.setInt(1, c.getActor_id());
            stmt.setInt(2, c.getMovie_id());
            stmt.setString(3, c.getActor_role_name());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addMovieSlider(Slide c) throws SQLException {
        try {

            // connnect to database 'testdb'
            conn = baseDAO.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Slides VALUES (?,?)");
            stmt.setString(1, c.getImage());
            stmt.setInt(2, c.getMovie());

            // get data from table
            stmt.executeUpdate();
            // show data

            // close connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Movie getMovieByID(String movie_id) throws SQLException {
        Movie a = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from Movies where movie_id =  ?");
            stmt.setString(1, movie_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data

            while (rs.next()) {
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));

            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public List<Movie> getAllMovie() throws SQLException {
        List<Movie> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from Movies");

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Movie> getMovieByCate(String cate_id) throws SQLException {
        List<Movie> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from Movies m inner join Movie_category mc on mc.movie_id = m.movie_id where mc.cate_id =  ?");
            stmt.setString(1, cate_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Movie> getMovieByDirector(String director) throws SQLException {
        List<Movie> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from Movies where directed_by =  ?");
            stmt.setString(1, director);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Movie> getMovieByActor(String actor) throws SQLException {
        List<Movie> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from Movies m inner join Movie_actor ma on ma.movie_id = m.movie_id where ma.actor_id =  ?");
            stmt.setString(1, actor);

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Movie> getTop5GoodMovie() throws SQLException {
        List<Movie> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select top(5) * from Movies m order by m.viewers desc");

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //end movie
    public List<MovieActor> getMovieActor() throws SQLException {
        List<MovieActor> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from Movie_actor");

            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                MovieActor a = null;
                a = new MovieActor(
                        rs.getInt("actor_id"),
                        rs.getInt("movie_id"),
                        rs.getNString("description"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //phan trang
    public int getTotalNumberRow(String genreid) throws SQLException {
        Connection conn = BaseDAO.getConnection();
        int numRow = 0;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            String sql = "select COUNT(*)as maxrownum from Movies m inner join Movie_category mc on mc.movie_id = m.movie_id where cate_id= ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, genreid);

            rs = statement.executeQuery();

            while (rs.next()) {
                numRow = rs.getInt("maxrownum");
            }

        } catch (SQLException ex) {

        }

        return numRow;
    }

//	public int getTotalNumberRowByBC(String bcid)throws SQLException {
//		Connection conn = DBUtils.getConnection();
//		int numRow = 0;
//		PreparedStatement statement = null;
//		ResultSet rs = null;
//		try {
//			String sql = "select COUNT(*)as maxrownum from Books b inner join contain c where c.book_id = b.book_id and c.book_case_id = ?";
//			 statement = conn.prepareStatement(sql);
//			 statement.setString(1, bcid);
//			 rs = statement.executeQuery();
//
//			while (rs.next()) {
//				numRow = rs.getInt("maxrownum");
//			}
//
//		} catch (SQLException ex) {
//
//		}
//		DBUtils.closeConnection(conn, statement, rs);
//		return numRow;
//	}
    public List<Movie> getMoviePage(int pageindex, int pagesize, String genreid) throws SQLException {

        List<Movie> list = null;
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select mo.movie_id,mo.title,mo.[description],mo.time_show,mo.subtitle,mo.poster,mo.request,mo.rated,mo.viewers,mo.premiere,mo.country,mo.directed_by,mo.status_movie from(select row_number() over(order by m.movie_id asc) as rownum, m.movie_id from Movies  m inner join Movie_category mc on mc.movie_id = m.movie_id where cate_id = ?) as rs1 inner join Movies mo on rs1.movie_id = mo.movie_id where rownum >= ((?-1) * ?) + 1 AND rownum <=  ? * ?");
            stmt.setString(1, (genreid));
            stmt.setInt(2, (pageindex));
            stmt.setInt(3, (pagesize));
            stmt.setInt(4, (pageindex));
            stmt.setInt(5, (pagesize));
            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));
                list.add(a);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // end phan trang
    // movie actor
    // end movie actor
    public void reduceTiket(String movie_id) {
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("UPDATE [dbo].[Locations]\n"
                    + "   SET [ticket_count] = (SELECT [ticket_count]\n"
                    + "  FROM [dbo].[Locations]  WHERE [location_id] = ?)-1\n"
                    + " WHERE [location_id] = ?");
            stmt.setString(1, movie_id);
            stmt.setString(2, movie_id);

            // get data from table
            ResultSet rs = stmt.executeQuery();

        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public String getMovieNameById(String idM) {
        String name;
        try {
            BaseDAO db = new BaseDAO();
            conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select title from Movies where movie_id = ?");
            stmt.setInt(1, Integer.parseInt(idM));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                name = String.valueOf(rs.getString("title"));
                return name;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Movie> searchMovie(String search) throws SQLException {
        ArrayList<Movie> movie = new ArrayList<Movie>();
        try {
            String search1 = "%" + search + "%";
            BaseDAO db = new BaseDAO();
            conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from Movies where title like ?");
            stmt.setString(1, String.valueOf(search1));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        String.valueOf(rs.getInt("time_show")),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getFloat("rated"),
                        rs.getInt("viewers"),
                        String.valueOf(rs.getDate("premiere")),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        String.valueOf(rs.getBoolean("status_movie")));
                movie.add(a);
            }
                return movie;
        } catch (Exception e) {
            System.out.println("searchMovie" + e.getMessage());
        }
        return null;

    }

    public List<Movie> getAllMovieBySearch(String search) throws SQLException {
        List<Movie> list = null;
        String search1 = "'%" + search + "%'";
        try {
            BaseDAO db = new BaseDAO();
            // connnect to database 'testdb'
            conn = db.getConnection();
            // crate statement
            PreparedStatement stmt = conn.prepareStatement("select * from Movies where title like ?");
            stmt.setString(1, search1);
            // get data from table
            ResultSet rs = stmt.executeQuery();
            // show data
            list = new ArrayList<>();
            while (rs.next()) {
                Movie a = null;
                a = new Movie(
                        rs.getInt("movie_id"),
                        rs.getNString("title"),
                        rs.getString("description"),
                        rs.getString("time_show"),
                        rs.getNString("subtitle"),
                        rs.getString("poster"),
                        rs.getString("request"),
                        rs.getInt("rated"),
                        rs.getInt("viewers"),
                        rs.getString("premiere"),
                        rs.getString("country"),
                        rs.getString("directed_by"),
                        rs.getString("status_movie"));
                list.add(a);
            }
            // close connection

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
