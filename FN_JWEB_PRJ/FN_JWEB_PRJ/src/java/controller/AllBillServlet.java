/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.AccountDAO;
import DB.BookingDAO;
import DB.LocationDAO;
import DB.MovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Bookings;

/**
 *
 * @author Acerx
 */
@WebServlet(name = "allBill", urlPatterns = {"/allBill"})
public class AllBillServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession ses = request.getSession();
        if (ses.getAttribute("usercurrent") == null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print("Please Login");
                return;
            }
        }
        AccountDAO a = new AccountDAO();
        BookingDAO b = new BookingDAO();
        LocationDAO l = new LocationDAO();
        String usercurrent = String.valueOf(ses.getAttribute("usercurrent"));

        MovieDAO m = new MovieDAO();
        
        
        String username = String.valueOf(ses.getAttribute("username"));

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String acc_id1 = a.getAccId(username);
            String message = username;
            request.setAttribute("message", acc_id1);

            int acc_id2 = Integer.parseInt(acc_id1);
            String error = "error";
            
            int bookingsId = b.getBookingIdByAccId(acc_id2);
//            int locationId = l.ge   
//            String movieName = m.getMovieNameById(bookingsId);
            
            

            ArrayList<Bookings> bookings1 = b.getListBooking(acc_id2);
            request.setAttribute("bookings1", bookings1);
            request.getRequestDispatcher("common/allBill.jsp").forward(request, response);
        } catch (SQLException ex) {

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
        HttpSession ses = request.getSession();
        if (ses.getAttribute("usercurrent") == null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print("Please Login");
                return;
            }
        }
        AccountDAO a = new AccountDAO();
        String usercurrent = String.valueOf(ses.getAttribute("usercurrent"));
        MovieDAO m = new MovieDAO();
        String movieName = m.getMovieNameById(usercurrent);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String acc_id1 = a.getAccId(usercurrent);
            String message = "abcd";
            request.setAttribute("message", message);

            BookingDAO bookings = new BookingDAO();
            int acc_id2 = Integer.parseInt(acc_id1);

            ArrayList<Bookings> bookings1 = bookings.getListBooking(acc_id2);
            request.setAttribute("bookings1", bookings1);
            request.getRequestDispatcher("common/allBill.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AllBillServlet.class.getName()).log(Level.SEVERE, null, ex);
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
