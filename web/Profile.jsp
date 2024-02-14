<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/Header.jsp" %>

<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">

        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center "> 
                                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                                <div class="mt-3">
                                    <h4>${account.name}</h4>
                                    <p class="text-secondary mb-1">Full Stack Developer</p>
                                    <p class="text-muted font-size-sm">Da Nang, Viet Nam</p> 
                                    <button class="btn btn-primary">Follow</button> 
                                    <button class="btn btn-outline-primary">Message</button>
                                </div>
                            </div>
                        </div>

                        <div class="card-footer mt-3">
                            <!-- Your existing code for social media links -->
                        </div>
                    </div>   
                </div>
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Full Name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">${account.name}</div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Email</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">${account.email}</div>
                            </div>
                            <!-- Repeat similar blocks for other profile information -->
                            <!-- ... -->

                            <hr>

                            <div class="row">
                                <div class="col-sm-12">
                                    <a class="btn btn-info" href="ProfileEdit.jsp">Edit</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Your existing code for project status cards -->
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="components/Footer.jsp" %>
