<%-- 
    Document   : Header
    Created on : Jan 15, 2024, 11:06:27 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<jsp:useBean id="CategoryDAOInstance" scope="request" class="dao.CategoryDAO" />
<jsp:useBean id="AdminDAOInstance" scope="request" class="dao.AdminDAO" />
<!DOCTYPE html>
<html>
    <head>

        <title>HappyJob</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link rel="shortcut icon" href="ftco-32x32.png">

        <link rel="stylesheet" href="css/custom-bs.css">
        <link rel="stylesheet" href="css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="css/bootstrap-select.min.css">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/line-icons/style.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/style-of-hoang.css">

        <!-- MAIN CSS -->
        <link rel="stylesheet" href="css/style.css">    
    </head>
    <body id="top">

        <div id="overlayer"></div>

        <div class="loader">
            <div class="spinner-border text-primary" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>


        <div class="site-wrap">

            <div class="site-mobile-menu site-navbar-target">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div> <!-- .site-mobile-menu -->


            <!-- NAVBAR -->
            <header class="site-navbar mt-3">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="site-logo col-6"><a href="#">HappyJob</a></div>

                        <nav class="mx-auto site-navigation">
                            <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
                                <li><a href="Home.jsp" class="nav-link active">Home</a></li>

                                <li class="has-children">
                                    <a href="#">Talent </a>
                                    <ul class="dropdown">
                                        <li><a href="listTalent">Talent Listings</a></li>
                                            <c:if test="${sessionScope.user != null && sessionScope.user.getRoleID() == 3}">

                                            <li><a href="waitingAccept">Waiting List</a></li>
                                            <li><a href="historyOrder">History Order</a></li>

                                        </c:if>
                                        <c:if test="${sessionScope.user != null && sessionScope.user.getRoleID() == 2 }">
                                            <li><a href="dashboard">Dashboard</a></li>                                    
                                            <li><a href="PostTalent.jsp">Post a Talent</a></li>
                                            </c:if>
                                    </ul>
                                </li>

                                <li class="has-children">
                                    <a href="#">Blog</a>

                                    <ul class="dropdown">
                                        <li><a href="About.jsp">About</a></li>
                                        <li><a href="Blog.jsp">Blog Listings</a></li>
                                        <li><a href="PostBlog.jsp">Post a Blog</a></li>
                                    </ul>
                                </li>
                                <li class="has-children">

                                    <c:if test="${sessionScope.user != null}">
                                        <c:set var="number" value="${AdminDAOInstance.getNumberNewNotificationses(sessionScope.user.getAccountID())}" />
                                        <a href="#">Notification <mark class="big swing">${number}</mark></a>
                                        <ul class="dropdown autohiden" style="  position: absolute;left: 50%;transform: translateX(-50%);">
                                            <c:set var="notifications" value="${AdminDAOInstance.getNewNotificationsesByAccount(sessionScope.user.getAccountID())}" />
                                            <c:forEach var="notification" items="${notifications}">
                                                <li>
                                                    <a href="javascript:void(0)" class="dropdown-item">
                                                        <div class="d-flex align-items-start py-2 " style=" white-space: nowrap; overflow: hidden; text-overflow: ellipsis; ">

                                                            <div class="m-0">
                                                                <h6 class="mb-1 fw-semibold">${fn:substring(notification.createdAt, 0, 10)}
                                                                    <span class=" bg-primary badge rounded-pill"> </span>
                                                                </h6>
                                                                <p class="mb-1">${notification.getMessage()}</p>
                                                                <p class="small m-0 opacity-50">${fn:substring(ư.createdAt, 11, 19)}</p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                            </c:forEach>

                                            <div class="d-grid p-3 float-right">
                                                <a href="notification" class="btn btn-outline-primary " >View all</a>
                                            </div>
                                        </ul>

                                    </li>
                                    <li><a href="message">Message</a></li>
                                    </c:if>

                                <c:if test="${sessionScope.user == null}">
                                    <li><a href="Login.jsp">Notification</a></li>
                                    <li><a href="Login.jsp">Message</a></li>

                                </c:if>

                                <li class="has-children">
                                    <a href="#">Category</a>
                                    <ul class="dropdown horizontal-dropdown"> <!-- Add a CSS class -->
                                        <style>
                                            body {
                                                font-family: Arial, sans-serif;
                                                margin: 0;
                                                padding: 0;
                                            }


                                            .horizontal-dropdown {
                                                width: 100vw; /* Set width to 100% of the viewport width */
                                                display: grid;
                                                grid-template-columns: repeat(7, 1fr);
                                                gap: 10px;
                                                background-color: white;
                                                list-style: none;
                                                padding: 0;
                                                margin: 0;
                                                position: relative; /* Set position to relative */
                                                left: -150%; /* Shift to the left by 50% of its own width */
                                                transform: translateX(-50%); /* Center the dropdown */
                                            }



                                            /* Reset padding and margin for parent elements */
                                            body, html {
                                                padding: 0;
                                                margin: 0;
                                            }




                                            .horizontal-dropdown li {
                                                box-sizing: border-box;
                                                white-space: nowrap; /* Tránh ngắn chặn dòng */
                                                padding: 10px;
                                                text-align: center;
                                            }

                                            .horizontal-dropdown li a {
                                                display: block;
                                                text-decoration: none;
                                                color: black;
                                            }
                                        </style>
                                        <c:forEach var="item" items="${CategoryDAOInstance.getListAllCategories()}">
                                            <li class="horizontal-dropdown-column">
                                                <a href="category?id=${item.id}">${item.name}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>

                                <li><a href="Contact.jsp">Contact</a></li>
                            </ul>
                        </nav>

                        <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
                            <div class="ml-auto">
                                <c:if test="${sessionScope.user != null}">
                                    <a href="wallet" class="btn btn-outline-white border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-account_balance_wallet"></span>Wallet</a>
                                </c:if>
                                <c:if test="${sessionScope.user == null}">
                                    <a href="Login.jsp" class="btn btn-primary border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-lock_outline"></span>Log In</a>
                                </c:if>








                                <!--                                profile when login -->
                                <c:if test="${sessionScope.user != null}">
                                    <div class="btn-group">

                                        <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <span class="mr-2 icon-person"></span>${sessionScope.user.getName()}<span class="icon-chevron-down"></span>
                                        </button>
                                        <div class="dropdown-menu">

                                            <a class="dropdown-item" href="Profile.jsp">Profile Details</a>
                                            <a class="dropdown-item" href="wallet"> Balance: ${sessionScope.balance}</a>





                                            <a class="dropdown-item" href="LogoutControl" >Logout</a>
                                        </div>
                                    </div>
                                </c:if>


                            </div>

                        </div>

                    </div>
                </div>
            </header>

</html>
