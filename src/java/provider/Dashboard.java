/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provider;

import dao.ProviderDAO;
import entity.Account;
import entity.Statistic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Khuong Hung
 */

public class Dashboard extends HttpServlet {

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

        try {
           HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("user");
            int accId = account.getAccountID();
            if ( account.getRoleID()==3 || account.getRoleID()==2) {
                ProviderDAO pdao = new ProviderDAO();
               int totalTalent =  pdao.getTotalPost(accId);
                int totalOrder = pdao.getTotalOrder(accId);
                List<Map<String, Object>> items = new ArrayList<>();
                 List<Statistic> appointment7day = pdao.getTransLast7Day();
                 List<Statistic> reservation7day = pdao.getOrderLast7Day();
                 int incomeMonth = pdao.incomeStatic();
                 int incomeLastMonth = pdao.incomeStaticLastMonth();
                 int providerIncome = pdao.incomeStaticById(accId);
                items = pdao.getOrderDetailsByDay(accId);
                request.setAttribute("product", totalTalent);
                request.setAttribute("user", providerIncome);
                request.setAttribute("bill", totalOrder);
                request.setAttribute("low", 12);
                 request.setAttribute("items", items);
                 request.setAttribute("appointment7day", appointment7day);
                request.setAttribute("reservation7day", reservation7day);
               request.setAttribute("Revenueappointment", incomeLastMonth);
               request.setAttribute("Revenuereservation", incomeMonth);
              //  request.setAttribute("billbyday", billbyday);
                request.getRequestDispatcher("/provider/index.jsp").forward(request, response);
            } else {
                response.sendRedirect("Home.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
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
