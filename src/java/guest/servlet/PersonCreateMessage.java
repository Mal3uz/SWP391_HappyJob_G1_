/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package guest.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.AdminDAO;
import entity.Account;
import entity.Messagess;
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
public class PersonCreateMessage extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        AdminDAO dao = new AdminDAO();
        int uId = account.getAccountID();
        int friendId = Integer.parseInt(request.getParameter("friendId"));
        String message = request.getParameter("message");
        Account friend = dao.getAccountById(friendId);
        String nameFriend = friend.getName();
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedTime = currentTime.format(formatter);
       dao.InsertMessage(uId, friendId, formattedTime, message);
        Messagess messageDeatil = dao.getLastMessageThroughTwoFriendId(uId, friendId);

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        JsonObject senderJson = convertAccountToJson(account);
        JsonObject messJson = convertMessToJson(messageDeatil, nameFriend);
        jsonObject.add("mess", messJson);
        jsonObject.add("sender", senderJson);
        String json = gson.toJson(jsonObject);

        // Gửi JSON về client
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();

    }

    private JsonObject convertMessToJson(Messagess mess, String nameFriend) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", mess.getMessageID());
        jsonObject.addProperty("senderid", mess.getSenderID());
        jsonObject.addProperty("receiverid", mess.getReceiverID());
        jsonObject.addProperty("timestamp", mess.getTimestamp());
        jsonObject.addProperty("content", mess.getContent());
        jsonObject.addProperty("nameFriend", nameFriend);
        // Thêm các trường khác của đối tượng Messagess vào đây
        return jsonObject;
    }

    private JsonObject convertAccountToJson(Account account) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("accountID", account.getAccountID());
        jsonObject.addProperty("name", account.getName());
        jsonObject.addProperty("img", account.getImg());

        return jsonObject;
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