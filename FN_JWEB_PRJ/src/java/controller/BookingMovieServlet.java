/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DB.BookingDAO;
import DB.LocationDAO;
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
import model.Account;
import model.Bookings;
import model.Location;
import model.LocationType;
import model.Movie;
import model.Positions;

/**
 *
 * @author Nguyen Van Ky
 */
public class BookingMovieServlet extends HttpServlet {

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
            out.println("<title>Servlet BookingMovieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingMovieServlet at " + request.getContextPath() + "</h1>");
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
        String bookingrs = request.getParameter("bookingrs");
        if(!bookingrs.equals("")){
            request.setAttribute("bookingrs", "true");
        }
        
        try {
            String movie_id = request.getParameter("movie_id");

            MovieDAO mdao = new MovieDAO();

            LocationDAO locationDAO = new LocationDAO();
            List<LocationType> ltList = locationDAO.getListLationType();
            List<Positions> positionList = locationDAO.getListPositions();
            List<Location> locationList = locationDAO.getListLocation();

            request.setAttribute("ltList", ltList);
            request.setAttribute("movie_id", movie_id);
            request.setAttribute("positionList", positionList);
            request.setAttribute("locationList", locationList);
            request.getRequestDispatcher("common/moviedetail.jsp").forward(request, response);
        } catch (SQLException ex) {
            response.getWriter().print("something wrong"); 
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
        HttpSession session = request.getSession();
        Object obj_acc = session.getAttribute("usercurrent");
        MovieDAO m = new MovieDAO();
        if (obj_acc != null) {
            try {
                Account account = (Account) obj_acc;
                String location_id = request.getParameter("location");
                String movie_id = request.getParameter("movie_id");
                String acc_id = account.getAcc_id()+"";
                String title = m.getMovieNameById(movie_id);
                
                BookingDAO bdao = new BookingDAO();
                bdao.addBooking(new Bookings(0, Integer.parseInt(acc_id), Integer.parseInt(location_id), "", Integer.parseInt(movie_id), String.valueOf(title)));
                MovieDAO movie = new MovieDAO();
                movie.reduceTiket(movie_id);
                
                
              response.sendRedirect("bookingmovie?bookingrs=true&&movie_id="+movie_id);
            } catch (SQLException ex) {
                Logger.getLogger(BookingMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            response.sendRedirect("login");
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
