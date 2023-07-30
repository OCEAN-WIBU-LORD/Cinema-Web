/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DB.AccountDAO;
import controller.Logout;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Nguyen Van Ky
 */
public class RegisterServlet extends HttpServlet {

    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("common/register.jsp").forward(request, response);
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
            String username = request.getParameter("username");
            String repassword = request.getParameter("repass");
            String password = request.getParameter("pass");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String age = request.getParameter("age");
            boolean gender1 = request.getParameter("gender").equals("Male");
            String gender = String.valueOf(gender1);
            String email = request.getParameter("email");
            String point = request.getParameter("0");
            String account_type_id = request.getParameter("1");
            
            
            AccountDAO adao = new AccountDAO();
            String mess = "";
           
            
            if (!password.equals(repassword) ) {
                mess = "comfirm password";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("logout.jsp").forward(request, response);
            } else if(adao.checkAccount(username)) {
                mess = "username: "+username+" is used";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("common/register.jsp").forward(request, response);
                
            }else{
                HttpSession session = request.getSession();
                 adao.insertAccount(username,password,firstname,lastname,age,gender,email,point,account_type_id);
                 
                 
                 String acc_id = adao.getAccId(username);
                 adao.insertRole(acc_id);
                 
                 Account account = adao.getAccount(username, password);
                
                String role = adao.checkAdmin(String.valueOf(account.getAcc_id()));
                 session.setAttribute("usercurrent", account);
                 
                 
                if(role.equals("user")){
                    response.sendRedirect("home");
                }else{
                    response.sendRedirect("admin/home");
                }
            }
        } catch (SQLException ex) {
           response.getWriter().print("something wrong");
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
