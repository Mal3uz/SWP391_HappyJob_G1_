/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package guest.servlet;

import dao.LoginDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class VerifyServlet extends HttpServlet {

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
            out.println("<title>Servlet VerifyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
      //  String time1 = session.getAttribute("time"); 
        String email = request.getParameter("email");
        String enteredCode = request.getParameter("code");
        String action = request.getParameter("action");
       // Long time =Long.parseLong(session.getAttribute("time")) ;
        LoginDAO l = new LoginDAO();
         if ("Resend".equals(action)|| System.currentTimeMillis() > (long) session.getAttribute("time")) {
             LoginDAO dao = new LoginDAO();
              String code = dao.generateVerificationCode();
                dao.updateNewVerificationCode(code, email);
               SendEmailUtil.sendVerificationCode(email, code);
               Long time = (System.currentTimeMillis() + 15 * 60 * 1000); // 15 minutes
               session.setAttribute("time", time);
               request.setAttribute("mess1", "Send verification code successfully!");
         }
        else if(l.getVerifyCodeByEmail(email, enteredCode)!= null
                && System.currentTimeMillis() < (long) session.getAttribute("time")) {
            // Verification successful
            // You can update the user's status or perform any other necessary actions
           // response.getWriter().println("Verification successful!");
           l.verifyAccountByEmail(email);
             request.setAttribute("mess1", "Create a successful account!");
              request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            // Verification failed
            response.getWriter().println("Verification failed. Please try again.");
        }
    }
    
  
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   


