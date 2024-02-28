<%-- 
    Document   : qrcode
    Created on : Nov 3, 2021, 2:01:53 AM
    Author     : Khuong Hung
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Thanh toán</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <!-- CSS 
        ========================= -->
        <!-- Plugins CSS -->
        <link rel="stylesheet" href="css/plugins.css">
        <!-- Main Style CSS -->
        <link rel="stylesheet" href="css/style_1.css">
    </head>

    <body>
        
        <div class="off_canvars_overlay"></div>
  
    <%@include file="components/Header.jsp"%>
        <!--error section area start-->
        <div class="error_section">
            <div class="container">   
                <div class="row">
                    <div class="col-12">
                        <div class="error_form">
                            <h2 class="text-center text-dark">Pay bills: #${packId}!</h2>
                            <h4 class="text-center">Payment amount: ${total} VND</h4>
                            <h4 class="text-center">Please write notes: </h4>
                            <h5 class="text-center" style="color: red">" Pay bills: #${packId} "</h5>
                            <h6 class="text-center">We will check and notify you when payment is complete!</h6>
                            <div class="text-center">
                                <iframe style="align-content: center;"height="650px" width="450px" src="https://nhantien.momo.vn/01242626359/${total}"></iframe>
                            </div>
                            <a href="Home.jsp">Continue hiring</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--error section area end--> 
        <!--footer area start-->
      <%@include file="components/Footer.jsp"%>
        <!--footer area end-->

        <!-- JS
        ============================================ -->


        <!--map js code here-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAdWLY_Y6FL7QGW5vcO3zajUEsrKfQPNzI"></script>
        <script  src="https://www.google.com/jsapi"></script>
        <script src="js/map.js"></script>


        <!-- Plugins JS -->
        <script src="provider/js/plugins.js"></script>

        <!-- Main JS -->
         <script src="provider/js/main.js"></script>



    </body>

</html>