<%-- 
    Document   : ListCategory
    Created on : Mar 8, 2024, 10:18:26 PM
    Author     : DELL
--%>

<%@include file="components/Header.jsp" %>
<%@include file="components/Search.jsp" %>


<section class="site-section" id="next">
    <div class="container">
        <div class="row mb-5 justify-content-center">
            <div class="col-md-7 text-center">
                <h2 class="section-title mb-2">${numberjob} Talent Listed</h2>
            </div>
        </div>

    </div>
    <div class="container-list-talent">
 <div id="container-list-talent" style="padding-top: 10px; margin-top: 10px; width: 100%; display: flex; justify-content: center; flex-wrap: wrap; gap: 20px;">



        <c:forEach items="${listT}" var="t" >
            <div class="talent-items">
                <a href="detailTalentServlet?tID=${t.getTalentID()}#nav-basic"><img class="talent-img" src="${t.getImg()}"></a>

                <div class="talent-person">
                    <img class="talent-person-avt" src="images/person_1.jpg">
                    <c:set value="${dao.getAccountByTalentId(t.getTalentID())}" var="account"></c:set>
                    <div class="talent-person-name"> ${account.getName()}</div>
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
                <c:set value="${dao.BasicPackageByTalentId(t.getTalentID())}" var="packet"></c:set>
                <div class="black-color">From $${packet.getPrice()}</div>
            </div>
        </c:forEach>
    </div>
          <script>
            function handlePaginationClick(pageNumber) {
                $.ajax({
                    type: 'GET',
                    url: 'loadTalent',
                    data: {
                        index: pageNumber
                    },
                    success: function (data) {
                        var row = document.getElementById("container-list-talent");
                        row.innerHTML = data;
                    }
                });
            }

        </script>
    <div id="paging" class="container ">
        <div class="row pagination-wrap">
            <div class="col-md-6 text-center text-md-left mb-4 mb-md-0">
                <span>Showing 1-${endP} Of ${numberjob} Jobs</span>
            </div>
            <div class="col-md-6 text-center text-md-right">
                <div class="custom-pagination ml-auto">
                    <a href="#" class="prev">Prev</a>
                    <div  class="d-inline-block">

                        <c:forEach begin="1" end="${endP}" var="i">
                            <a href="javascript:void(0);" onclick="handlePaginationClick(${i})" class="active">${i}</a>

                        </c:forEach>
                    </div>
                    <a href="#" class="next">Next</a>
                </div>
            </div>
        </div>
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
