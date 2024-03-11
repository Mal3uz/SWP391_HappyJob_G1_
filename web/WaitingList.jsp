<%-- 
    Document   : Contact
    Created on : Jan 16, 2024, 2:11:18 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="dao.AccountDAO" id="showAccount"></jsp:useBean>

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

<section class="site-section" id="next-section">
    <div class="container">
        <ul class="job-listings mb-5">
            <c:forEach var="item" items="${waitingList}">
                <li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center">

                    <div class="job-listing-logo">
                        <c:choose>
                            <c:when test="${item.talent.img eq null}">
                                <img class="img-fluid" src="images/person_1.jpg" alt="alt"/>
                            </c:when>
                            <c:otherwise>
                                <img class="img-fluid" src="${item.talent.img}" alt="alt"/>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
                        <div class="row w-100">
                            <div class="col-lg-7">
                                <div class="job-listing-position custom-width w-50 mb-3 mb-sm-0">
                                    <h2 style="cursor: pointer;"
                                        onclick="location.href = '${pageContext.request.contextPath}/detailTalentServlet?tID=${item.talent.talentID}'">
                                        ${item.talent.title}
                                    </h2>
                                    <strong>${showAccount.getAccountById(item.talent.accountID).name}</strong>
                                </div>
                            </div>
                            <div class="col-lg-5 d-flex align-items-center">
                                <div class="job-listing d-block mr-2">
                                    <span class="btn btn-info" style="cursor: pointer;" 
                                          onclick="location.href = '${pageContext.request.contextPath}/detailTalentServlet?tID=${item.talent.talentID}'"
                                          >Details</span>                    
                                </div>
                                <div class="job-listing-location mb-3 mb-sm-0 custom-width d-block mr-2">
                                    <select id="sp-${item.talent.talentID}" class="btn btn-large btn-primary p-2 text-capitalize w-100" onchange="location.href = this.value;">
                                        <c:forEach var="p" items="${talentPackages[item.talent.talentID]}">
                                            <option 
                                                value="${pageContext.request.contextPath}/waitingList/changePackage?talentID=${item.talent.talentID}&packetID=${p.packageID}"
                                                <c:if test="${p.packageID eq item.servicePackage.packageID}">
                                                    selected
                                                </c:if>
                                                >${p.type} - $${p.price}</option>
                                        </c:forEach>
                                    </select>
                                    <script>
                                        document.getElementById("sp-${item.talent.talentID}").
                                    </script>
                                </div>
                                <div class="job-listing d-block">
                                    <span class="btn btn-danger" style="cursor: pointer;" 
                                          onclick="location.href = '${pageContext.request.contextPath}/waitingList/delete?talentID=${item.talent.talentID}'"
                                          >Delete</span>                    
                                </div>
                            </div>
                        </div>
                    </div>

                </li>
            </c:forEach>
        </ul>
    </div>
</section>

<section class="site-section bg-light">
    <div class="container">
        <div class="row mb-5">
            <div class="col-12 text-center" data-aos="fade">
                <h2 class="section-title mb-3">Happy Candidates Says</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="block__87154 bg-white rounded">
                    <blockquote>
                        <p>&ldquo;Ipsum harum assumenda in eum vel eveniet numquam cumque vero vitae enim cupiditate deserunt eligendi officia modi consectetur. Expedita tempora quos nobis earum hic ex asperiores quisquam optio nostrum sit&rdquo;</p>
                    </blockquote>
                    <div class="block__91147 d-flex align-items-center">
                        <figure class="mr-4"><img src="images/person_1.jpg" alt="Image" class="img-fluid"></figure>
                        <div>
                            <h3>Elisabeth Smith</h3>
                            <span class="position">Creative Director</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <div class="block__87154 bg-white rounded">
                    <blockquote>
                        <p>&ldquo;Ipsum harum assumenda in eum vel eveniet numquam, cumque vero vitae enim cupiditate deserunt eligendi officia modi consectetur. Expedita tempora quos nobis earum hic ex asperiores quisquam optio nostrum sit&rdquo;</p>
                    </blockquote>
                    <div class="block__91147 d-flex align-items-center">
                        <figure class="mr-4"><img src="images/person_2.jpg" alt="Image" class="img-fluid"></figure>
                        <div>
                            <h3>Chris Peter</h3>
                            <span class="position">Web Designer</span>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</section>

<%@include file="components/Footer.jsp" %>




