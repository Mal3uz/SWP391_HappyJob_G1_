/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hoang;

import dao.AccountDAO;
import dao.OrderDAO;
import dao.TalentDAO;
import entity.Account;
import entity.Talent;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LoadWaitingControl extends HttpServlet {

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
        TalentDAO tdao = new TalentDAO();
        OrderDAO odao = new OrderDAO();
        AccountDAO adao = new AccountDAO();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");
        String indexPage = request.getParameter("index");

        if (indexPage != null) {
            int index = Integer.parseInt(indexPage);
            List<Talent> talentList = null;

            if (index == 1) {
                talentList = tdao.getTalentByOrderStatus(account.getAccountID(), "Pending");
            } else if (index == 2) {
                talentList = tdao.getTalentByOrderStatus(account.getAccountID(), "Processing");
            } 

            PrintWriter out = response.getWriter();

            if (talentList != null) {
                for (Talent tWatingAccept : talentList) {
                    out.println("<ul class=\"job-listings mb-3\">");
                    out.println("<li class=\"job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center\">");
                    out.println("<div class=\"job-listing-logo\">");
                    out.println("<img class=\"img-fluid\" src=\"" + tWatingAccept.getImg() + "\" alt=\"alt\" style=\"width: 150px; height: 100px; object-fit: cover;\"/>");
                    out.println("</div>");
                    out.println("<div class=\"job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4\">");
                    out.println("<div class=\"row w-100\">");
                    out.println("<div class=\"col-lg-7\">");
                    out.println("<div class=\"job-listing-position custom-width w-50 mb-3 mb-sm-0\">");
                    out.println("<h2 style=\"cursor: pointer;\">" + tWatingAccept.getTitle() + "</h2>");
                    out.println("<strong>" + adao.getAccountByTalentId(tWatingAccept.getTalentID()).getName() + "</strong>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("<div class=\"col-lg-5 d-flex justify-content-end\">");
                    out.println("<div class=\"job-listing d-block mr-2\">");
                    out.println("<a href=\"orderDetail?tID=" + tWatingAccept.getTalentID() + "\" class=\"btn btn-block btn-info\" style=\"position: unset;height: unset;\">Details</a>");
                    out.println("</div>");
                    out.println("<div class=\"job-listing d-block\">");
                    if (index == 1) {
                        out.println("<a href=\"deleteOrder?orderId= \" class=\"btn btn-block btn-danger\" style=\"position: unset;height: unset;\">Delete</a>");
                    } else if (index == 2) {
                        out.println("<a href=\"cancelOrder?orderId= \" class=\"btn btn-block btn-danger\" style=\"position: unset;height: unset;\">Cancel</a>");
                    }

                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</li>");
                    out.println("</ul>");
                }
            }

        } else {

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
