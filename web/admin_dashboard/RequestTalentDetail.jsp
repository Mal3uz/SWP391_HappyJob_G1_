<%-- 
    Document   : RequestTalentDetail
    Created on : Jan 18, 2024, 12:19:36 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>

<!-- App body starts -->
<div class="app-body">

    <!-- Container starts -->
    <div class="container">

        <div class="row">
            <div class="col-lg-8">
                <div class="mb-5">
                    <h2 class="text-primary">${Talent.title}</h2>
                    <div class="col-lg-8 mb-4 mb-lg-0">
                        <div class="d-flex align-items-center">
                            <div class="d-inline-block mr-3">
                                <img src="../images/person_1.jpg" alt="Image" class="rounded-circle me-3" style="height:64px;margin: 5px;">
                            </div>
                            <div>
                                <p class="ml-2 text-primary fs-3">${account.name}</p>
                            </div>
                        </div>
                    </div>
                    <section class="py-5 bg-image overlay-primary fixed overlay d-flex align-items-center justify-content-center" style="background-image: url('../admin_dashboard/assets/images/placeholder.jpg'); height: 50vh;">
                        <img src="${t.img}" alt="Image" class="img-fluid" style="max-height: 100%; max-width: 100%;">
                    </section>
                    <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-align-left mr-3"></span>Job Description</h3>
                    <p>${Talent.description}</p>
                </div>


                <div class="mb-5">
                    <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-rocket mr-3"></span>Responsibilities</h3>
                    <ul class="list-unstyled m-0 p-0">
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Necessitatibus quibusdam facilis</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Velit unde aliquam et voluptas reiciendis n Velit unde aliquam et voluptas reiciendis non sapiente labore</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Commodi quae ipsum quas est itaque</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Deleniti asperiores blanditiis nihil quia officiis dolor</span></li>
                    </ul>
                </div>

                <div class="mb-5">
                    <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-book mr-3"></span>Education + Experience</h3>
                    <ul class="list-unstyled m-0 p-0">
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Necessitatibus quibusdam facilis</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Velit unde aliquam et voluptas reiciendis non sapiente labore</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Commodi quae ipsum quas est itaque</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Deleniti asperiores blanditiis nihil quia officiis dolor</span></li>
                    </ul>
                </div>

                <div class="mb-5">
                    <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-turned_in mr-3"></span>Other Benifits</h3>
                    <ul class="list-unstyled m-0 p-0">
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Necessitatibus quibusdam facilis</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Velit unde aliquam et voluptas reiciendis non sapiente labore</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Commodi quae ipsum quas est itaque</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit</span></li>
                        <li class="d-flex align-items-start mb-2"><span class="icon-check_circle mr-2 text-muted"></span><span>Deleniti asperiores blanditiis nihil quia officiis dolor</span></li>
                    </ul>
                </div>

                <div class="row mb-5">

                    <div class="col-6">

                        <a onclick="showMess('${Talent.talentID}',
                                        'acceptTalent?tid=', '${Talent.title}', '${account.name}', 'accept')"  
                           class="btn btn-block btn-primary btn-md">Accept Talent</a>
                        <a onclick="showMess('${Talent.talentID}',
                                        'rejectTalent?tid=', '${Talent.title}', '${account.name}', 'reject')"  
                           class="btn btn-block btn-danger btn-md">Reject Talent</a>
                    </div>
                </div>

            </div>
            <div class="col-lg-4" >
                <div class="card" style="position: sticky; top: 130px;">
                    <div class="card-header">
                        <nav>
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <button class="nav-link active" id="nav-basic-tab" data-bs-toggle="tab" data-bs-target="#nav-basic" type="button" role="tab" aria-controls="nav-basic" aria-selected="true">Basic</button>
                                <button class="nav-link" id="nav-standard-tab" data-bs-toggle="tab" data-bs-target="#nav-standard" type="button" role="tab" aria-controls="nav-standard" aria-selected="false">Standard</button>
                                <button class="nav-link" id="nav-standard-tab" data-bs-toggle="tab" data-bs-target="#nav-premium" type="button" role="tab" aria-controls="nav-standard" aria-selected="false">Standard</button>
                            </div>
                        </nav>
                    </div>
                    <div class="card-body">
                        <div class="tab-content">
                            <c:forEach items="${service}" var="p" varStatus="status">
                                <c:if test="${p.type == 'Basic'}">
                                    <div class="tab-pane fade show active" id="nav-basic" role="tabpanel" aria-labelledby="nav-basic-tab">
                                        <div class="bg-light p-3 border rounded mb-4">
                                            <div class="mt-3 h5 pl-3 mb-3 d-flex justify-content-between">
                                                <h3 class="text-primary">${p.title}</h3>
                                                <h4>US${p.price}$</h4>
                                            </div>
                                            <ul class="list-unstyled pl-3 mb-0">
                                                <li class="mb-2">${p.description}</li>
                                                <li class="mb-2">
                                                    <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                        <div class="icon-clock" style="color: white"></div>
                                                        <div class="text-white">${p.deadline} Days Delivery</div>
                                                    </strong>
                                                </li>
                                                <li class="mb-2">
                                                    <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                        <div class="icon-repeat"  style="color: white"></div>
                                                        <div class="text-white">${p.revisions} Revisions</div>
                                                    </strong>
                                                </li>
                                            </ul>
                                            <button class="w-100 p-3 bg-dark text-white border-0 rounded-10">Continue</button>
                                        </div>
                                    </div>  
                                </c:if>
                                <c:if test="${p.type == 'Standard'}">
                                    <div class="tab-pane fade" id="nav-standard" role="tabpanel" aria-labelledby="nav-standard-tab">
                                        <div class="bg-light p-3 border rounded mb-4">
                                            <div class="mt-3 h5 pl-3 mb-3 d-flex justify-content-between">
                                                <h3 class="text-primary">${p.title}</h3>
                                                <h4>US${p.price}$</h4>
                                            </div>
                                            <ul class="list-unstyled pl-3 mb-0">
                                                <li class="mb-2">${p.description}</li>
                                                <li class="mb-2">
                                                    <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                        <div class="icon-clock" style="color: white"></div>
                                                        <div class="text-white">${p.deadline} Days Delivery</div>
                                                    </strong>
                                                </li>
                                                <li class="mb-2">
                                                    <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                        <div class="icon-repeat"  style="color: white"></div>
                                                        <div class="text-white">${p.revisions} Revisions</div>
                                                    </strong>
                                                </li>
                                            </ul>
                                            <button class="w-100 p-3 bg-dark text-white border-0 rounded-10">Continue</button>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${p.type == 'Premium'}">
                                    <div class="tab-pane fade" id="nav-premium" role="tabpanel" aria-labelledby="nav-premium-tab">
                                         <div class="bg-light p-3 border rounded mb-4">
                                            <div class="mt-3 h5 pl-3 mb-3 d-flex justify-content-between">
                                                <h3 class="text-primary">${p.title}</h3>
                                                <h4>US${p.price}$</h4>
                                            </div>
                                            <ul class="list-unstyled pl-3 mb-0">
                                                <li class="mb-2">${p.description}</li>
                                                <li class="mb-2">
                                                    <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                        <div class="icon-clock" style="color: white"></div>
                                                        <div class="text-white">${p.deadline} Days Delivery</div>
                                                    </strong>
                                                </li>
                                                <li class="mb-2">
                                                    <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                        <div class="icon-repeat"  style="color: white"></div>
                                                        <div class="text-white">${p.revisions} Revisions</div>
                                                    </strong>
                                                </li>
                                            </ul>
                                            <button class="w-100 p-3 bg-dark text-white border-0 rounded-10">Continue</button>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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

    function showMess(id, url, title, name, key) {
        if (key === "reject") {
            var option = confirm('Are you sure you want to ' + key + ' this talent?\n' +
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
        } else if (key === "accept") {
            var option = confirm('Are you sure you want to ' + key + ' this talent?\n' +
                    'Title: ' + title + '\n' +
                    'Account name: ' + name);
            if (option === true) {
                window.location.href = url + id;
            }
        }
    }


</script>
<%@include file="Footer.jsp" %>
