package guest.servlet;

import entity.Profile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProfileControl", urlPatterns = {"/ProfileControl"})
public class ProfileControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            
            // Get the user profile from the session
            HttpSession session = request.getSession();
            Profile userProfile = (Profile) session.getAttribute("userProfile");

            if (userProfile != null) {
                // If the user is logged in, forward to profile.jsp
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {
                // If the user is not logged in, redirect to the login page
                response.sendRedirect("Login.jsp");
                
            }
            
            
        } catch (Exception ex) {
            response.getWriter().println("Error retrieving profile data: " + ex.getMessage());
        }
    }

    public String getServletInfo() {
        return "Profile Control Servlet";
    }
}
