package user.servlet;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import entity.Account;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ns
 */
public class ProfileEditControl extends HttpServlet {

    private final AccountDAO accountDAO = new AccountDAO();
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        int id = a.getAccountID();
        
        Account account = accountDAO.getAccountById(id);
        
        request.setAttribute("account", account);
        request.getRequestDispatcher("/ProfileEdit.jsp").forward(request, response);
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    Account a = (Account) session.getAttribute("user");
    int id = a.getAccountID();
    
    String email = request.getParameter("email");
    String name = request.getParameter("name");
    String dob = request.getParameter("dob");
    String gender = request.getParameter("gender");
    String img = request.getParameter("img"); // Retrieve img parameter
    
    Account account = accountDAO.getAccountById(id);
    account.setEmail(email);
    account.setName(name);
    account.setDob(dob);
    account.setGender(gender);
    
    // Only update img field if a new image URL is provided
    if (img != null && !img.isEmpty()) {
        account.setImg(img);
    }
    
    Account updatedAccount = accountDAO.updateAccount(account);
    
    if (updatedAccount != null) 
        request.setAttribute("success", "Updated account successfully!");
    else
        request.setAttribute("fail", "Updated account failed! Please try again!");
    
    request.setAttribute("account", account);
    request.getRequestDispatcher("/ProfileEdit.jsp").forward(request, response);
}
}