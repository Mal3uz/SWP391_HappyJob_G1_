/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package seeker;

import dao.ProviderDAO;
import dao.ServicePackageDAO;
import entity.Account;
import entity.ServicePackage;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Checkout extends HttpServlet {

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
        try {
            HttpSession session = request.getSession(true);
            int packId = Integer.parseInt(request.getParameter("id"));
            String lidParam = request.getParameter("lid");
            Account a = (Account) session.getAttribute("user");
            if (a.getRoleID() == 3) {
                session.setAttribute("lidParam", lidParam);
                session.setAttribute("packId", packId);
                ServicePackageDAO spdao = new ServicePackageDAO();
                List<ServicePackage> listS = spdao.getServicePackageByID(packId);
                request.setAttribute("listS", listS);
                int talentId = spdao.getTalentIDByPackId(packId);
                session.setAttribute("talentId", talentId);
                int total = spdao.getPriceByPackId(packId);
                request.setAttribute("total", total);
                if (lidParam != null && !lidParam.isEmpty()) {
                    // Tách chuỗi lid thành một mảng các ID gói dịch vụ
                    String[] lidArray = lidParam.split(",");
                    // Chuyển đổi mảng lidArray thành mảng số nguyên
                    int[] packageIDs = Arrays.stream(lidArray)
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    List<ServicePackage> listAddMore = spdao.listPackageAdd(packageIDs);
                    if (listAddMore != null && !listAddMore.isEmpty()) {
                        for (ServicePackage pkg : listAddMore) {
                            total += pkg.getPrice();
                        }
                    }

                    request.setAttribute("total", total);
                    request.setAttribute("listAddMore", listAddMore);
                }

                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            } else {
                request.setAttribute("mess1", "You are not allow!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        Object u = session.getAttribute("user");
        if (u == null) {
            request.setAttribute("mess1", "Please signin to continue");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
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
//   @Override
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    try {
//        HttpSession session = request.getSession(true);
//        Object accObj = session.getAttribute("user");
//        
//        if (accObj != null && accObj instanceof Account) {
//            Account a = (Account) accObj;
//            int accId = a.getAccountID();
//            int packId = Integer.parseInt(request.getParameter("id"));
//
//            ServicePackageDAO spdao = new ServicePackageDAO();
//            int talentId = spdao.getTalentIDByPackId(packId);
//            System.out.println("abc");
//            System.out.println(talentId);
//            SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date();
//            String createAt = sqlDateFormat.format(date);
//
//            ProviderDAO pdao = new ProviderDAO();
//            String payment_method = "momo";
//
//            if (payment_method.equals("momo")) {
//                int total = Math.round(spdao.getPriceByPackId(packId));
//                request.setAttribute("total", total);
//                pdao.addOrder(accId, talentId, createAt, packId);
//                request.getRequestDispatcher("qrcode.jsp").forward(request, response);
//            } else {
//                // Handle other payment methods
//            }
//        } else {
//            response.sendRedirect("Login.jsp");
//        }
//    } catch (NumberFormatException e) {
//        // Handle NumberFormatException
//        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameter 'id'");
//    } catch (Exception e) {
//        // Handle other exceptions
//        e.printStackTrace(); // Log the exception
//        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred");
//    }
//}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
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
