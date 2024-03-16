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

        <section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
            <jsp:include page="components/Header.jsp"/>
        </section>
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
                                <h3>Order Detail</h3>
                                <div class="row">

                                    <div class="col-lg-12 mb-20">
                                        <label> Customer Name <span>*</span></label>
                                        <input readonly="" value="${sessionScope.user.getName()}" type="text">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label> Email <span>*</span></label>
                                        <input readonly="" value="${sessionScope.user.getEmail()}" type="text">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label>Address<span>*</span></label>
                                        <input required name="address" type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-7 col-md-7">

                                <h3>Order Detail</h3>
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
                                            <c:forEach items="${listS}" var="p">
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
                                                    <td>${total}</td>
                                                </tr>
                                                <tr>
                                                    <th>System fees</th>
                                                    <td><strong>${total * 0.05}</strong></td>
                                                </tr>
                                                <tr class="order_total">
                                                    <th>Total</th>
                                                    <td><strong>${total * 1.05}</strong></td>
                                                </tr>
                                            </tfoot>
                                        </c:if>
                                    </table>
                                </div>
                                <div class="payment_method">
                                    <div class="panel-default">
                                        <input id="payment_momo" value="momo" name="payment_method" type="radio" data-target="createp_account" />
                                        <label for="payment_momo" data-toggle="collapse" data-target="#collapse_momo" aria-controls="collapse_momo">Momo</label>
                                    </div>
                                    <div class="panel-default">
                                        <input id="payment_wallet" value="wallet" name="payment_method" type="radio" data-target="createp_account" />
                                        <label for="payment_wallet" data-toggle="collapse" data-target="#collapse_wallet" aria-controls="collapse_wallet">Use your account balance</label>
                                    </div>

                                    <div class="order_button">
                                        <a id="confirm_and_pay" href="qrcode">Confirm and pay</a>
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
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var paymentMethodRadios = document.querySelectorAll('input[name="payment_method"]');
                var confirmAndPayLink = document.getElementById("confirm_and_pay");

                paymentMethodRadios.forEach(function (radio) {
                    radio.addEventListener("click", function () {
                        var paymentMethod = this.value;
                        confirmAndPayLink.href = "qrcode?payment_method=" + paymentMethod;
                    });
                });
            });
        </script>
    </body>


</html>
