<%-- 
    Document   : ListTalentActive
    Created on : Jan 23, 2024, 2:14:24 PM
    Author     : DELL
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

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
                    <li class="breadcrumb-item">Active Talent</li>

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
                                        <th></th>
                                        <th></th>
                                        <th>Account Name</th>
                                        <th>Email</th>
                                        <th>Title</th>
                                        <th>Description</th>
                                        <th>CreatedAt</th>
                                        <th>Status</th>
                                        <th>Time</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="t" items="${listTalent}" varStatus='count'>
                                        <tr>
                                            <td>${count.index}</td>
                                            <th>
                                                <input class="form-check-input" type="checkbox" value="option1" />
                                            </th>
                                            <c:set var="account" value="${dao.getAccountByTalentId(String.valueOf(t.talentID))}" />
                                            <td>${account.name}</td>
                                            <td>${account.email}</td>
                                            <td>${t.title}</td>
                                            <td>
                                                <!--                                                <div class="d-flex align-items-center">
                                                                                                    <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                                                    Fannie Love
                                                                                                </div>-->
                                                ${t.description}
                                            </td>
                                            <td>${fn:substring(t.createdAt, 0, 10)}</td>
                                            <td>
                                                <span class="badge bg-success">Active</span>
                                            </td>
                                            <td>${fn:substring(t.createdAt, 10, 19)}</td>
                                            <td>
                                                <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                        data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                        data-bs-title="Delete" onclick="showMess('${t.talentID}', 'deleteTalent?tid=',
                                                                        '${t.title}', '${account.name}')">
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
 <nav aria-label="Page navigation example ">
            <ul class="pagination justify-content-end ">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <!-- Container ends -->
    <!-- Popup Start -->
    <div class="modal" tabindex="-1" role="dialog" id="rejectModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Reject Reason</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="rejectForm">
                        <div class="form-group">
                            <label for="rejectReason">Reason:</label>
                            <textarea class="form-control" id="rejectReason" rows="3" required></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="saveBtn">Save changes</button>
                    <button type="button" class="btn btn-secondary close" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Popup End -->
</div>
<!-- App body ends -->

<!-- App footer start -->
<script>

    function showMess(id, url, title, name) {

        var option = confirm('Are you sure you want to delete this talent?\n' +
                'Title: ' + title + '\n' +
                'Account name: ' + name);
        if (option === true) {
            // Show the modal
            $('#rejectModal').modal('show');
            $('.close').click(function () {
                $('#rejectModal').modal('hide');
            });
            // When the save button is clicked
            $('#saveBtn').click(function () {
                var reason = $('#rejectReason').val();
                if (reason.trim() === "") {
                    alert("Must input reason to continue");
                    return;
                }
                $.ajax({
                    url: url + id,
                    type: 'POST',
                    data: {
                        'reason': reason
                    }, contentType: 'application/x-www-form-urlencoded',
                    success: function () {
                        // Close the modal
                        $('#rejectModal').modal('hide');
                        window.location.href = url + id;

                    }
                });
            });
        }
    }


</script>
<%@include file="Footer.jsp" %>

