/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package seeker;

import dao.SeekerDAO;
import entity.Account;
import entity.Feedback;
import entity.Rating;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DELL
 */
public class GetFeadbackControl extends HttpServlet {

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
            out.println("<title>Servlet GetFeadbackControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetFeadbackControl at " + request.getContextPath() + "</h1>");
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
        // them du lieu vao database
       String talentIDParam = (String) request.getParameter("tid");
        int talentID = Integer.parseInt(talentIDParam);
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurrentTime = currentTime.format(formatter);
        int star = Integer.parseInt(request.getParameter("star-value"));
        String feedback = request.getParameter("feedback-text");
        SeekerDAO dao = new SeekerDAO();
        Feedback f = dao.checkFeedback(account.getAccountID(), talentID);
        Rating r = dao.checkRating(account.getAccountID(), talentID);
        if (f == null) {
            dao.InsertFeedback(feedback, account.getAccountID(), talentID, formattedCurrentTime);
            dao.InsertRating(talentID, star, account.getAccountID());
        } else {
            if(r != null && star != 0) dao.UpdateRating(star,r.getRatingID());
             dao.UpdateFeedback(feedback,formattedCurrentTime,f.getFeedbackID());
             
        }

        response.sendRedirect("./talentDetail?tID="+talentID);
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
