<%-- 
    Document   : Contact
    Created on : Jan 16, 2024, 2:11:18 AM
    Author     : DELL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="components/Header.jsp" %>
<!-- HOME -->
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1 class="text-white font-weight-bold">Waiting List</h1>
                <div class="custom-breadcrumbs">
                    <a href="#">Home</a> <span class="mx-2 slash">/</span>
                    <span class="text-white"><strong>Waiting List</strong></span>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="m-3 d-flex justify-content-center">
    <button onclick="handleShowClick(1)" class="btn btn-primary mr-2">Show Waiting Accept</button>
    <button onclick="handleShowClick(2)" class="btn btn-primary">Show Waiting To Do</button>
</div>
<section id="waitingAcceptSection" class="site-section">
    <div id="container">

        <c:forEach var="tWatingAccept" items="${watingAccept}">
            <ul class="job-listings mb-3">
                <li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center">
                    <div class="job-listing-logo">
                        <img class="img-fluid" src="${tWatingAccept.getImg()}" alt="alt" style="width: 150px; height: 100px; object-fit: cover;"/>
                    </div>
                    <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
                        <div class="row w-100">

                            <div class="col-lg-7">
                                <div class="job-listing-position custom-width w-50 mb-3 mb-sm-0">
                                    <h2 style="cursor: pointer;">${tWatingAccept.getTitle()}</h2>
                                    <strong>${adao.getAccountByTalentId(tWatingAccept.getTalentID()).getName()}</strong>
                                </div>
                            </div>
                            <div class="col-lg-5 d-flex justify-content-end">
<!--                                <div class="job-listing d-block mr-2">
                                    <a href="orderDetail?tID=${tWatingAccept.getTalentID()}"  class="btn btn-block btn-info" style="position: unset;height: unset;">Details</a>                    
                                </div>-->
<!--                                <div class="job-listing d-block">
                                     <a href="orderDetail?tID=${tWatingAccept.getTalentID()}"  class="btn btn-block btn-danger" style="position: unset;height: unset;">Delete</a>             
                                </div>-->
                            </div>

                        </div>
                    </div>
                </li>
            </ul>
        </c:forEach>

    </div>
</section>




<script>
    function handleShowClick(Number) {
        $.ajax({
            type: 'GET',
            url: 'loadWaiting',
            data: {
                index: Number
            },
            success: function (data) {
                var row = document.getElementById("container");
                row.innerHTML = data;
            }
        });
    }
</script>

<%@include file="components/Footer.jsp" %>







