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
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class RegisterControl extends HttpServlet {

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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String re_pass = request.getParameter("repass");
    //    String email = request.getParameter("email");

         if (pass.matches("^[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*$") && pass.matches("^[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*$")) {
        if (!pass.equals(re_pass)) {
            request.setAttribute("mess1", "password and repeat password must be same!");
            response.sendRedirect("SignUp.jsp");
        } else {
            LoginDAO dao = new LoginDAO();
            Account u = dao.checkUserExist(user);
            
            if (u == null) {
                //dc register

                dao.register(pass, user, name, dob, gender);
                request.setAttribute("mess1", "Create a successful account!");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            } else //day ve login
            {
                
                request.setAttribute("mess1", "Email already exists!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }
        }
    } else{
            request.setAttribute("mess2", "Password must be between 8 and 31 characters and must be alphanumeric!");
              request.getRequestDispatcher("SignUp.jsp").forward(request, response);
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
