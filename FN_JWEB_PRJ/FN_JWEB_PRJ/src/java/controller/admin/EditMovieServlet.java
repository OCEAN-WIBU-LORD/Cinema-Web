/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DB.CategoryDAO;
import DB.MovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Movie;
import model.Movie_category;

/**
 *
 * @author Nguyen Van Ky
 */
public class EditMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            MovieDAO mdao = new MovieDAO();
            String movie_id = request.getParameter("movie_id");
            Movie movie1 = mdao.getMovieByID(movie_id);
            CategoryDAO cdao = new CategoryDAO();
            List<Movie> movieList = mdao.getAllMovie();
            List<Category> categoryList = cdao.getAllCategory();
            List<Movie_category> mcList = cdao.getMovieCategory();

            request.setAttribute("categoryList", categoryList);
            request.setAttribute("movieList", movieList);
            request.setAttribute("mcList", mcList);
            response.getWriter().print("ddddsss");

            if (movie1 != null) {
                request.setAttribute("movie", movie1);
                request.getRequestDispatcher("editmovie.jsp").forward(request, response);
            } else {
                response.getWriter().print("movie with id: " + movie_id + "not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String movie_id = request.getParameter("movie_id");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String timeshow = request.getParameter("timeshow");
            String subtitle = request.getParameter("subtitle");
            String linkposter = request.getParameter("linkposter");
            String requestS = request.getParameter("request");
            String country = request.getParameter("country");
            String directedby = request.getParameter("directedby");
            String premiere = request.getParameter("premiere");
            String rated = request.getParameter("rated");
            String viewer = request.getParameter("viewer");
            String status_movie = request.getParameter("status_movie");

            CategoryDAO cdao = new CategoryDAO();
            MovieDAO mdao = new MovieDAO();
            List<Movie_category> mcList = cdao.getMovieCategory();
            List<Category> categoryList = cdao.getAllCategory();
            List<Movie> movieList = mdao.getAllMovie();
            int movie_id2 = Integer.valueOf(movie_id);
//            response.getWriter().print(new Movie(movie_id2, title, description, timeshow, subtitle, linkposter, requestS, Double.valueOf(rated), Integer.valueOf(viewer), premiere, country, directedby, status_movie != null ? "1" : "0").toString());
            mdao.updateMovie(new Movie(movie_id2, title, description, timeshow, subtitle, linkposter, requestS, Double.valueOf(rated), Integer.valueOf(viewer), premiere, country, directedby, status_movie != null ? "1" : "0"));

            
             for (Category category : categoryList) {
                String cate = request.getParameter(category.getCate_name());
                int cateid = category.getCate_id();
                if(cate != null && !cdao.getCheckMovieCategory(new Movie_category(movie_id2, cateid))){
                    mdao.addMovieCategory(new Movie_category(movie_id2, cateid));
                }
                if(cate == null && cdao.getCheckMovieCategory(new Movie_category(movie_id2, cateid))){
                  
            
                    mdao.deleteMovieCategory(movie_id, String.valueOf(category.getCate_id()));
                }
            }
            
          
//response.getWriter().println(cate);

            response.sendRedirect("addmovie");
        } catch (SQLException ex) {
            Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print("something wrong");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
