<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Blog" %><%--
    Document   : Blog
    Created on : Jan 16, 2024, 12:21:37 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@include file="components/Header.jsp" %>
<% ArrayList<Blog> blogs = (ArrayList<Blog>)request.getAttribute("blogs"); %>
<!-- HOME -->
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1 class="text-white font-weight-bold">Our Blog</h1>
                <div class="custom-breadcrumbs">
                    <a href="#">Home</a> <span class="mx-2 slash">/</span>
                    <span class="text-white"><strong>About Us</strong></span>
                </div>
            </div>
        </div>
    </div>
</section>
<%--<style>--%>
<%--    .site-section img{--%>
<%--        width: 100%;--%>
<%--        height: 100%;--%>
<%--        object-fit: cover;--%>
<%--    }--%>
<%--</style>--%>
<section class="site-section">
    <div class="container">
        <div class="row mb-5">

            <% for (int i = 0; i < blogs.size(); i++) { %>
                <div class="col-md-6 col-lg-4 mb-5">
                    <a href="<%=request.getContextPath()%>/view-blog?id=<%=blogs.get(i).BlogID%>"><img src="<%=request.getContextPath()%>/<%=blogs.get(i).thumbnail%>" alt="Image" class="img-fluid rounded mb-4"></a>
                    <h3><a href="<%=request.getContextPath()%>/view-blog?id=<%=blogs.get(i).BlogID%>" class="text-black"><%=blogs.get(i).title%></a></h3>
                    <div><%=blogs.get(i).created_at%> <span class="mx-2">|</span><%=blogs.get(i).admin_name%></div>
                </div>
            <% } %>
        </div>
    </div>
</section>

<%@include file="components/Footer.jsp" %>




