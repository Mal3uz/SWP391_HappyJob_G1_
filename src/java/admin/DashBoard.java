/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package admin;

import dao.AdminDAO;
import entity.Account;
import entity.Talent;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class DashBoard extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        int activeAccount = dao.getNumberAccountByStatus("Active");
        int pendingAccount = dao.getNumberAccountByStatus("Pending");
        int LockAccount =  dao.getNumberAccountByStatus("Lock");
        int activeTalent = dao.getNumberTalentByStatus("Active");
        int pendingTalent = dao.getNumberTalentByStatus("Pending");
        int rejectTalent = dao.getNumberTalentByStatus("Reject");
        int orderFinish = dao.getNumberOrderByStatus("Finish", "Finish");
        int orderPending = dao.getNumberOrderByStatus("Pending", "Processing");
        int orderCancel = dao.getNumberOrderByStatus("Scancel", "Cancel");
        Map<Account, Integer> topAccount = dao.getTopAccountWithPurchaseCount();
        Map<Talent, Integer> topTalent = dao.getTopTalentWithAmountSold();
         
        request.setAttribute("activeAccount", activeAccount);
        request.setAttribute("pendingAccount", pendingAccount);
        request.setAttribute("LockAccount", LockAccount);
        request.setAttribute("activeTalent", activeTalent);
        request.setAttribute("pendingTalent", pendingTalent);
        request.setAttribute("rejectTalent", rejectTalent);
        request.setAttribute("topAccount", topAccount);
        request.setAttribute("topTalent", topTalent);
        request.setAttribute("orderFinish", orderFinish);
        request.setAttribute("orderPending", orderPending);
        request.setAttribute("orderCancel", orderCancel);  
        
        request.setAttribute("dao", dao);
        
         request.getRequestDispatcher("../admin_dashboard/DashBoard.jsp").forward(request, response);
                
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
