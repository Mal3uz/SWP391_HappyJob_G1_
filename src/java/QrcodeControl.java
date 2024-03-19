/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.ProviderDAO;
import dao.ServicePackageDAO;
import dao.WalletDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class QrcodeControl extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String createAt = sqlDateFormat.format(date);
            Object accObj = session.getAttribute("user");
            Account a = (Account) accObj;
            int accId = a.getAccountID();
            Object u = session.getAttribute("user");

            int packId = (Integer) session.getAttribute("packId");
            String payment_method = request.getParameter("payment_method");
            int talentId = (Integer) session.getAttribute("talentId");
            ProviderDAO pdao = new ProviderDAO();
            ServicePackageDAO spdao = new ServicePackageDAO();
            int total = (int) (spdao.getPriceByPackId(packId) * 1.05);
            WalletDAO wdao = new WalletDAO();
            double balance = (Integer) session.getAttribute("balance");
            System.out.println("abc");
            System.out.println(u != null && balance > total);
            if (payment_method.equals("momo")) {
                if (u != null) {
                    String oderType = "Gateway";
                    pdao.addOrder(accId, talentId, createAt, packId,"Waiting",oderType);
                    request.setAttribute("total", total);
                    request.getRequestDispatcher("qrcode.jsp").forward(request, response);
                }
                 }
                else if (payment_method.equals("wallet")) {
                    if (u != null && balance > total) {
                        String oderType = "Paid";
                      int ordID =  pdao.addOrder(accId, talentId, createAt, packId,"Pending",oderType);
                        pdao.insertTransaction(accId, 1, total, oderType, ordID, "Success", createAt);
                        int newBalance = (int) Math.round(balance - total);
                        session.removeAttribute("balance");
                        session.setAttribute("balance", newBalance);
                        wdao.updateNewBalance(accId, newBalance);
                        response.sendRedirect("Home.jsp");
                    }else {
                     request.setAttribute("mess1", "Please make sure the wallet balance is sufficient for payment");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                } else {
                    response.sendRedirect("Login.jsp");
                }
           
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);

            } catch (Exception ex) {
                Logger.getLogger(QrcodeControl.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);

            } catch (Exception ex) {
                Logger.getLogger(QrcodeControl.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
