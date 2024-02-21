package guest.servlet;

import dao.ServicePackageDAO;
import dao.TalentDAO;
import dao.WaitingListDAO;
import entity.Account;
import entity.ServicePackage;
import entity.Talent;
import entity.WaitingListItem;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ns
 */
@WebServlet(name = "WaitingListView", urlPatterns = {"/waitingList"})
public class WaitingListView extends HttpServlet {

    private static final String VIEW_PATH = "WaitingList.jsp";

    private final WaitingListDAO waitingListDAO = new WaitingListDAO();

    private final TalentDAO talentDAO = new TalentDAO();

    private final ServicePackageDAO servicePackageDAO = new ServicePackageDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        int accountID = a.getAccountID();

        ArrayList<WaitingListItem> waitingList = waitingListDAO.getWaitingListByAccountID(accountID);

        HashMap<Integer, ArrayList<ServicePackage>> talentPackages = new HashMap<>();

        for (int i = 0; i < waitingList.size(); ++i) {
            Talent talent = talentDAO.getTalentById(waitingList.get(i).getTalentId());
            ServicePackage servicePackage = servicePackageDAO.getServicePackageByID(waitingList.get(i).getPackageId());
            waitingList.get(i).setTalent(talent);
            waitingList.get(i).setServicePackage(servicePackage);
            talentPackages.put(waitingList.get(i).getTalentId(), servicePackageDAO.listPackage(waitingList.get(i).getTalentId()));
        }

        request.setAttribute("waitingList", waitingList);
        request.setAttribute("talentPackages", talentPackages);

        request.getRequestDispatcher(VIEW_PATH).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
