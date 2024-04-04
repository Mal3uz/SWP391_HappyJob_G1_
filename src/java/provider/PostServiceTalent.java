/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package provider;

import dao.ProviderDAO;
import entity.ServicePackage;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class PostServiceTalent extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String tidString = request.getParameter("tid");
       int tid = Integer.parseInt(tidString);
       
       ProviderDAO pdao = new ProviderDAO();
       List<ServicePackage> s = pdao.getListServicePackageTalentByID(tid);
       
       request.setAttribute("service", s);
        request.setAttribute("tid", tid);
       request.getRequestDispatcher("/provider/serviceTalent.jsp").forward(request, response);
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
        int talentid = Integer.parseInt(request.getParameter("talent_id"));
         String titletxt = request.getParameter("title");
        String descriptiontxt = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int revisions = Integer.parseInt(request.getParameter("revisions"));
        int deadline = Integer.parseInt(request.getParameter("deadline"));
       
        ProviderDAO pdao = new ProviderDAO();
        try {
            pdao.addServicePacket(talentid,titletxt,descriptiontxt,price,revisions,deadline);
        } catch (Exception ex) {
            Logger.getLogger(PostServiceTalent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("postServiceTalent?tid="+talentid);
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
