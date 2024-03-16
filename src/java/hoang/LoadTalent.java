/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hoang;

import dao.AccountDAO;
import dao.ServicePackageDAO;
import dao.TalentDAO;
import entity.Talent;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LoadTalent extends HttpServlet {

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
            throws ServletException, IOException {
        TalentDAO tdao = new TalentDAO();
        AccountDAO adao = new AccountDAO();
        ServicePackageDAO spdao = new ServicePackageDAO();
        
        String indexPage = request.getParameter("index");

        int index = Integer.parseInt(indexPage);
        List<Talent> listT = tdao.pagingActiveTalent(index);
        
        PrintWriter out = response.getWriter();
        out.println("<div style=\"padding-top: 10px; margin-top: 10px; width: 100%; display: flex; justify-content: center; flex-wrap: wrap; gap: 20px;\">");
        for (Talent t : listT) {
            out.println("<div style=\"width: 300px; height: 325px; border-radius: 10px;\">");
            out.println("<a href=\"talentDetail?tID=" + t.getTalentID() + "#nav-basic\"><img style=\"margin-top: 10px; width:100%; height: 150px; border-radius: 10px;\" src=\"" + t.getImg() + "\"></a>");
            out.println("<div style=\"width: 100%; height: 50px; display: flex; gap: 10px; align-items: center;\">");
            out.println("<img style=\"margin-left: 10px; width: 30px; height: 30px; border-radius: 50%;\" src=\"images/person_1.jpg\">");
            out.println("<div style=\"font-weight: bold; color: black;\">" + adao.getAccountByTalentId(t.getTalentID()).getName() + "</div>");
            out.println("</div>");
            out.println("<a href=\"talentDetail?tID=" + t.getTalentID() + "#nav-basic\"><div style=\"margin-left: 10px; color: #7f848c;\">" + t.getTitle() + "</div></a>");
            out.println("<div style=\"display: flex; align-items: center; gap: 10px;\">");
            out.println("<div style=\"margin-left: 10px; color: black; font-weight: bold; display: flex; align-items: center; gap: 5px;\">");
            out.println("<div class=\"icon-star\"></div>");
            out.println("<div>"+tdao.getNumberRatingOfTalent(t.getTalentID())+"</div>");
            out.println("</div>");
            out.println("<div>");
            out.println("(" + tdao.getNumberOrderOfTalent(t.getTalentID()) + ")");
            out.println("</div>");
            out.println("</div>");
            out.println("<div style=\"margin-left: 10px; color: black; font-weight: bold; display: flex; align-items: center; gap: 5px;\">From $" + spdao.BasicPackageById(t.getTalentID()).getPrice() + "</div>");
            out.println("</div>");
        }
        out.println("</div>");

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
        processRequest(request, response);
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
        processRequest(request, response);
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

    public static void main(String[] args) {
           TalentDAO tdao = new TalentDAO();
           List<Talent> listT = tdao.pagingActiveTalent(3);
           for (Talent talent : listT) {
                System.out.println(talent);
        }
    }
}
