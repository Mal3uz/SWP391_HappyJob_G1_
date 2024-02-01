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

        <!-- Row start -->
        <div class="row">
            <div class="col-12 col-xl-6">

                <!-- Breadcrumb start -->
                <ol class="breadcrumb mb-3">
                    <li class="breadcrumb-item">
                        <i class="icon-home lh-1"></i>
                        <a href="index.html" class="text-decoration-none">Home</a>
                    </li>
                    <li class="breadcrumb-item">Pages</li>
                    <li class="breadcrumb-item text-light">Placeholder</li>
                </ol>
                <!-- Breadcrumb end -->
            </div>
        </div>
        <!-- Row end -->

        <!-- Row start -->
        <div class="row gx-2">
            <c:forEach var="t" items="${listTalent}">
                <div class="col-sm-3 p-2">
                    <div class="card card-talent">
                        <img src="../admin_dashboard/assets/images/products/product2.jpg" class="card-img-top" alt="Bootstrap Gallery" style="object-fit: cover;">
                        <div class="card-body">
                            <h5 style="height: 40px;">${t.title}</h5>
                            <p style="height: 100px;">
                                ${t.description}
                            </p>
                            <a href="talentDetail?tid=${t.talentID}" class="btn btn-outline-primary">Details</a>
                        </div>
                    </div>
                </div>
            </c:forEach>




        </div>
        <!-- Row end -->


        <!-- Row start -->
        <nav aria-label="Page navigation example ">
            <ul class="pagination justify-content-end ">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${endP}" var="i">
                    <li class="page-item"><a class="page-link" href="listTalent?index=${i}">${i}</a></li>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- Row end -->

    </div>
    <!-- Container ends -->

</div>
<!-- App body ends -->

<!-- App footer start -->
<%@include file="Footer.jsp" %>
