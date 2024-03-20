<%-- 
    Document   : DashBoard
    Created on : Jan 18, 2024, 12:49:40 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
                                <span class="badge rounded-pill bg-primary ms-2">${orderFinish}</span>
                            </div>
                            <div class="d-flex align-items-center">
                                Pending
                                <span class="badge rounded-pill bg-info ms-2">${orderPending}</span>
                            </div>
                            <div class="d-flex align-items-center">
                                Failed
                                <span class="badge rounded-pill bg-danger ms-2">${orderCancel}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Row end -->
        <div class="row gx-2 mb-5">
            <div class="col-xl-8 col-lg-12 mt-4">
                <div class="card shadow border-0 p-4">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h6 class="align-items-center mb-0">Order statistics</h6>

                    </div>
                    <div id="dashboard" class="apex-chart"></div>
                </div>
            </div>
            
            
              <div class="col-xl-4 col-lg-5 mt-4">
                                <div class="card shadow border-0 p-4">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h6 class="align-items-center mb-0">Revenue</h6>
                                      
                                    </div>
                                    <div id="department" class="apex-chart"></div>
                                </div>
                            </div>
             
        </div>
        
      

        <!-- Row start -->
        <div class="row gx-2 ">
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

        <!-- Row end -->
    </div>
    <!-- Container ends -->

</div>
  <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
   
 <script>
                                                var options1 = {
                                                    series: [{
                                                            name: 'Transactions',
                                                            data: [<c:forEach items="${appointment7day}" var="a">${a.count},</c:forEach>]
                                                        }, {
                                                            name: 'Orders',
                                                            data: [<c:forEach items="${reservation7day}" var="r">${r.count},</c:forEach>]
                                                        }],
                                                    chart: {
                                                        type: 'bar',
                                                        height: 350,
                                                        stacked: true,
                                                        toolbar: {
                                                            show: true
                                                        },
                                                        zoom: {
                                                            enabled: true
                                                        }
                                                    },
                                                    responsive: [{
                                                            breakpoint: 480,
                                                            options: {
                                                                legend: {
                                                                    position: 'bottom',
                                                                    offsetX: -10,
                                                                    offsetY: 0
                                                                }
                                                            }
                                                        }],
                                                    plotOptions: {
                                                        bar: {
                                                            horizontal: false,
                                                            borderRadius: 10
                                                        },
                                                    },
                                                    xaxis: {
                                                        type: 'text',
                                                                categories: [<c:forEach items="${appointment7day}" var="a">'<fmt:formatDate pattern="dd/MM/yyyy" value="${a.date}"/>',</c:forEach>
                                                                ],
                                                    },
                                                    legend: {
                                                        position: 'right',
                                                        offsetY: 40
                                                    },
                                                    fill: {
                                                        opacity: 1
                                                    }
                                                };
                                                var chart1 = new ApexCharts(document.querySelector("#dashboard"), options1);
                                                chart1.render();
            </script>
            
                <script>
            var options2 = {
                series: [${Revenueappointment}, ${Revenuereservation}],
                chart: {
                    width: 450,
                    type: 'pie',
                },

                labels: ['This month', 'Last month'],
                responsive: [{
                        breakpoint: 600,
                        options: {
                            chart: {
                                width: 500
                            },
                            legend: {
                                position: 'bottom'
                            },
                        }
                    }]
            };
            var chart2 = new ApexCharts(document.querySelector("#department"), options2);
            chart2.render();
        </script>
<%@include file="Footer.jsp" %>
