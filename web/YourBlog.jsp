<%@ page import="entity.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/Header.jsp" %>

<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
  <div class="container">

    <div class="main-body">
      <div class="row gutters-sm">
        <% ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blogs");%>
        <%System.out.println(blogs.size());%>
        <%for (int i = 0; i < blogs.size(); i++) {%>
        <div class="row mt-2">
          <div class="col-md-12">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
              <div class="col-auto d-none d-lg-block">
                <img style="height: 300px; width: 300px; object-fit: cover" src="<%=request.getContextPath() + blogs.get(i).thumbnail%>" alt="">
              </div>
              <div class="col p-4 d-flex flex-column position-static bg-white">
                <a href="<%=request.getContextPath()%>/view-blog?id=<%=blogs.get(i).BlogID%>">
                  <h3 class="mb-0"><%=blogs.get(i).title%></h3>
                </a>
                <div class="mb-1 text-muted">Được viết bởi <%=blogs.get(i).admin_name%> lúc <%=blogs.get(i).created_at%></div>
                <p class="mb-auto"><%=blogs.get(i).description%></p>
              </div>
              <div class="col-2 d-flex align-items-center">
                <div class="row" style="width: 100%">
                  <div class="row m-1" style="width: 100%">
                    <a style="width: 100%" href="<%=request.getContextPath()%>/update-blog?id=<%=blogs.get(i).BlogID%>">
                      <button style="width: 100%" class="btn btn-warning">Cập nhật</button>
                    </a>
                  </div>
                  <div class="row m-1" style="width: 100%">
                    <a style="width: 100%" href="<%=request.getContextPath()%>/delete-blog?id=<%=blogs.get(i).BlogID%>">
                      <button style="width: 100%" class="btn btn-danger">Xóa</button>
                    </a>
                  </div>
                  <div class="row m-1" style="width: 100%">
                      <% if (blogs.get(i).is_verified.equals("0")) { %>
                      <button disabled style="width: 100%" class="btn btn-danger">Chưa được duyệt</button>
                      <% } else { %>
                      <button disabled style="width: 100%" class="btn btn-success">Đã được duyệt</button>
                      <% } %>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <% } %>
      </div>
    </div>
  </div>
</section>
<%@include file="components/Footer.jsp" %>
