<%@ page import="entity.Blog" %><%--
    Document   : BlogDetail
    Created on : Jan 16, 2024, 12:22:26 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@include file="components/Header.jsp" %>

<% Blog blog = (Blog) request.getAttribute("blog");%>
<!-- HOME -->
<% if (blog!=null) { %>
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container" style="opacity: 0">
        <div class="row">
            <div class="col-md-12">

                <h1 class="text-white"><%=blog.title%></h1>
                <h4 class="text-white"><%=blog.description%></h4>
                <div class="custom-breadcrumbs mb-0 d-flex justify-content-center mt-1">
                    <span class="slash">được đăng bởi <%= blog.admin_name%> (<%=blog.views%> lượt xem)</span>
                    <span class="mx-2 slash">|</span>
                    <span class="text-white"><strong><%=blog.created_at%></strong></span>
                </div>
            </div>
        </div>
    </div>
</section>
<style>
    .blog-content img{
        max-width: 100%;
        height: auto;
        display: block;
    }
</style>
<section class="site-section" id="next-section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">

                <h1 class=""><%=blog.title%></h1>
                <h4 class=""><%=blog.description%></h4>
                <div class="custom-breadcrumbs mb-0 d-flex justify-content-center mt-1">
                    <span class="slash text-black">được đăng bởi <%= blog.admin_name%> (<%=blog.views%> lượt xem)</span>
                    <span class="mx-2 slash">|</span>
                    <span class=""><strong><%=blog.created_at%></strong></span>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <img src="<%=request.getContextPath()%>/<%=blog.thumbnail%>" alt="" style="width: 100%">
            <div class="col-lg-12 blog-content">
                <%=blog.content%>
            </div>
        </div>
    </div>
</section>
<% } else { %>
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="custom-breadcrumbs mb-0">
                </div>
                <h1 class="text-white">không tìm thấy Blog</h1>
            </div>
        </div>
    </div>
</section>
<% } %>


<%@include file="components/Footer.jsp" %>

