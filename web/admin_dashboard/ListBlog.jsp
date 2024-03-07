<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Blog" %><%--
    Document   : RequestTalent
    Created on : Jan 18, 2024, 12:13:13 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>

<!-- App body starts -->
<div class="app-body">

    <!-- Container starts -->
    <div class="container">
        <a href="${pageContext.request.contextPath}/admin/create-blog">
            <button type="button" class="btn btn-primary">Tạo mới 1 blog</button>
        </a>
        <!-- Row start -->
        <% ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blogs");%>
        <%System.out.println(blogs.size());%>
        <%for (int i = 0; i < blogs.size(); i++) {%>
            <div class="row mt-2">
            <div class="col-md-12">
                <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col-auto d-none d-lg-block">
                        <img style="height: 300px; width: 300px; object-fit: cover" src="<%=request.getContextPath() + blogs.get(i).thumbnail%>" alt="">
                    </div>
                    <div class="col p-4 d-flex flex-column position-static">
                        <a href="<%=request.getContextPath()%>/view-blog?id=<%=blogs.get(i).BlogID%>">
                            <h3 class="mb-0"><%=blogs.get(i).title%></h3>
                        </a>
                        <div class="mb-1 text-muted">Được viết bởi <%=blogs.get(i).admin_name%> lúc <%=blogs.get(i).created_at%></div>
                        <p class="mb-auto"><%=blogs.get(i).description%></p>
                    </div>
                    <div class="col-2 d-flex align-items-center">
                        <div class="row" style="width: 100%">
                            <div class="row m-1" style="width: 100%">
                                <a style="width: 100%" href="<%=request.getContextPath()%>/admin/update-blog?id=<%=blogs.get(i).BlogID%>">
                                    <button style="width: 100%" class="btn btn-warning">Cập nhật</button>
                                </a>
                            </div>
                            <div class="row m-1" style="width: 100%">
                                <a style="width: 100%" href="<%=request.getContextPath()%>/admin/delete-blog?id=<%=blogs.get(i).BlogID%>">
                                    <button style="width: 100%" class="btn btn-danger">Xóa</button>
                                </a>
                            </div>
                            <div class="row m-1" style="width: 100%">
                                <a style="width: 100%" href="<%=request.getContextPath()%>/admin/verify-blog?id=<%=blogs.get(i).BlogID%>">
                                    <% if (blogs.get(i).is_verified.equals("0")) { %>
                                            <button style="width: 100%" class="btn btn-danger">Chưa được duyệt</button>
                                    <% } else { %>
                                        <button style="width: 100%" class="btn btn-success">Đã được duyệt</button>
                                    <% } %>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
        <!-- Row end -->

    </div>
    <!-- Container ends -->

</div>
<!-- App body ends -->

<!-- App footer start -->
<%@include file="Footer.jsp" %>
