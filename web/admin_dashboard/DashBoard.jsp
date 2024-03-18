<%-- 
    Document   : DashBoard
    Created on : Jan 18, 2024, 12:49:40 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<div class="app-body">

    <!-- Container starts -->
    <div class="container">

        <!-- Row start -->
        <div class="row">
            <div class="col-12 col-xl-6">

                <!-- Breadcrumb start -->
                <ol class="breadcrumb mb-3">
                    <li class="breadcrumb-item">
                        <i class="icon-house_siding lh-1"></i>
                        <a href="index.html" class="text-decoration-none">Home</a>
                    </li>
                    <li class="breadcrumb-item">Dashboards</li>
                    <li class="breadcrumb-item text-light">Analytics</li>
                </ol>
                <!-- Breadcrumb end -->
            </div>
        </div>
        <!-- Row end -->



        <!-- Row start -->
        <div class="row gx-2">
            <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="icon-user card-title text-center"> Account</h5>
                    </div>
                    <div class="card-body">
                        <div id="liveCallsData"></div>

                        <div class="d-flex justify-content-center gap-4 my-4">
                            <div class="d-flex align-items-center">
                                <i class="icon-user-check me-3"></i> Active
                                <span class="badge rounded-pill bg-primary ms-2">${activeAccount}</span>
                            </div>
                            <div class="d-flex align-items-center">
                                <i class="icon-user-plus me-3"></i> Pending
                                <span class="badge rounded-pill bg-info ms-2">${pendingAccount}</span>
                            </div>
                            <div class="d-flex align-items-center">
                                <i class="icon-user-x me-3"></i> Lock
                                <span class="badge rounded-pill bg-danger ms-2">${LockAccount}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="icon-credit_card card-title text-center"> Talent</h5>
                    </div>
                    <div class="card-body">
                        <div id="agentsLiveData"></div>

                        <div class="d-flex justify-content-center gap-4 my-4">
                            <div class="d-flex align-items-center">
                                Active
                                <span class="badge rounded-pill bg-primary ms-2">${activeTalent}</span>
                            </div>
                            <div class="d-flex align-items-center">
                                Pending
                                <span class="badge rounded-pill bg-info ms-2">${pendingTalent}</span>
                            </div>
                            <div class="d-flex align-items-center">
                                Reject
                                <span class="badge rounded-pill bg-danger ms-2">${rejectTalent}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-4 col-sm-12 col-12">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="icon-shopping_bag card-title text-center"> Order</h5>
                    </div>
                    <div class="card-body">
                        <div id="lticketsPriorityData"></div>

                        <div class="d-flex justify-content-center gap-4 my-4">
                            <div class="d-flex align-items-center">
                                Success
                                <span class="badge rounded-pill bg-primary ms-2">15</span>
                            </div>
                            <div class="d-flex align-items-center">
                                Pending
                                <span class="badge rounded-pill bg-info ms-2">18</span>
                            </div>
                            <div class="d-flex align-items-center">
                                Failed
                                <span class="badge rounded-pill bg-danger ms-2">13</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Row end -->



        <!-- Row start -->
        <div class="row gx-2">
            <div class="col-xl-6 col-lg-12 col-12">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title text-center">Top 5 Account</h5>
                    </div>
                    <div class="card-body">
                        <div class="border rounded-3">
                            <div class="table-responsive">
                                <table class="table align-middle custom-table m-0">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Gender</th>
                                            <th>Successful Orders</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach var="entry" items="${topAccount}" varStatus="status">
                                            <tr>
                                                <td>${status.index}</td>
                                                <td>
                                                    <div class="fw-semibold">${entry.key.getName()}</div>
                                                </td>
                                                <td>
                                                    <div class="fw-semibold">${entry.key.getEmail()}</div>
                                                </td>
                                                <td>
                                                    <div class="fw-semibold">${entry.key.getGender()}</div>
                                                </td>
                                                <td>
                                                    <span class="badge bg-primary">${entry.value}</span>
                                                </td>
                                                <td>
                                                    <div class="starReadOnly1 rating-stars my-2"></div>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-lg-6 col-12">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title text-center">Top 5 Talent</h5>
                    </div>
                    <div class="card-body">
                        <div class="border rounded-3">
                            <div class="table-responsive">
                                <table class="table align-middle custom-table m-0">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Author</th>
                                            <th>Title</th>
                                            <th>Create At</th>
                                            <th>Amount Sold</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="entry" items="${topTalent}" varStatus="status">
                                            <c:set value="${dao.getAccountByTalentId(entry.key.getTalentID())}" var="accountTalent"></c:set>
                                                <tr>
                                                    <td>${status.index}</td>
                                                <td>
                                                    ${accountTalent.name}
                                                </td>
                                                <td>
                                                    <div class="fw-semibold">${entry.key.getTitle()}</div>
                                                </td>                                       
                                                <td>
                                                    <div class="fw-semibold">${entry.key.getCreatedAt()}</div>
                                                </td>
                                                <td>
                                                    <span class="badge bg-primary">${entry.value}</span>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- Row end -->
        <!-- Row start -->
        <div class="row gx-2">
            <div class="col-xl-12 col-lg-12 col-12">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title text-center">Money collect</h5>
                    </div>
                    <div class="card-body">
                        <div class="border rounded-3">
                            <div class="table-responsive">
                                <table class="table align-middle custom-table m-0">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Agent</th>
                                            <th>Tickets</th>
                                            <th>Time Spent</th>
                                            <th>Feedback</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>
                                                <div class="fw-semibold">Elisa Shah</div>
                                            </td>
                                            <td>
                                                <span class="badge bg-primary">54</span>
                                            </td>
                                            <td>
                                                <span class="badge border border-light">2 Hrs 30 Mins</span>
                                            </td>
                                            <td>
                                                <div class="starReadOnly1 rating-stars my-2"></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>
                                                <div class="fw-semibold">Ladonna Jones</div>
                                            </td>
                                            <td>
                                                <span class="badge bg-primary">49</span>
                                            </td>
                                            <td>
                                                <span class="badge border border-light">2 Hrs 21 Mins</span>
                                            </td>
                                            <td>
                                                <div class="starReadOnly2 rating-stars my-2"></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>
                                                <div class="fw-semibold">Jewel Alexander</div>
                                            </td>
                                            <td>
                                                <span class="badge bg-primary">45</span>
                                            </td>
                                            <td>
                                                <span class="badge border border-light">2 Hrs 15 Mins</span>
                                            </td>
                                            <td>
                                                <div class="starReadOnly1 rating-stars my-2"></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>
                                                <div class="fw-semibold">Rich Spears</div>
                                            </td>
                                            <td>
                                                <span class="badge bg-primary">42</span>
                                            </td>
                                            <td>
                                                <span class="badge border border-light">2 Hrs 10 Mins</span>
                                            </td>
                                            <td>
                                                <div class="starReadOnly1 rating-stars my-2"></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td>
                                                <div class="fw-semibold">Shelly Daniel</div>
                                            </td>
                                            <td>
                                                <span class="badge bg-primary">38</span>
                                            </td>
                                            <td>
                                                <span class="badge border border-light">2Hrs 05Mins</span>
                                            </td>
                                            <td>
                                                <div class="starReadOnly1 rating-stars my-2"></div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- Row end -->
    </div>
    <!-- Container ends -->

</div>

<%@include file="Footer.jsp" %>
