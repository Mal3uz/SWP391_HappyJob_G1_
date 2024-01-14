<%-- 
    Document   : Job
    Created on : Jan 14, 2024, 11:04:33 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>JobEntry - Job Portal Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-xxl bg-white p-0">
            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->


            <!-- Navbar Start -->
            <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                <a href="index.html" class="navbar-brand d-flex align-items-center text-center py-0 px-4 px-lg-5">
                    <h1 class="m-0 text-primary">JobEntry</h1>
                </a>
                <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto p-4 p-lg-0">
                        <a href="index.html" class="nav-item nav-link">Home</a>
                        <a href="about.html" class="nav-item nav-link">About</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown">Jobs</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="job-list.html" class="dropdown-item active">Job List</a>
                                <a href="job-detail.html" class="dropdown-item">Job Detail</a>
                            </div>
                        </div>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="category.html" class="dropdown-item">Job Category</a>
                                <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                <a href="404.html" class="dropdown-item">404</a>
                            </div>
                        </div>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                    </div>
                    <a href="" class="btn btn-primary rounded-0 py-4 px-lg-5 d-none d-lg-block">Post A Job<i class="fa fa-arrow-right ms-3"></i></a>
                </div>
            </nav>
            <!-- Navbar End -->


            <!-- Header End -->
            <div class="container-xxl py-5 bg-dark page-header mb-5">
                <div class="container my-5 pt-5 pb-4">
                    <h1 class="display-3 text-white mb-3 animated slideInDown">Job List</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb text-uppercase">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">Job List</li>
                        </ol>
                    </nav>
                </div>
            </div>
            <!-- Header End -->

            <!-- Package Start -->









            <div class="container-xxl py-5">
                <div class="container">
                    <h1 class="text-center mb-5 wow fadeInUp" data-wow-delay="0.1s">Job Listing</h1>
                    <div class="tab-class text-center wow fadeInUp" data-wow-delay="0.3s">
                        <ul class="nav nav-pills d-inline-flex justify-content-center border-bottom mb-5">
                            <li class="nav-item">
                                <a class="d-flex align-items-center text-start mx-3 ms-0 pb-3 active" data-bs-toggle="pill" href="#tab-1">
                                    <h6 class="mt-n1 mb-0">Featured</h6>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="d-flex align-items-center text-start mx-3 pb-3" data-bs-toggle="pill" href="#tab-2">
                                    <h6 class="mt-n1 mb-0">Full Time</h6>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="d-flex align-items-center text-start mx-3 me-0 pb-3" data-bs-toggle="pill" href="#tab-3">
                                    <h6 class="mt-n1 mb-0">Part Time</h6>
                                </a>
                            </li>
                        </ul>
                        
                          <div class="tab-content">
                        
<!--                        tab-1-->


                        <div id="tab-1" class="tab-pane row g-4 justify-content-center fade show p-0 active d-flex flex-row flex-wrap gap-4">
                          
                             
                              <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                                           <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                                           <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                 
                        
                        </div>



<!--                        tab-2-->
                        <div id="tab-2" class="tab-pane row g-4 justify-content-center fade show p-0 active d-flex flex-row flex-wrap gap-4">
                          
                             
                              <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                                           <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                                           <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                 
                        
                        </div>



<!--                        tab-3-->
                        <div id="tab-3" class="tab-pane row g-4 justify-content-center fade show p-0 active d-flex flex-row flex-wrap gap-4">
                          
                             
                              <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                                           <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                                           <div class="col-lg-3 job-item col-md-6 wow fadeInUp p-4 mb-4" data-wow-delay="0.1s">
                                        <div class="package-item">
                                            <div class="overflow-hidden">
                                                <img class="img-fluid" src="img/package-1.jpg" alt="">
                                            </div>
                                            <div class="d-flex border-bottom">
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i>Thailand</small>
                                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>3 days</small>
                                                <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>2 Person</small>
                                            </div>
                                            <div class="text-center p-4">
                                                <h3 class="mb-0">$149.00</h3>
                                                <div class="mb-3">
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                    <small class="fa fa-star text-primary"></small>
                                                </div>
                                                <p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam eos</p>
                                                <div class="d-flex justify-content-center mb-2">
                                                    <a href="#" class="btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                    <a href="#" class="btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Book Now</a>
                                                </div>
                                          
                                        </div>
                                    </div>
                               
                                
                            </div>
                 
                        
                        </div>

                          </div>
                    </div>
                </div>
                <!-- Package End -->

                <!-- Process Start -->
                <div class="container-xxl py-5">
                    <div class="container">
                        <div class="text-center pb-4 wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="section-title bg-white text-center text-primary px-3">Process</h6>
                            <h1 class="mb-5">3 Easy Steps</h1>
                        </div>
                        <div class="row gy-5 gx-4 justify-content-center">
                            <div class="col-lg-4 col-sm-6 text-center pt-4 wow fadeInUp" data-wow-delay="0.1s">
                                <div class="position-relative border border-primary pt-5 pb-4 px-4">
                                    <div class="d-inline-flex align-items-center justify-content-center bg-primary rounded-circle position-absolute top-0 start-50 translate-middle shadow" style="width: 100px; height: 100px;">
                                        <i class="fa fa-globe fa-3x text-white"></i>
                                    </div>
                                    <h5 class="mt-4">Choose A Destination</h5>
                                    <hr class="w-25 mx-auto bg-primary mb-1">
                                    <hr class="w-50 mx-auto bg-primary mt-0">
                                    <p class="mb-0">Tempor erat elitr rebum clita dolor diam ipsum sit diam amet diam eos erat ipsum et lorem et sit sed stet lorem sit</p>
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 text-center pt-4 wow fadeInUp" data-wow-delay="0.3s">
                                <div class="position-relative border border-primary pt-5 pb-4 px-4">
                                    <div class="d-inline-flex align-items-center justify-content-center bg-primary rounded-circle position-absolute top-0 start-50 translate-middle shadow" style="width: 100px; height: 100px;">
                                        <i class="fa fa-dollar-sign fa-3x text-white"></i>
                                    </div>
                                    <h5 class="mt-4">Pay Online</h5>
                                    <hr class="w-25 mx-auto bg-primary mb-1">
                                    <hr class="w-50 mx-auto bg-primary mt-0">
                                    <p class="mb-0">Tempor erat elitr rebum clita dolor diam ipsum sit diam amet diam eos erat ipsum et lorem et sit sed stet lorem sit</p>
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 text-center pt-4 wow fadeInUp" data-wow-delay="0.5s">
                                <div class="position-relative border border-primary pt-5 pb-4 px-4">
                                    <div class="d-inline-flex align-items-center justify-content-center bg-primary rounded-circle position-absolute top-0 start-50 translate-middle shadow" style="width: 100px; height: 100px;">
                                        <i class="fa fa-plane fa-3x text-white"></i>
                                    </div>
                                    <h5 class="mt-4">Fly Today</h5>
                                    <hr class="w-25 mx-auto bg-primary mb-1">
                                    <hr class="w-50 mx-auto bg-primary mt-0">
                                    <p class="mb-0">Tempor erat elitr rebum clita dolor diam ipsum sit diam amet diam eos erat ipsum et lorem et sit sed stet lorem sit</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Process Start -->


                <!-- Footer Start -->
                <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
                    <div class="container py-5">
                        <div class="row g-5">
                            <div class="col-lg-3 col-md-6">
                                <h4 class="text-white mb-3">Company</h4>
                                <a class="btn btn-link" href="">About Us</a>
                                <a class="btn btn-link" href="">Contact Us</a>
                                <a class="btn btn-link" href="">Privacy Policy</a>
                                <a class="btn btn-link" href="">Terms & Condition</a>
                                <a class="btn btn-link" href="">FAQs & Help</a>
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <h4 class="text-white mb-3">Contact</h4>
                                <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                                <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                                <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                                <div class="d-flex pt-2">
                                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <h4 class="text-white mb-3">Gallery</h4>
                                <div class="row g-2 pt-2">
                                    <div class="col-4">
                                        <img class="img-fluid bg-light p-1" src="img/package-1.jpg" alt="">
                                    </div>
                                    <div class="col-4">
                                        <img class="img-fluid bg-light p-1" src="img/package-2.jpg" alt="">
                                    </div>
                                    <div class="col-4">
                                        <img class="img-fluid bg-light p-1" src="img/package-3.jpg" alt="">
                                    </div>
                                    <div class="col-4">
                                        <img class="img-fluid bg-light p-1" src="img/package-2.jpg" alt="">
                                    </div>
                                    <div class="col-4">
                                        <img class="img-fluid bg-light p-1" src="img/package-3.jpg" alt="">
                                    </div>
                                    <div class="col-4">
                                        <img class="img-fluid bg-light p-1" src="img/package-1.jpg" alt="">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <h4 class="text-white mb-3">Newsletter</h4>
                                <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                                <div class="position-relative mx-auto" style="max-width: 400px;">
                                    <input class="form-control border-primary w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                                    <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="copyright">
                            <div class="row">
                                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                                    &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved.

                                    <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                                    Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                                </div>
                                <div class="col-md-6 text-center text-md-end">
                                    <div class="footer-menu">
                                        <a href="">Home</a>
                                        <a href="">Cookies</a>
                                        <a href="">Help</a>
                                        <a href="">FQAs</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Footer End -->


                <!-- Back to Top -->
                <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


                <!-- JavaScript Libraries -->
                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                <script src="lib/wow/wow.min.js"></script>
                <script src="lib/easing/easing.min.js"></script>
                <script src="lib/waypoints/waypoints.min.js"></script>
                <script src="lib/owlcarousel/owl.carousel.min.js"></script>
                <script src="lib/tempusdominus/js/moment.min.js"></script>
                <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
                <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

                <!-- Template Javascript -->
                <script src="js/main.js"></script>
                </body>

                </html>