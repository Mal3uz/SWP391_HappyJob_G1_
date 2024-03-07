/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package guest.servlet;

import dao.LoginDAO;
import entity.Account;
import entity.Talent;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class FeedbackController extends HttpServlet {

    //truyen vao orderID, talentID
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int talentId = Integer.parseInt(request.getParameter("talentId"));

        LoginDAO dao = new LoginDAO();
        Account account = new Account();
        account = dao.checkSeeker(orderId);

        String status = dao.getTransactionStatusByOrderId(orderId);
        Boolean checkTalentInOrder = (dao.getTalentIdByOrderId(orderId) == talentId);

        if (account.getRoleID() == 3) {
            if (status.equalsIgnoreCase("Completed")) {
                if (checkTalentInOrder) {
                    Talent talent = new Talent();
                    talent = dao.getTalentByOrderId(orderId);
                    request.setAttribute("AccountID", account.getAccountID());
                    request.setAttribute("TalentID", talent.getTalentID());
                    request.setAttribute("Title", talent.getTitle());
                    request.setAttribute("Img", talent.getImg());
                    request.getRequestDispatcher("Feedback.jsp").forward(request, response);
                }
            }

        }
        response.sendRedirect("./listTalentServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //tra ve tu jsp
        int talentId = Integer.parseInt(request.getParameter("TalentID"));
        int score = Integer.parseInt(request.getParameter("Score"));
        String comment = request.getParameter("Comment");
        int accountId = Integer.parseInt(request.getParameter("AccountID"));

        LoginDAO dao = new LoginDAO();
        try {
            dao.addRating(talentId, score, accountId);
            dao.addComment(comment, accountId, talentId);
        } catch (Exception ex) {
            Logger.getLogger(FeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("./listTalentServlet");

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
