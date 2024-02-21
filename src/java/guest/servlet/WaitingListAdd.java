package guest.servlet;

import dao.WaitingListDAO;
import entity.Account;
import entity.WaitingListItem;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ns
 */
@WebServlet(name = "WaitingListAdd", urlPatterns = {"/waitingList/add"})
public class WaitingListAdd extends HttpServlet {
    
    private final WaitingListDAO waitingListDAO = new WaitingListDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        int accountID = a.getAccountID();
        
        int talentID = Integer.parseInt(request.getParameter("talentID"));
        int packetID = Integer.parseInt(request.getParameter("packetID"));
        
        WaitingListItem item = new WaitingListItem();
        item.setAccountId(accountID);
        item.setTalentId(talentID);
        item.setPackageId(packetID);
        
        WaitingListItem addedItem = waitingListDAO.addWaitingListItem(item);
        
        response.sendRedirect(request.getContextPath() + "/waitingList");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
}
