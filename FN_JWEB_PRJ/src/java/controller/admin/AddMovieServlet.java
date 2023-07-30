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
import jakarta.servlet.http.HttpSession;
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
public class AddMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
          Object obj = session.getAttribute("role");
          if(obj == null){
              response.sendRedirect("./home");
             
          }else{
              if(!obj.equals("admin")){
                  response.sendRedirect("./home");
              }
              String updaters = request.getParameter("updaters");
        if(updaters != null){
            request.setAttribute("updaters", "true");
        }
        try {
            CategoryDAO cdao = new CategoryDAO();
            MovieDAO mdao = new MovieDAO();
            List<Movie> movieList = mdao.getAllMovie();
            List<Category> categoryList = cdao.getAllCategory();
            List<Movie_category> mcList = cdao.getMovieCategory();

            request.setAttribute("categoryList", categoryList);
            request.setAttribute("movieList", movieList);
            request.setAttribute("mcList", mcList);
            response.getWriter().print("ddddsss");

            request.getRequestDispatcher("addmovie.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
             response.getWriter().print("something wrong");
        }
        response.getWriter().print("ddd");
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
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String timeshow = request.getParameter("timeshow");
            String subtitle = request.getParameter("subtitle");
            String linkposter = request.getParameter("linkposter");
            String requestS = request.getParameter("request");
            String country = request.getParameter("country");
            String directedby = request.getParameter("directedby");
                        String premiere = request.getParameter("premiere");

            CategoryDAO cdao = new CategoryDAO();
            MovieDAO mdao = new MovieDAO();
            List<Category> categoryList = cdao.getAllCategory();
            List<Movie> movieList = mdao.getAllMovie();
            response.getWriter().print(new Movie(0, title, description, timeshow, subtitle, linkposter, requestS, 0, 0, premiere, country, directedby, "1").toString());
            mdao.addMovie(new Movie(0, title, description, timeshow, subtitle, linkposter, requestS, 0, 0, premiere, country, directedby, "1"));
            int lastMovieID = movieList.get(movieList.size()-1).getMovie_id();
            for (Category category : categoryList) {
                String cate = request.getParameter(category.getCate_name());
                if(cate != null){
                    mdao.addMovieCategory(new Movie_category(lastMovieID+1, category.getCate_id()));
                }
                
//response.getWriter().println(cate);
            }
            response.sendRedirect("addmovie?updaters=true");
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
