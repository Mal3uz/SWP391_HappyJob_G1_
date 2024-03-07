/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package guest.servlet;

import dao.LoginDAO;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class LoginControl extends HttpServlet {

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
        //Lấy dữ liệu từ jsp
        String action = request.getParameter("action");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        HttpSession session = request.getSession();
        LoginDAO dao = new LoginDAO();
        Account account = new Account();
        account = dao.getAccountByEmail(username);
        session.setAttribute("account", account);
        ProviderDAO pdao = new ProviderDAO();
        int id = pdao.getIdByEmai(username);
        session.setMaxInactiveInterval(6*60*60);
        String status = account.getStatus();
        System.out.println(status);
        System.out.println("Pending".equals(status));
        if ("Pending".equals(status)) {
            Account u = dao.login(username, password);
            session.setAttribute("user", u);
            String code = dao.generateVerificationCode();
            dao.updateNewVerificationCode(code, username);
            SendEmailUtil.sendVerificationCode(username, code);
            Long time = (System.currentTimeMillis() + 15 * 60 * 1000); // 15 minutes
            session.setAttribute("time", time);
            request.setAttribute("email", username);
            request.setAttribute("mess1", "Your account isn't authenticated, authenticate to sign in");
            //  response.sendRedirect("Verify.jsp");
            request.getRequestDispatcher("Verify.jsp").forward(request, response);

        } else {
            if ("Login".equals(action)) {

                //Kết nối vs DB
                Account u = dao.login(username, password);

                //Kiểm tra
                if (u == null) {
                    //login fail -> Đẩy về trang Login.jsp (nhập lại)
                    //Message thông báo Login sai: thay đổi giá trị của biến mess
                    request.setAttribute("mess1", "Login fail!");
                    //ko thì quay trở lại trang login.jsp
                    //Yêu cầu người dùng Login lại
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } else {
                 

                    WalletDAO wdao = new WalletDAO();
                  int  balance =  wdao.getBalance(id);
                    session.setAttribute("balance", balance);

                    

                    session.setAttribute("user", u);
                    System.out.println(u);
                    switch (u.getRoleID()) {
                        case 1:
                            response.sendRedirect("admin/dashBoard");
                            break;
                        case 2:
                            response.sendRedirect("ProviderDashboard.jsp");
                            break;
                        case 3:
                            response.sendRedirect("Home.jsp");
                            break;
                        default:
                            request.getRequestDispatcher("Login.jsp").forward(request, response);
                            break;
                    }
                }
            } else {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
    }
    

    public static void main(String[] args) {
        LoginDAO dao = new LoginDAO();
        Account a = dao.getAccountByEmail("phuongnampham7823@gmail.com");
//        Account u = dao.login("admin1@example.com", "123456");
        System.out.println(a);
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
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
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
