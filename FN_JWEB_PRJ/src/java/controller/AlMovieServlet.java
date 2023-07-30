/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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

/**
 *
 * @author Nguyen Van Ky
 */
public class AlMovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlMovieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlMovieServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String cate_id = request.getParameter("cate_id");
            if(cate_id == null){
                cate_id = "1";
            }
            MovieDAO mdao = new MovieDAO();
            CategoryDAO cdao = new CategoryDAO();
            List<Category> cateList = cdao.getAllCategory();

            // count page
            String page = request.getParameter("page");
            if (page == null || page.equals("")) {
                page = "1";
            }
            int pageindex = Integer.parseInt(page);
            int pagesize = 3;
            int totalNumberRow = mdao.getTotalNumberRow(cate_id);
            int totalNumberPage = totalNumberRow % pagesize == 0 ? totalNumberRow / pagesize
                    : totalNumberRow / pagesize + 1;

            List<Movie> listCountPage = mdao.getMoviePage(pageindex, pagesize, cate_id);

            request.setAttribute("pageindex", pageindex);
            request.setAttribute("listCountPage", listCountPage);
            request.setAttribute("totalNumberPage", totalNumberPage);
            //end count page

            request.setAttribute("cateList", cateList);
            request.setAttribute("cate_id", cate_id);

            
            response.getWriter().print("pageindex: "+pageindex+" |totalNumberRow: "+totalNumberRow+" | totalNumberPage:"+totalNumberPage+" | "+listCountPage.size() );
            request.getRequestDispatcher("common/allmovie.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
