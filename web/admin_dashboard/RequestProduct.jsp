

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
                    <li class="breadcrumb-item text-light">List Product</li>
                </ol>
                <!-- Breadcrumb end -->
            </div>
        </div>
        <!-- Row end -->

        <!-- Row start -->
        <div class="row">
            <div class="col-12">
                <div class="card mb-2">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped align-middle m-0">
                                <thead>
                                    <tr>
                                    <tr>
                                        <th>Account Name</th>
                                        <th>Email</th>
                                        <th>Order Detail</th>
                                        <th>ProductUrl</th>
                                        <th>CreatedAt</th>
                                        <th>Status</th>
                                        <th>Time</th>
                                        <th>Actions</th>
                                    </tr>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="p" items="${listp}" >
                                        <c:set value="${dao.getAccountByProductId(p.productID)}" var="account"></c:set>
                                            <tr>      
                                                <td>${account.name}</td>
                                            <td>${account.email}</td>
                                            <td> <a href="orderDetail?id=${p.orderID}" class="btn btn-primary btn-sm">
                                                    Detail
                                                </a></td>
                                            <td>
                                                ${p.urlProduct}
                                            </td>
                                            <td>${p.timestamp}</td>
                                            <td>
                                                <span class="badge bg-info">${p.status}</span>
                                            </td>
                                            <td>2 mins ago</td>
                                            <td>
                                                <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                        data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                        data-bs-title="Edit">
                                                    <i class="icon-check-circle"></i>
                                                </button>
                                                <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                        data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                        data-bs-title="Delete">
                                                    <i class="icon-trash"></i>
                                                </button>
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
        <!-- Row end -->

    </div>
    <!-- Container ends -->

</div>
<!-- App body ends -->

<!-- App footer start -->
<%@include file="Footer.jsp" %>
