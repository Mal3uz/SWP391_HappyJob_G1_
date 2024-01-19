<%-- 
    Document   : BanAccount
    Created on : Jan 17, 2024, 9:36:52 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        <a href="" class="text-decoration-none">Home</a>
                    </li>
                    <li class="breadcrumb-item text-light">Ban Account</li>
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
                            <div class="search-container d-sm-block d-none">
                                <input type="text" class="form-control" placeholder="Search" />
                                <i class="icon-search"></i>
                            </div>
                            <table class="table table-bordered table-striped align-middle m-0">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Date of birthday</th>
                                        <th>Gender</th>
                                        <th>Status</th>
                                        <th>Edit</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="a" items="${account}">
                                        <tr>
                                            <td>${a.accountID}</td>
                                            <th>
                                                <input class="form-check-input" type="checkbox" value="option1" />
                                            </th>
                                            <td>
                                                <img src="assets/images/user2.png" class="me-2 img-3x rounded-3"
                                                     alt="Bootstrap Gallery" />
                                                ${a.name}
                                            </td>
                                            <td>${a.email}</td>
                                            <td>${a.dob}</td>
                                            <td>${a.gender}</td>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <c:if test="${a.status == 'Active'}">
                                                        <span class="badge bg-success"> ${a.status}</span>
                                                    </c:if>
                                                    <c:if test="${a.status == 'Lock'}">
                                                        <span class="badge bg-danger"> ${a.status}</span>
                                                    </c:if>
                                                    <c:if test="${a.status == 'Pending'}">
                                                        <span class="badge bg-info"> ${a.status}</span>
                                                    </c:if>

                                                   

                                                </div>
                                            </td>
                                            <td>
                                               <c:if test="${a.status != 'Pending'}">
                                                <a href="#" onclick="showMess(${a.accountID},'Unlock','unlockAccount?aid=')" >
                                                    <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                            data-bs-title="Unlock">
                                                        <i class="icon-edit"></i>
                                                    </button>
                                                </a>
                                                <a href="#" onclick="showMess(${a.accountID},'Lock','lockAccount?aid=')" >
                                                    <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                            data-bs-title="Lock">
                                                        <i class="icon-trash"></i>
                                                    </button>
                                                </a>
                                               </c:if>
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
<script>
    function showMess(id,text,url) {
        var option = confirm('Are you sure to '+text+' Account ID = ' + id);
        if (option === true) {
            window.location.href = url + id;
        }
    }
    
   
</script>
<!-- App footer start -->
<%@include file="Footer.jsp" %>
