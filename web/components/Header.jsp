<%-- 
    Document   : Header
    Created on : Jan 15, 2024, 11:06:27 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HappyJob</title>
    </head>
    <body>
         <div id="overlayer"></div>
        <div class="loader">
            <div class="spinner-border text-primary" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>


        <div class="site-wrap">

            <div class="site-mobile-menu site-navbar-target">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div> <!-- .site-mobile-menu -->


            <!-- NAVBAR -->
            <header class="site-navbar mt-3">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="site-logo col-6"><a href="#">HappyJob</a></div>

                        <nav class="mx-auto site-navigation">
                            <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
                                <li><a href="Home.jsp" class="nav-link active">Home</a></li>
                                <li><a href="About.jsp">About</a></li>
                                <li class="has-children">
                                    <a href="#">Talent </a>
                                    <ul class="dropdown">
                                        <li><a href="Talent.jsp">Talent Listings</a></li>
                                        <li><a href="job-single.html">Dashboard</a></li>
                                        <li><a href="PostTalent.jsp">Post a Talent</a></li>
                                    </ul>
                                </li>
                                <li class="has-children">
                                    <a href="services.html">Category</a>
                                    <ul class="dropdown">
                                        <li><a href="services.html">Services</a></li>
                                        <li><a href="service-single.html">Service Single</a></li>
                                        <li><a href="blog-single.html">Blog Single</a></li>
                                        <li><a href="portfolio.html">Portfolio</a></li>
                                        <li><a href="portfolio-single.html">Portfolio Single</a></li>
                                        <li><a href="testimonials.html">Testimonials</a></li>
                                        <li><a href="faq.html">Frequently Ask Questions</a></li>
                                        <li><a href="gallery.html">Gallery</a></li>
                                    </ul>
                                </li>
                                <li class="has-children">
                                    <a href="#">Blog</a>
                                      <ul class="dropdown">
                                        <li><a href="Blog.jsp">Blog Listings</a></li>
                                        <li><a href="PostBlog.jsp">Post a Blog</a></li>
                                    </ul>
                                </li>
                                <li><a href="contact.html">Contact</a></li>
                                <li class="d-lg-none"><a href="post-job.html"><span class="mr-2">+</span> Post a Job</a></li>
                                <li class="d-lg-none"><a href="login.html">Log In</a></li>
                            </ul>
                        </nav>

                        <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
                            <div class="ml-auto">
                                <a href="PostTalent.jsp" class="btn btn-outline-white border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-add"></span>Post a Job</a>
                                <a href="Login.jsp" class="btn btn-primary border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-lock_outline"></span>Log In</a>
                            </div>
                            <a href="#" class="site-menu-toggle js-menu-toggle d-inline-block d-xl-none mt-lg-2 ml-3"><span class="icon-menu h3 m-0 p-0 mt-2"></span></a>
                        </div>

                    </div>
                </div>
            </header>
            
            
    </body>
    
    
</html>
