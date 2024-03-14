/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package provider;

import dao.ProductDAO;
import dao.ProviderDAO;
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
public class OrderStatusControl extends HttpServlet {

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
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("user");
            int proId = account.getAccountID();
            int ordId = Integer.parseInt(request.getParameter("id"));
            String status = request.getParameter("status");
            ProviderDAO pdao = new ProviderDAO();
            SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String createAt = sqlDateFormat.format(date);
            switch (status) {
                case "accept":
                    double priceDouble = Double.parseDouble(request.getParameter("price"));
                    int price = (int) priceDouble;
                    int deposit = (int) (price * 0.3);
                    double balance = (Integer) session.getAttribute("balance");
                    if (balance >= deposit && account != null) {
                        int seekerId = pdao.getAccountIdByOrderId(ordId);
                        int senderId = pdao.getWalletIdByAccountId(proId);
                        int receiverId = pdao.getWalletIdByAccountId(seekerId);
                        status = "Processing";
                        pdao.updateStatusByOrderId(ordId, status);
                        int newBalance = (int) (balance - deposit);
                        WalletDAO wdao = new WalletDAO();
                        wdao.updateNewBalance(proId, newBalance);
                        String transactionType = "Deposit";
                        String transStatus = "Success";
                        pdao.insertTransaction(senderId, receiverId, deposit, transactionType, ordId, transStatus, createAt);
                    } else {
                        request.setAttribute("mess1", "Please make sure the wallet balance is sufficient for payment");
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                case "cancel":
                    status = "Reject";
                    pdao.updateStatusByOrderId(ordId, status);
                    break;
                case "finish":
                    status = "Finish";
                    pdao.updateStatusByOrderId(ordId, status);
                    ProductDAO pd = new ProductDAO();
                    String productStatus = "Pending";
                    String url = request.getParameter("reason");
                   pd.insertProduct(ordId, proId, url, createAt, productStatus);
                    break;
                case "cancel2":
                    status = "Cancel";
                    pdao.updateStatusByOrderId(ordId, status);

                    break;
                default:
                    throw new AssertionError();
            }
            response.sendRedirect("order");

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrderStatusControl.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrderStatusControl.class.getName()).log(Level.SEVERE, null, ex);
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
