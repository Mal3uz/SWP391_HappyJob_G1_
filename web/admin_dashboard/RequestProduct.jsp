

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

                                                <a onclick="showMess('${p.productID}', 'rejectProduct?pid=', '${p.orderID}', '${account.name}', 'reject')"  
                                                   class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></a>


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
<script>

    function showMess(id, url, orderid, name, key) {
        if (key === "reject") {
            var option = confirm('Are you sure you want to ' + key + ' this product?\n' +
                    'Orderid: ' + orderid + '\n' +
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
        } else if (key === "accept") {
            var option = confirm('Are you sure you want to ' + key + ' this product?\n' +
                    'Orderid: ' + orderid + '\n' +
                    'Account name: ' + name);
            if (option === true) {
                window.location.href = url + id;
            }
        }
    }


</script>
<!-- App footer start -->
<%@include file="Footer.jsp" %>
