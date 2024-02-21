package guest.servlet;

import dao.WaitingListDAO;
import entity.Account;
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
@WebServlet(name = "WaitingListDelete", urlPatterns = {"/waitingList/delete"})
public class WaitingListDelete extends HttpServlet {

    private final WaitingListDAO waitingListDAO = new WaitingListDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        int accountID = a.getAccountID();

        int talentID = Integer.parseInt(request.getParameter("talentID"));

        waitingListDAO.deleteWaitingListItem(accountID, talentID);
        
        response.sendRedirect(request.getContextPath() + "/waitingList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
