

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Provider Dashboard</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="./provider/css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="Home.jsp"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="images/person_5.jpg" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>${sessionScope.user.getName()}</b></p>
                    <p class="app-sidebar__user-designation">Welcome back</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="dashboard"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Dashboard</span></a></li>
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-user-voice'></i><span
                            class="app-menu__label">Customer Management</span></a></li>
                <li><a class="app-menu__item" href="talentmanager"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Talents Management</span></a>
                </li>
                <li><a class="app-menu__item" href="order"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Hired Management</span></a></li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="row">
                <div class="col-md-12">
                    <div class="app-title">
                        <ul class="app-breadcrumb breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><b>Dashboard</b></a></li>
                        </ul>
                        <div id="clock"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 col-lg-12">
                    <div class="row">
                        <!-- col-6 -->
                        <div class="col-md-6">
                            <div class="widget-small primary coloured-icon"><i class='icon bx bxs-user-account fa-3x'></i>
                                <div class="info">
                                    <h4>Total Incomes</h4>
                                    <p><b>${requestScope.user}$</b></p>
                                    <p class="info-tong">Your incomes when using the system.</p>
                                </div>
                            </div>
                        </div>
                        <!-- col-6 -->
                        <div class="col-md-6">
                            <div class="widget-small info coloured-icon"><i class='icon bx bxs-data fa-3x'></i>
                                <div class="info">
                                    <h4>Total talents</h4>
                                    <p><b>${requestScope.product} talents</b></p>
                                    <p class="info-tong">Total number of talents managed.</p>
                                </div>
                            </div>
                        </div>
                        <!-- col-6 -->
                        <div class="col-md-6">
                            <div class="widget-small warning coloured-icon"><i class='icon bx bxs-shopping-bags fa-3x'></i>
                                <div class="info">
                                    <h4>Total orders</h4>
                                    <p><b>${requestScope.bill} orders</b></p>
                                    <p class="info-tong">Total number of sales invoices for the month.</p>
                                </div>
                            </div>
                        </div>
                        <!-- col-6 -->
                        <div class="col-md-6">
                            <div class="widget-small danger coloured-icon"><i class='icon bx bxs-error-alt fa-3x'></i>
                                <div class="info">
                                    <h4>Deadline approaching</h4>
                                    <p><b>${requestScope.low} talents</b></p>
                                    <p class="info-tong">The number of talents that need to be implemented soon</p>
                                </div>
                            </div>
                        </div>
                                    
                                                                                                                                                                     
                            <div class="col-xl-8 col-lg-7 mt-4">
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
                               
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                        <!-- col-12 -->
                        <div class="col-md-12">
                            <div class="tile">
                                <h3 class="tile-title">Orders Today</h3>
                                <div>
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Price</th>
                                                <th>Service Title</th>
                                                <th>Description</th>            
                                                <th>Talent Title</th>
                                                <th>Revisions</th>
                                                <th>Deadline</th>
                                                <th>Timestamp</th>


                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${items}">
                                                <tr>
                                                    <td>${item.name}</td>
                                                    <td>${item.price}</td>
                                                    <td>${item.titles}</td>
                                                    <td>${item.description}</td>
                                                    <td>${item.titlet}</td>
                                                    <td>${item.revisions}</td>
                                                    <td>${item.deadline}</td>
                                                    <td>${item.timestamp}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- / div trống-->
                            </div>
                        </div>
                        <!-- / col-12 -->
                    </div>
                </div>
            </div>


            <div class="text-center" style="font-size: 13px">
                <p><b>Copyright
                        <script type="text/javascript">
                            document.write(new Date().getFullYear());
                        </script> Happy Job Group 1
                    </b></p>
            </div>
        </main>
        <script src="provider/js/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="provider/js/popper.min.js"></script>
        <script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
        <!--===============================================================================================-->
        <script src="provider/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="provider/js/main.js"></script>
        <!--===============================================================================================-->
        <script src="provider/js/plugins/pace.min.js"></script>
        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/simplebar.min.js"></script>
        <script src="js/apexcharts.min.js"></script>
        <script src="js/feather.min.js"></script>
        <script src="js/app.js"></script>
        <script type="text/javascript">
                            var data = {
                                labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6"],
                                datasets: [{
                                        label: "Dữ liệu đầu tiên",
                                        fillColor: "rgba(255, 213, 59, 0.767), 212, 59)",
                                        strokeColor: "rgb(255, 212, 59)",
                                        pointColor: "rgb(255, 212, 59)",
                                        pointStrokeColor: "rgb(255, 212, 59)",
                                        pointHighlightFill: "rgb(255, 212, 59)",
                                        pointHighlightStroke: "rgb(255, 212, 59)",
                                        data: [20, 59, 90, 51, 56, 100]
                                    },
                                    {
                                        label: "Dữ liệu kế tiếp",
                                        fillColor: "rgba(9, 109, 239, 0.651)  ",
                                        pointColor: "rgb(9, 109, 239)",
                                        strokeColor: "rgb(9, 109, 239)",
                                        pointStrokeColor: "rgb(9, 109, 239)",
                                        pointHighlightFill: "rgb(9, 109, 239)",
                                        pointHighlightStroke: "rgb(9, 109, 239)",
                                        data: [48, 48, 49, 39, 86, 10]
                                    }
                                ]
                            };
                            var ctxl = $("#lineChartDemo").get(0).getContext("2d");
                            var lineChart = new Chart(ctxl).Line(data);

                            var ctxb = $("#barChartDemo").get(0).getContext("2d");
                            var barChart = new Chart(ctxb).Bar(data);
        </script>
        <script type="text/javascript">
            //Thời Gian
            function time() {
                var today = new Date();
                var weekday = new Array(7);
                weekday[0] = "Sunday";
                weekday[1] = "Monday";
                weekday[2] = "Tuesday ";
                weekday[3] = "Wednesday ";
                weekday[4] = "Thursday";
                weekday[5] = "Friday";
                weekday[6] = "Saturday";
                var day = weekday[today.getDay()];
                var dd = today.getDate();
                var mm = today.getMonth() + 1;
                var yyyy = today.getFullYear();
                var h = today.getHours();
                var m = today.getMinutes();
                m = checkTime(m);
                nowTime = h + ":" + m + "";
                if (dd < 10) {
                    dd = '0' + dd
                }
                if (mm < 10) {
                    mm = '0' + mm
                }
                today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                        '</span>';
                document.getElementById("clock").innerHTML = tmp;
                clocktime = setTimeout("time()", "1000", "Javascript");

                function checkTime(i) {
                    if (i < 10) {
                        i = "0" + i;
                    }
                    return i;
                }
            }
        </script>
        
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
    </body>

</html>
