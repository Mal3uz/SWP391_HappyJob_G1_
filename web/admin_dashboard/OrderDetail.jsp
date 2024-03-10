<%-- 
    Document   : OrderDetail
    Created on : Mar 7, 2024, 2:43:20 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>

<!-- App body starts -->
<div class="app-body">

    <!-- Container starts -->
    <div class="container">

        <!-- Row start -->
        <div class="row">
            <div class="col-12 col-xl-6">

                <!-- Breadcrumb start -->
                <ol class="breadcrumb mb-3">
                    <li class="breadcrumb-item">
                        <i class="icon-home lh-1"></i>
                        <a href="index.html" class="text-decoration-none">Home</a>
                    </li>
                    <li class="breadcrumb-item"><a href="product" class="text-decoration-none">List Product</a></li>
                    <li class="breadcrumb-item text-light">Order Detail</li>
                </ol>
                <!-- Breadcrumb end -->
            </div>
        </div>
        <!-- Row end -->

        <!-- Row start -->
        <div class="row">
            <div class="col-xl-12">
                <div class="card">
                    <div class="card-body">
                        <!-- Row start -->
                        <div class="row">
                            <div class="col-sm-3 col-12">

                            </div>
                            <div class="col-sm-9 col-12">
                                <div class="text-end">
                                    <p class="m-0">
                                        Order - <span class="text-danger">#${order.orderID}</span>
                                    </p>
                                    <c:set var="parts" value="${fn:split(order.timestamp, ' ')}" />

                                    <c:set var="date" value="${parts[0]}" />
                                    <c:set var="time" value="${fn:substringBefore(parts[1], '.')}" />
                                    <p class="m-0 font-weight-bold">${date}</p>
                                    <span class="fw-semibold">${time}</span>
                                </div>
                            </div>
                            <div class="col-12 mb-5"></div>
                        </div>
                        <!-- Row end -->

                        <!-- Row start -->
                        <c:set var="seeker" value="${dao.getAccountByOrderId(order.orderID)}" />
                        <div class="row justify-content-between">
                            <div class="col-lg-6 col-12">
                                <h6 class="fw-semibold">Ordered From :</h6>
                                <p class="m-0">
                                    ${seeker.name},<br />
                                    ${seeker.email}<br />
                                </p>
                            </div>
                            <c:set var="provider" value="${dao.getAccountByTalentId(order.talentID)}" />
                            <div class="col-lg-6 col-12">
                                <div class="text-end">
                                    <h6 class="fw-semibold">Ordered To :</h6>
                                    <p class="text-end m-0">
                                        ${provider.name},<br />
                                        ${provider.email}<br />
                                    </p>
                                </div>
                            </div>
                            <div class="col-12 mb-3"></div>
                        </div>
                        <!-- Row end -->

                        <!-- Row start -->
                      
                        <div class="row">
                            <div class="col-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Items</th>
                                                <th>Talent ID</th>
                                                <th>Type</th>
                                                <th>Amount</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="servicePackages" value="${dao.ServicePackagesByOrderId(order.orderID)}" />
                                            <c:forEach var="p" items="${servicePackages}">
                                                <tr>
                                                    <td>
                                                        <h6>${p.title}</h6>
                                                        <p class="text-light">
                                                            ${p.description}
                                                        </p>
                                                    </td>
                                                    <td>
                                                        <h6>#${p.talentID}</h6>
                                                    </td>
                                                    <td>
                                                        <h6>${p.type}</h6>
                                                    </td>
                                                    <td>
                                                        <h6>$${p.price}</h6>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            <tr>
                                                <td colspan="2">&nbsp;</td>
                                                <td>
                                                    <p>Subtotal</p>
                                                    <p>VAT</p>
                                                    <h5 class="mt-4 text-primary">Total USD</h5>
                                                </td>
                                                <td>
                                                    <p>${order.totalPrice}</p>
                                                    <p>$5.00</p>
                                                    <h5 class="mt-4 text-primary">$1015.00</h5>
                                                </td>
                                            </tr>
                                           
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- Row end -->

                    </div>
                </div>
            </div>
        </div>
        <!-- Row end -->

    </div>
    <!-- Container ends -->

</div>
<!-- App body ends -->

<%@include file="Footer.jsp" %>
