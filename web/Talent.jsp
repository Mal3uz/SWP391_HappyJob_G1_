<%-- 
    Document   : Job
    Created on : Jan 14, 2024, 11:04:33 PM
    Author     : DELL
--%>
<jsp:useBean class="dao.AccountDAO" id="showAccount"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="components/Header.jsp" %>
<%@include file="components/Search.jsp" %>

<section class="site-section" id="next">
    <div class="container">
        <div class="row mb-5 justify-content-center">
            <div class="col-md-7 text-center">
                <h2 class="section-title mb-2">43,167 Talent Listed</h2>
            </div>
        </div>

        <ul class="job-listings mb-5">
            <li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center">
                <a href="job-single.html"></a>
                <div class="job-listing-logo">
                    <img src="images/job_logo_1.jpg" alt="Image" class="img-fluid">
                </div>

                <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
                    <div class="job-listing-position custom-width w-50 mb-3 mb-sm-0">
                        <h2>Product Designer</h2>
                        <strong>Adidas</strong>
                    </div>
                    <div class="job-listing-location mb-3 mb-sm-0 custom-width w-25">
                        <span class="icon-room"></span> New York, New York
                    </div>
                    <div class="job-listing-meta">
                        <span class="badge badge-danger">Part Time</span>
                    </div>
                </div>

            </li>
            <li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center">
                <a href="job-single.html"></a>
                <div class="job-listing-logo">
                    <img src="images/job_logo_2.jpg" alt="Image" class="img-fluid">
                </div>

                <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
                    <div class="job-listing-position custom-width w-50 mb-3 mb-sm-0">
                        <h2>Digital Marketing Director</h2>
                        <strong>Sprint</strong>
                    </div>
                    <div class="job-listing-location mb-3 mb-sm-0 custom-width w-25">
                        <span class="icon-room"></span> Overland Park, Kansas 
                    </div>
                    <div class="job-listing-meta">
                        <span class="badge badge-success">Full Time</span>
                    </div>
                </div>
            </li>
        </ul>

        <div class="row pagination-wrap">
            <div class="col-md-6 text-center text-md-left mb-4 mb-md-0">
                <span>Showing 1-7 Of 43,167 Jobs</span>
            </div>
            <div class="col-md-6 text-center text-md-right">
                <div class="custom-pagination ml-auto">
                    <a href="#" class="prev">Prev</a>
                    <div class="d-inline-block">
                        <a href="#" class="active">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                    </div>
                    <a href="#" class="next">Next</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container-list-talent">
        <c:forEach items="${listTalent}" var="t">
            <div class="talent-items">
                <a href="detailTalentServlet?tID=${t.getTalentID()}#nav-basic"><img class="talent-img" src="images/talent-dev.jpeg"></a>
                <div class="talent-person">
                    <img class="talent-person-avt" src="images/person_1.jpg">
                    <div class="talent-person-name"> ${showAccount.getAccountById(t.getAccountID()).getName()}</div>
                </div>
                <a href="detailTalentServlet?tID=${t.getTalentID()}#nav-basic"><div class="talent-title">${t.getTitle()}</div></a>
                <div class="talent-star">
                    <div class="black-color">
                        <div class="icon-star"></div>
                        <div>5.0</div>
                    </div>
                    <div>
                        (385)
                    </div>
                </div>
                <div class="black-color">From $495</div>
            </div>
        </c:forEach>
    </div>
</section>


<section class="py-5 bg-image overlay-primary fixed overlay" style="background-image: url('images/hero_1.jpg');">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-8">
                <h2 class="text-white">Looking For A Job?</h2>
                <p class="mb-0 text-white lead">Lorem ipsum dolor sit amet consectetur adipisicing elit tempora adipisci impedit.</p>
            </div>
            <div class="col-md-3 ml-auto">
                <a href="#" class="btn btn-warning btn-block btn-lg">Sign Up</a>
            </div>
        </div>
    </div>
</section>



<%@include file="components/Footer.jsp" %>


