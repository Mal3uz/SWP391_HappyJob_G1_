/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package provider;

import dao.ProviderDAO;
import dao.ServicePackageDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */

@MultipartConfig
public class AddTalentControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String title = request.getParameter("title");
        String Description = request.getParameter("description");
        int cid = Integer.parseInt(request.getParameter("cid"));
        SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createAt = sqlDateFormat.format(date);
        System.out.println(createAt);
        // img handler
        Part file = request.getPart("ProductImgURL");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "E:/SWP391_HappyJob_G1_-master/web/images/" + imageFileName;
        ServicePackageDAO spdao = new ServicePackageDAO();
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("user");
        int id = acc.getAccountID();
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            ProviderDAO pdao = new ProviderDAO();
           int talentID = pdao.AddTalent(title,"images/"+imageFileName, Description, createAt, id,cid);
            // Get values for the three service packages
                for (int i = 1; i <= 3; i++) {
                    String servicePackageTitle = request.getParameter("servicePackageTitle" + i);
                    String servicePackageDescription = request.getParameter("servicePackageDescription" + i);
                    String servicePackageType = request.getParameter("servicePackageType" + i);
                    int servicePackagePrice = Integer.parseInt(request.getParameter("servicePackagePrice" + i));
                    int servicePackageRev = Integer.parseInt(request.getParameter("servicePackageRev" + i));
                    int servicePackageDL = Integer.parseInt(request.getParameter("servicePackageDL" + i));
                    // Add more service package attributes as needed

                    // Insert the service package into the database
                   spdao.insertServicePackage(talentID, servicePackageTitle, servicePackageDescription, servicePackagePrice, servicePackageRev, servicePackageType, servicePackageDL);
                }
           response.sendRedirect("Home.jsp");
        } catch (Exception e) {
        }

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

}
