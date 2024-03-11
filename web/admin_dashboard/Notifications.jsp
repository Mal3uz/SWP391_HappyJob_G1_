<%-- 
    Document   : Notifications
    Created on : Jan 17, 2024, 9:48:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
                    <li class="breadcrumb-item text-light">Notifications</li>
                </ol>
                <!-- Breadcrumb end -->
            </div>
        </div>
        <!-- Row end -->

        <!-- Row start -->
        <div class="row">
            <div class="col-12">
                <div class="card mb-2">
                    <div class="card-body">
                      
                        <!-- Contacts Container Start -->
                        <div class="notification-container mt-3">
                            <div class="notification-list">
                                <c:forEach var="n" items="${listN}">
                                    <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block ${n.status == 0 ? '':'opacity-50' }">
                                        <img src="../admin_dashboard/assets/images/user1.png" alt="Admin Panel" class="img-3x rounded-circle" />

                                        <div class="flex-1 flex flex-col">
                                            <p class="mb-1">

                                                <span class="fw-semibold">${fn:substring(n.createdAt, 0, 10)}</span>

                                                   <span class="${n.status == 0 ? ' bg-primary badge rounded-pill':'' }"> </span>

                                            </p>
                                            <p class="mb-1">

                                                ${n.message}
                                            </p>
                                            <p class="small mb-1">

                                                <span class="opacity-50">${fn:substring(n.createdAt, 11, 19)}</span>
                                            </p>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                        <!-- Contacts Container End -->
                    </div>
                </div>
            </div>
        </div>
        <!-- Row end -->
        <nav aria-label="Page navigation example ">
            <ul class="pagination justify-content-end ">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <!-- Container ends -->

</div>
<!-- App body ends -->



<%@include file="Footer.jsp" %>

