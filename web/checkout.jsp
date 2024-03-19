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

                                <div class="overflow-auto border" style="max-height: 200px;">
                                    <p><span class="font-weight-bolder">TALENTS RENTAL/RENT AGREEMENT ON HAPPYJOB APPLICATION</span><br>
                                        This contract is created by the HappyJob application management team and is valid between the service provider (Provider) and the service user (Seeker) on this platform.<br>
                                        1. Subject of the Contract:<br>
                                        . Seeker is a person who uses HappyJob application to hire services/talent posted by Provider on this platform.<br>
                                        . Provider is the person who provides services/talent to Seeker through the HappyJob application.<br>
                                        2. General Regulations:<br>

                                        Both Provider and Seeker commit to comply with all regulations and terms of this Contract while using the HappyJob application. Any violation of regulations may result in legal action.<br>

                                        3. Payment and Contract Cancellation:<br>

                                        . Seeker commits to paying the service/talent rental fee to the Provider through the HappyJob application.<br>
                                        . In case Seeker cancels the rental contract with Provider, Seeker will be deducted 30% of the amount deposited into the e-wallet on the HappyJob application.<br>
                                        . In case the Provider confirms the provision of services/talent to Seeker but does not do so, the Provider will have 30% of the amount in the e-wallet on the HappyJob application deducted.<br>

                                        4. Validity and Dispute Resolution:<br>

                                        This contract takes effect from the date of publication and lasts until there is a change or cancellation from the HappyJob application creator.<br>
                                        Any disputes arising from this Contract will be resolved through negotiation and conciliation.<br>

                                        5. Declaration and Effect:<br>

                                        This contract takes effect after being published on the HappyJob application and applies to all users.<br>

                                        6. Acceptance and Disclosure:<br>

                                        By using the HappyJob application, both Provider and Seeker agree to comply with and accept the terms of this Agreement.<br>

                                        Announcement Date: September 17, 2024<br>                                  


                                    </p>
                                </div>
                                <span class="text-info "> Accept with all rule of contract </span><input type="checkbox" id="myCheck" onclick="myFunction()">
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
                                        <div class="order_button">
                                            <a id="confirm_and_pay" href="#" onclick="checkAndProceed()">Confirm and pay</a>
                                        </div>
                                       
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
        <script>
            function myFunction() {
                var checkBox = document.getElementById("myCheck");
                var confirmAndPayButton = document.getElementById("confirm_and_pay");

                // Nếu checkbox đã được tích
                if (checkBox.checked === true) {
                    // Hiện nút "Confirm and pay"
                    confirmAndPayButton.style.display = "block";
                } else {
                    // Nếu checkbox chưa được tích, hiện cảnh báo
                    alert("Please read and accept the terms of the contract before proceeding.");
                    // Ẩn nút "Confirm and pay"
                    confirmAndPayButton.style.display = "none";
                }
            }
        </script>
        <script>
            function checkAndProceed() {
                var checkBox = document.getElementById("myCheck");

                // Nếu checkbox đã được tích
                if (checkBox.checked === true) {
                    // Chuyển hướng đến URL mong muốn
                    window.location.href = "qrcode";
                } else {
                    // Nếu checkbox chưa được tích, hiển thị cảnh báo
                    alert("Please read and accept the terms of the contract before proceeding.");
                }
            }
        </script>

    </body>


</html>
