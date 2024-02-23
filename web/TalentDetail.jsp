<%-- 
    Document   : JobDetail
    Created on : Jan 14, 2024, 11:02:16 PM
    Author     : DELL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="components/Header.jsp" %>
<!-- HOME -->
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1 class="text-white font-weight-bold">Product Designer</h1>
                <div class="custom-breadcrumbs">
                    <a href="#">Home</a> <span class="mx-2 slash">/</span>
                    <a href="#">Job</a> <span class="mx-2 slash">/</span>
                    <span class="text-white"><strong>Product Designer</strong></span>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="site-section">
    <div class="container">
        <div class="pl-2 font-weight-bold text-dark" 
             style="font-size: 30px"
             >${talentChoiced.getTitle()}</div>
        <div class="row align-items-center mb-5">
            <div class="col-lg-8 mb-4 mb-lg-0">
                <div class="d-flex align-items-center">
                    <div class="border p-2 d-inline-block mr-3 rounded ">
                        <img src="images/person_2.jpg" alt="Image" class="img-person-talent">
                    </div>
                    <div>
                        <h2>${accountTalent.getName()}</h2>
                        <div>
                            <span class="ml-0 mr-2 mb-2"><span class="icon-briefcase mr-2"></span><span class="text-primary">${accountTalent.getStatus()}</span></span>
                            <span class="m-2"><span class="icon-room mr-2"></span>New York City</span>
                            <span class="m-2"><span class="icon-clock-o mr-2"></span>${accountTalent.getDob()}</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="row">
                    <div class="col-6">
                        <a href="#" class="btn btn-block btn-light btn-md"><span class="icon-heart-o mr-2 text-danger"></span>Save Job</a>
                    </div>
                    <div class="col-6">
                        <a href="#" class="btn btn-block btn-primary btn-md">Apply Now</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8">
                <div class="mb-5">
                    <figure class="mb-5"><img src="${talentChoiced.getImg()}" alt="Image" class="img-fluid rounded img-talent-choiced"></figure>
                    <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-align-left mr-3"></span>Job Description</h3>
                    <p>${talentChoiced.getDescription()}</p>
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
                        <a href="#" class="btn btn-block btn-light btn-md"><span class="icon-heart-o mr-2 text-danger"></span>Save Job</a>
                    </div>
                    <div class="col-6">
                        <a href="#" class="btn btn-block btn-primary btn-md">Apply Now</a>
                    </div>
                </div>
            </div>


            <div class="col-lg-4">
                <nav>
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-basic" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Basic</button>
                        <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-standard" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Standard</button>
                        <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-premium" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">Premium</button>
                        <!--<button class="nav-link" id="nav-disabled-tab" data-bs-toggle="tab" data-bs-target="#nav-disabled" type="button" role="tab" aria-controls="nav-disabled" aria-selected="false" disabled>Disabled</button>-->
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <c:forEach items="${listPackage}" var="p">

                        <c:if test="${p.getType()=='basic'}">
                            <div class="tab-pane fade show active" id="nav-basic" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                                <div class="bg-light p-3 border rounded mb-4">
                                    <div class="mt-3 h5 pl-3 mb-3 d-flex justify-content-between">
                                        <h3 class="text-primary  ">${p.getTitle()}</h3>
                                        <h4>US$${p.getPrice()}</h4>
                                    </div>
                                    <ul class="list-unstyled pl-3 mb-0">
                                        <li class="mb-2">${p.getDescription()}</li>
                                        <li class="mb-2">
                                            <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                <div class="icon-clock-o"></div>
                                                <div>${p.getDeadline()} Days Delivery</div>
                                            </strong>
                                        </li>
                                        <li class="mb-2">
                                            <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                <div class="icon-repeat"></div>
                                                <div>${p.getRevisions()} Revisions</div>
                                            </strong>
                                        </li>
                                    </ul>
                                    <button class="w-100 bg-dark text-white border-0 rounded-10">Continue</button>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${p.getType()=='standard'}">
                            <div class="tab-pane fade show" id="nav-standard" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                                <div class="bg-light p-3 border rounded mb-4">
                                    <div class="mt-3 h5 pl-3 mb-3 d-flex justify-content-between">
                                        <h3 class="text-primary  ">${p.getTitle()}</h3>
                                        <h4>US$${p.getPrice()}</h4>
                                    </div>
                                    <ul class="list-unstyled pl-3 mb-0">
                                        <li class="mb-2">${p.getDescription()}</li>
                                        <li class="mb-2">
                                            <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                <div class="icon-clock-o"></div>
                                                <div>${p.getDeadline()} Days Delivery</div>
                                            </strong>
                                        </li>
                                        <li class="mb-2">
                                            <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                <div class="icon-repeat"></div>
                                                <div>${p.getRevisions()} Revisions</div>
                                            </strong>
                                        </li>
                                    </ul>
                                    <button class="w-100 bg-dark text-white border-0 rounded-10">Continue</button>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${p.getType()=='premium'}">
                            <div class="tab-pane fade show" id="nav-premium" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                                <div class="bg-light p-3 border rounded mb-4">
                                    <div class="mt-3 h5 pl-3 mb-3 d-flex justify-content-between">
                                        <h3 class="text-primary  ">${p.getTitle()}</h3>
                                        <h4>US$${p.getPrice()}</h4>
                                    </div>
                                    <ul class="list-unstyled pl-3 mb-0">
                                        <li class="mb-2">${p.getDescription()}</li>
                                        <li class="mb-2">
                                            <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                <div class="icon-clock-o"></div>
                                                <div>${p.getDeadline()} Days Delivery</div>
                                            </strong>
                                        </li>
                                        <li class="mb-2">
                                            <strong class="text-black d-flex align-items-center" style="gap:5px;">
                                                <div class="icon-repeat"></div>
                                                <div>${p.getRevisions()} Revisions</div>
                                            </strong>
                                        </li>
                                    </ul>
                                    <button class="w-100 bg-dark text-white border-0 rounded-10">Continue</button>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="bg-light p-3 border rounded">
                    <h3 class="text-primary  mt-3 h5 pl-3 mb-3 ">Share</h3>
                    <div class="px-3">
                        <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-facebook"></span></a>
                        <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-twitter"></span></a>
                        <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-linkedin"></span></a>
                        <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-pinterest"></span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</section>


<!--<section class="bg-light pt-5 testimony-full">

    <div class="owl-carousel single-carousel">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 align-self-center text-center text-lg-left">
                    <blockquote>
                        <p>&ldquo;Soluta quasi cum delectus eum facilis recusandae nesciunt molestias accusantium libero dolores repellat id in dolorem laborum ad modi qui at quas dolorum voluptatem voluptatum repudiandae.&rdquo;</p>
                        <p><cite> &mdash; Corey Woods, @Dribbble</cite></p>
                    </blockquote>
                </div>
                <div class="col-lg-6 align-self-end text-center text-lg-right">
                    <img src="images/person_transparent_2.png" alt="Image" class="img-fluid mb-0">
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-lg-6 align-self-center text-center text-lg-left">
                    <blockquote>
                        <p>&ldquo;Soluta quasi cum delectus eum facilis recusandae nesciunt molestias accusantium libero dolores repellat id in dolorem laborum ad modi qui at quas dolorum voluptatem voluptatum repudiandae.&rdquo;</p>
                        <p><cite> &mdash; Chris Peters, @Google</cite></p>
                    </blockquote>
                </div>
                <div class="col-lg-6 align-self-end text-center text-lg-right">
                    <img src="images/person_transparent.png" alt="Image" class="img-fluid mb-0">
                </div>
            </div>
        </div>

    </div>

</section>-->

<section class="pt-5 bg-image overlay-primary fixed overlay" style="background-image: url('images/hero_1.jpg');">
    <div class="container">
        <div class="row">
            <div class="col-md-6 align-self-center text-center text-md-left mb-5 mb-md-0">
                <h2 class="text-white">Get The Mobile Apps</h2>
                <p class="mb-5 lead text-white">Lorem ipsum dolor sit amet consectetur adipisicing elit tempora adipisci impedit.</p>
                <p class="mb-0">
                    <a href="#" class="btn btn-dark btn-md px-4 border-width-2"><span class="icon-apple mr-3"></span>App Store</a>
                    <a href="#" class="btn btn-dark btn-md px-4 border-width-2"><span class="icon-android mr-3"></span>Play Store</a>
                </p>
            </div>
            <div class="col-md-6 ml-auto align-self-end">
                <img src="images/apps.png" alt="Image" class="img-fluid">
            </div>
        </div>
    </div>
</section>

<%@include file="components/Footer.jsp" %>



