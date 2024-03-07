<%--
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

        <form action="<%=request.getContextPath()%>/admin/create-blog" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Tiêu đề</label>
                <input required class="form-control" type="text" name="title" id="title">
            </div>
            <div class="form-group">
                <label for="title">Mô tả</label>
                <input required class="form-control" type="text" name="description" id="description">
            </div>
            <div class="form-group">
                <label for="thumbnail" class="form-label">Thumbnail</label>
                <input required class="form-control" type="file" id="thumbnail" name="thumbnail">
            </div>
            <div class="form-group">
                <label for="title">Nội dung</label>
                <textarea required class="form-control" name="content" id="content"></textarea>
            </div>
            <div class="form-group">
                <button class="btn btn-primary mt-2" type="submit">Tạo mới</button>
            </div>

        </form>

    </div>
    <!-- Container ends -->

</div>
<!-- App body ends -->

<!-- App footer start -->
<%@include file="Footer.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.19.1/ckeditor.js"></script>
<script>
    $(document).ready(function() {
        CKEDITOR.replace('content');
    })
</script>