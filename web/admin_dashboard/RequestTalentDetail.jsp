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
                    <figure class="mb-5"><img src="assets/images/products/product2.jpg" alt="Image" class="img-fluid rounded"></figure>
                    <h2>${Talent.title}</h2>
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
            <div class="col-lg-4">
                <div class="bg-light p-3 border rounded mb-4">
                    <h3 class="text-primary  mt-3 h5 pl-3 mb-3 ">Job Summary</h3>
                    <ul class="list-unstyled pl-3 mb-0">
                        <li class="mb-2"><strong class="text-primary">Published on:</strong> April 14, 2019</li>
                        <li class="mb-2"><strong class="text-primary">Vacancy:</strong> 20</li>
                        <li class="mb-2"><strong class="text-primary">Employment Status:</strong> Full-time</li>
                        <li class="mb-2"><strong class="text-primary">Experience:</strong> 2 to 3 year(s)</li>
                        <li class="mb-2"><strong class="text-primary">Job Location:</strong> New ork City</li>
                        <li class="mb-2"><strong class="text-primary">Salary:</strong> $60k - $100k</li>
                        <li class="mb-2"><strong class="text-primary">Gender:</strong> Any</li>
                        <li class="mb-2"><strong class="text-primary">Application Deadline:</strong> April 28, 2019</li>
                    </ul>
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
                            <textarea class="form-control" id="rejectReason" rows="3"></textarea>
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
                    $.ajax({
                        url: url + id,
                        type: 'POST',
                        data: {
                            'reason': reason
                        },contentType: 'application/x-www-form-urlencoded', 
                        success: function () {
                            // Close the modal
                            $('#rejectModal').modal('hide');
                            window.location.href =  url + id;

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
