package admin;

import dao.BLogDao;
import entity.Account;
import entity.Blog;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.UUID;

public class BlogController {
    @WebServlet("/admin/manage-blog")
    public static class ViewAdminManagementBlogPage extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ArrayList<Blog> blogs = new BLogDao().adminGetAllBlogs();
            req.setAttribute("blogs", blogs);
            req.getRequestDispatcher("/admin_dashboard/ListBlog.jsp").forward(req, resp);
        }
    }

    @WebServlet("/create-blog")
    @MultipartConfig(
            fileSizeThreshold = 1024 * 1024, // 1 MB
            maxFileSize = 1024 * 1024 * 30,      // 30 MB
            maxRequestSize = 1024 * 1024 * 30  // 30 MB
    )
    public static class CreateBlog extends HttpServlet{
        public static String generateUniqueFileName(String originalFileName) {
            String extension = "";
            int dotIndex = originalFileName.lastIndexOf('.');
            if (dotIndex >= 0 && dotIndex < originalFileName.length() - 1) {
                extension = originalFileName.substring(dotIndex + 1);
            }
            String uniquePart = UUID.randomUUID().toString();
            return uniquePart + "." + extension;
        }
        public static String getFileName(Part part) {
            String contentDisposition = part.getHeader("content-disposition");
            String[] tokens = contentDisposition.split(";");
            for (String token : tokens) {
                if (token.trim().startsWith("filename")) {
                    return token.substring(token.indexOf('=') + 1).trim()
                            .replace("\"", "");
                }
            }
            return null;
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/PostBlog.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String admin_id = String.valueOf(((Account)req.getSession().getAttribute("account")).getAccountID());
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String content = req.getParameter("content");

            try {
                Part filePart = req.getPart("thumbnail");
                String fileName = getFileName(filePart);
                assert fileName != null;
                String newFileName = generateUniqueFileName(fileName);
                String uploadDir = req.getServletContext().getRealPath("/") + "uploads";
                Path filePath = Paths.get(uploadDir, newFileName);
                try (InputStream fileContent = filePart.getInputStream()) {
                    Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
                }
                boolean check = new BLogDao().createNewBlog(admin_id, title, description, content, "/uploads/" + newFileName);
                resp.sendRedirect(req.getContextPath()+ "/create-blog");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @WebServlet("/view-blog")
    public static class ViewBlog extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            Blog blog = new BLogDao().get1Blog(id);
            req.setAttribute("blog", blog);
            req.getRequestDispatcher("/ViewBlogDetail.jsp").forward(req, resp);
        }
    }

    @WebServlet("/admin/delete-blog")
    public static class AdminDeleteBlog extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            boolean check = new BLogDao().deleteBlog(id);
            resp.sendRedirect(req.getContextPath() + "/admin/manage-blog");
        }
    }

    @WebServlet("/admin/update-blog")
    @MultipartConfig(
            fileSizeThreshold = 1024 * 1024, // 1 MB
            maxFileSize = 1024 * 1024 * 30,      // 30 MB
            maxRequestSize = 1024 * 1024 * 30  // 30 MB
    )
    public static class AdminUpdateBlog extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            Blog blog = new BLogDao().get1Blog(id);
            req.setAttribute("blog", blog);
            req.getRequestDispatcher("/admin_dashboard/ViewUpdateBlog.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Part filePart = req.getPart("thumbnail");
            String title = req.getParameter("title");
            String id = req.getParameter("id");
            String description = req.getParameter("description");
            String content = req.getParameter("content");
            System.out.println("damn id : " + id);
            if (filePart.getSize() == 0){ //không update ảnh
                System.out.println("không update ảnh");
                boolean check = new BLogDao().updateBlog(id, title, description, content);
            } else { // có update ảnh
                System.out.println("có update ảnh");
                try {
                    String fileName = CreateBlog.getFileName(filePart);
                    assert fileName != null;
                    String newFileName = CreateBlog.generateUniqueFileName(fileName);
                    String uploadDir = req.getServletContext().getRealPath("/") + "uploads";
                    Path filePath = Paths.get(uploadDir, newFileName);
                    try (InputStream fileContent = filePart.getInputStream()) {
                        Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
                    }
                    boolean check = new BLogDao().updateBlog(id, title, description, content, "/uploads/" + newFileName);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            resp.sendRedirect(req.getContextPath()+ "/admin/manage-blog");
        }
    }

    @WebServlet("/view-all-blogs")

    public static class ViewAllBlogs extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ArrayList<Blog> blogs = new BLogDao().userGet3NewestBlogs();
            req.setAttribute("blogs", blogs);
            req.getRequestDispatcher("Blog.jsp").forward(req, resp);
        }
    }
    @WebServlet("/admin/verify-blog")
    public static class AdminVerifyBLog extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            boolean check = new BLogDao().verifyBLog(req.getParameter("id"));
            resp.sendRedirect(req.getContextPath() + "/admin/manage-blog");
        }

    }

    @WebServlet("/your-blogs")
    public static class ViewYourBlog extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String user_id = String.valueOf(((Account)req.getSession().getAttribute("account")).getAccountID());
            ArrayList<Blog> blogs = new BLogDao().getUserBlog(user_id);
            req.setAttribute("blogs", blogs);
            req.getRequestDispatcher("YourBlog.jsp").forward(req, resp);
        }
    }

    @WebServlet("/delete-blog")
    public static class UserDeleteBlog extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            boolean check = new BLogDao().deleteBlog(id);
            resp.sendRedirect(req.getContextPath() + "/your-blogs");
        }
    }

    @WebServlet("/update-blog")
    @MultipartConfig(
            fileSizeThreshold = 1024 * 1024, // 1 MB
            maxFileSize = 1024 * 1024 * 30,      // 30 MB
            maxRequestSize = 1024 * 1024 * 30  // 30 MB
    )
    public static class UserUpdateBlog extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            Blog blog = new BLogDao().get1Blog(id);
            req.setAttribute("blog", blog);
            req.getRequestDispatcher("/ViewUpdateBlog.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Part filePart = req.getPart("thumbnail");
            String title = req.getParameter("title");
            String id = req.getParameter("id");
            String description = req.getParameter("description");
            String content = req.getParameter("content");
            if (filePart.getSize() == 0){ //không update ảnh
                System.out.println("không update ảnh");
                boolean check = new BLogDao().userUpdateBlog(id, title, description, content);
            } else { // có update ảnh
                System.out.println("có update ảnh");
                try {
                    String fileName = CreateBlog.getFileName(filePart);
                    assert fileName != null;
                    String newFileName = CreateBlog.generateUniqueFileName(fileName);
                    String uploadDir = req.getServletContext().getRealPath("/") + "uploads";
                    Path filePath = Paths.get(uploadDir, newFileName);
                    try (InputStream fileContent = filePart.getInputStream()) {
                        Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
                    }
                    boolean check = new BLogDao().userUpdateBlog(id, title, description, content, "/uploads/" + newFileName);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            resp.sendRedirect(req.getContextPath()+ "/your-blogs");
        }
    }
}
