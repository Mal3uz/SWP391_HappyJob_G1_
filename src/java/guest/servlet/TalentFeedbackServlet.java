package guest.servlet;

import dao.FeedbackDAO;
import dao.RatingDAO;
import dao.TalentDAO;
import entity.Feedback;
import entity.Rating;
import entity.Talent;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TalentFeedbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int talentID = Integer.parseInt(request.getParameter("talentID"));

        // Lấy thông tin của talent
        TalentDAO talentDAO = new TalentDAO();
        Talent talent = talentDAO.getTalentById(talentID);
        request.setAttribute("talent", talent);

        // Lấy danh sách feedback cho talent
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        List<Feedback> feedbackList = feedbackDAO.getFeedbacksByTalentID(talentID);
        request.setAttribute("feedbackList", feedbackList);

        // Lấy danh sách rating cho talent
        RatingDAO ratingDAO = new RatingDAO();
        List<Rating> ratingList = ratingDAO.getRatingsByTalentID(talentID);
        request.setAttribute("ratingList", ratingList);

        // Forward đến trang JSP để hiển thị
        request.getRequestDispatcher("TalentDetail.jsp").forward(request, response);
    }
}
