<%-- 
    Document   : InvoiceList
    Created on : Jan 17, 2024, 9:45:17 PM
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
                    <li class="breadcrumb-item">Pages</li>
                    <li class="breadcrumb-item text-light">Invoice List</li>
                </ol>
                <!-- Breadcrumb end -->
            </div>
        </div>
        <!-- Row end -->

        <!-- Row start -->
        <div class="row">
            <div class="col-12">
                <div class="card mb-2">
                    <div class="card-header">
                        <div class="d-flex align-items-end justify-content-between">
                            <small class="small opacity-50">Select all checkboxes to send an update.</small>
                            <button class="btn btn-danger">Send to everyone</button>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="border rounded-3">
                            <div class="table-responsive">
                                <table class="table align-middle m-0">
                                    <thead>
                                        <tr>
                                            <th>
                                                <input type="checkbox" class="form-check m-0" />
                                            </th>
                                            <th>#</th>
                                            <th>Date</th>
                                            <th>Name</th>
                                            <th>Gmail</th>
                                            <th>Status</th>
                                            <th>Money Spent</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>                   
                                    <tbody>
                                        <c:forEach var="trs" items="${listT}">
                                            <tr>
                                                <td>
                                                    <input type="checkbox" class="form-check m-0" />
                                                </td>
                                                <td>#${trs.transactionID}</td>
                                                <td>${trs.transactionDate}</td>
                                            <c:set var="account" value="${dao.getAccountByWalletId(trs.transactionID)}" />
                                                <td>
                                                    <div class="fw-semibold">${account.name}</div>
                                                </td>
                                                <td>${account.email}</td>
                                                <td>
                                                    <span class="badge bg-success">${trs.status}</span>
                                                </td>
                                                <td>
                                                    <span class="badge border border-info text-info">${trs.totalPrice}</span>
                                                </td>
                                                <td>
                                                    <a href="invoiceDetail?id=${trs.transactionID}" class="btn btn-primary btn-sm">
                                                       Detail
                                                    </a>
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

    </div>
    <!-- Container ends -->

</div>
<!-- App body ends -->

<!-- App footer start -->
<%@include file="Footer.jsp" %>