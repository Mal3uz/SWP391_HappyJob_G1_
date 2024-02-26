/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest.servlet;


import dao.LoginDAO;
import entity.Account;
//import SMTP.GmailAPI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author BEAN
 */
@WebServlet(name = "ResetPassword", urlPatterns = {"/ResetPassword"})
public class ResetPassword extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetPassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPassword at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("ForgotPassword.jsp");
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
        LoginDAO dao = new LoginDAO();
        SendEmailUtil gmail = new SendEmailUtil();

        try {
            String mailTo = request.getParameter("mail");
             Account u = dao.checkUserExist(mailTo);
            if (u == null) {
                request.setAttribute("warn", "The email did not exist, please try again!");
                 request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            } else {
                
                //FIX DEFAULT LENGTH OF PASSWORD 8 CHARACTORS
                int charactor = 8;
                String gmailFrom = "heccu10b@gmail.com";
                String password = "xnkh gguy llfs njkb";
                String subject = "Reset Password";
                String newPassword = dao.RandomPassword(charactor);
                // TO UPDATE PASSWORD
                dao.updatePasswordByEmail(mailTo, newPassword);

                String message = ("This is your new password: " + newPassword);
                //SEND NEW PASSWORD
              
                //send mail 
                gmail.send(mailTo, subject, message, gmailFrom, password);
                
                response.sendRedirect("Login.jsp");

            }
        } catch (Exception ex) {
            request.setAttribute("warn", "The email did not exist, please try again!");
            request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
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
