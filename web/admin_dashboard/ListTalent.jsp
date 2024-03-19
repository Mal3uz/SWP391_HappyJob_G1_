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
                    <a href="talentDetail?tid=${t.talentID}" class="text-decoration-none">
                        <div class="card card-talent ">
                            <img src="${t.img}" class="card-img-top custom-height img-thumbnail" alt="Bootstrap Gallery" style="width: 350px;height:200px;object-fit: cover;">
                            <div class="card-body">
                                <div class="talent-person d-flex align-items-center">
                                    <img class="talent-person-avt rounded-circle" style="height: 30px;margin: 5px;" src="../images/person_1.jpg">
                                    <c:set value="${dao.getAccountByTalentId(t.talentID)}" var="account"></c:set>
                                    <div class="talent-person-name ml-2 text-primary"> ${account.name}</div>
                                </div>
                                <h5 class="text-primary mt-2" style="height: 20px;">${t.title}</h5>
                                <p class="text-secondary" style="height: 100px;">
                                    ${t.description}
                                </p>
                                <p class="text-success">
                                    <c:set value="${dao.BasicPackageById(t.talentID)}" var="basic"></c:set>
                                    From ${basic.price}$
                                </p>
                            </div>
                        </div>
                    </a>
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
