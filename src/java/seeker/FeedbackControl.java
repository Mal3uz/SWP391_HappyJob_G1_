/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package seeker;

import dao.SeekerDAO;
import entity.Account;
import entity.Feedback;
import entity.Rating;
import entity.ServicePackage;
import entity.Talent;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class FeedbackControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String talentIDParam = (String) request.getParameter("tID");
       int talentID = Integer.parseInt(talentIDParam);
       SeekerDAO dao = new SeekerDAO();
       HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");
       Talent t = dao.getTalentByTalentId(talentIDParam);
       Account a = dao.getAccountByTalentId(talentIDParam);
       ServicePackage service = dao.BasicPackageByTalentId(talentIDParam);
       request.setAttribute("t", t);
       request.setAttribute("a", a);
       request.setAttribute("service", service);
        Feedback f = dao.checkFeedback(account.getAccountID(), talentID);
        Rating r = dao.checkRating(account.getAccountID(), talentID);
        if(f != null){
          String text = f.getContent();
          request.setAttribute("text", text);
        }
        
        if(r != null){
          int star = r.getScore();
          request.setAttribute("star", star);
        }
       request.getRequestDispatcher("EvaluationForm.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
