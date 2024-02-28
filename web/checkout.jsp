<%-- 
    Document   : checkout
    Created on : Oct 17, 2021, 8:30:31 AM
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
        <title>HappyJob - Checkout Page</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
  

        <!-- CSS 
        ========================= -->
        <!-- Plugins CSS -->
        <link rel="stylesheet" href="css/plugins.css">

        <!-- Main Style CSS -->
        <link rel="stylesheet" href="css/style_1.css">

    </head>

    <body>

        <!-- Main Wrapper Start -->
        <!--Offcanvas menu area start-->
        <div class="off_canvars_overlay"></div>
        <jsp:include page="components/Header.jsp"/>
        <!--breadcrumbs area start-->
        <div class="breadcrumbs_area other_bread">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="breadcrumb_content">
                            <ul>
                                <li><a href="Home.jsp">home</a></li>
                                <li>/</li>
                                <li>checkout</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--breadcrumbs area end-->

        <!--Checkout page section-->
        <div class="Checkout_section" id="accordion">
            <div class="container">
                <div class="checkout_form">

                    <form action="checkout" method="POST">
                        <div class="row">
                            <div class="col-lg-5 col-md-5">
                                <h3>Chi tiết đơn hàng</h3>
                                <div class="row">

                                    <div class="col-lg-12 mb-20">
                                        <label>Tên khách hàng<span>*</span></label>
                                        <input readonly="" value="${sessionScope.user.getName()}" type="text">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label> Email <span>*</span></label>
                                        <input readonly="" value="${sessionScope.user.getEmail()}" type="text">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label>Địa chỉ<span>*</span></label>
                                        <input required name="address" type="text">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label>Số điện thoại<span>*</span></label>
                                        <input required name="phone" type="number">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-7 col-md-7">

                                <h3>Sản phẩm</h3>
                                <div class="order_table table-responsive">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Title</th>
                                                <th>Service Package</th>
                                                <th>Price</th>
                                                <th>Discription</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="o" value="${sessionScope.user}"/>
                                            <c:forEach items="${sessionScope.listPackage}" var="p">
                                                <tr>
                                                    <td><strong>${p.getTitle()}</strong></td>
                                                    <td> ${p.getType()}</td>
                                                    <td> ${p.getPrice()}</td>
                                                    <td> ${p.getDescription()}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <c:if test="${sessionScope.user!=null}">
                                            <tfoot>
                                                <tr>
                                                    <th>Price</th>
                                                    <td>${sessionScope.total}</td>
                                                </tr>
                                                <tr>
                                                    <th>System fees</th>
                                                    <td><strong>${sessionScope.total * 0.05}</strong></td>
                                                </tr>
                                                <tr class="order_total">
                                                    <th>Total</th>
                                                    <td><strong>${sessionScope.total + sessionScope.total * 0.05}</strong></td>
                                                </tr>
                                            </tfoot>
                                        </c:if>
                                    </table>
                                </div>
                                <div class="payment_method">
                                    <div class="panel-default">
                                        <input id="payment_defult" value="momo" name="payment_method" type="radio"
                                               data-target="createp_account" />
                                        <label for="payment_defult" data-toggle="collapse" data-target="#collapsedefult"
                                               aria-controls="collapsedefult">Momo</label>
                                    </div>
                                    <div class="panel-default">
                                        <input id="payment_defult" value="vnpay" name="payment_method" type="radio"
                                               data-target="createp_account" />
                                        <label for="payment_defult" data-toggle="collapse" data-target="#collapsedefult"
                                               aria-controls="collapsedefult">VN Pay</label>
                                    </div>
                                   
                                    <div class="order_button">
                                        <a href="qrcode">Confirm and pay</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--Checkout page section end-->
        <!--footer area start-->
        <jsp:include page="components/Footer.jsp"/>
        <!--footer area end-->

        <!-- JS
============================================ -->

        <!-- Plugins JS -->
        <script src="provider/js/plugins.js"></script>

        <!-- Main JS -->
        <script src="provider/js/main.js"></script>
    </body>

</html>
