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

/**
 *
 * @author Nguyen Van Ky
 */
public class AdminDashboardServlet extends HttpServlet {

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
               
              try {
            MovieDAO mdao = new MovieDAO();
            CategoryDAO cdao = new CategoryDAO();
            List<Movie> movieList = mdao.getAllMovie();
            List<Category> categoryList = cdao.getAllCategory();
            
            request.setAttribute("movieCount", (movieList.size()));
            request.setAttribute("categoryCount", (categoryList.size()));
            
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
