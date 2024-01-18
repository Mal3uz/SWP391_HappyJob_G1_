<%-- 
    Document   : SignUp
    Created on : Jan 16, 2024, 2:15:50 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>JobBoard &mdash; Website Template by Colorlib</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link rel="stylesheet" href="css/custom-bs.css">
        <link rel="stylesheet" href="css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="css/bootstrap-select.min.css">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/line-icons/style.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/quill.snow.css">


        <!-- MAIN CSS -->
        <link rel="stylesheet" href="css/style.css">    
    </head>
    <body id="top">

        <%@include file="components/Header.jsp" %>


        <!-- HOME -->
        <section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1 class="text-white font-weight-bold">Sign Up</h1>
                        <div class="custom-breadcrumbs">
                            <a href="#">Home</a> <span class="mx-2 slash">/</span>
                            <span class="text-white"><strong>Sign Up</strong></span>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="site-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6 mb-5">
                        <h2 class="mb-4 text-center">Sign Up To HappyJob</h2>
                        <form action="RegisterControl" class="p-4 border rounded" method="post">
                            <h4 class="text-danger">${mess1}</h4>
                             <h4 class="text-danger">${mess2}</h4>
                            <div class="row form-group">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="fname">Email</label>
                                    <input type="text" id="fname" name="user" class="form-control" placeholder="Email address">
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="fname">Password</label>
                                    <input type="password" name="pass" id="fname" class="form-control" placeholder="Password">
                                </div>
                            </div>
                            <div class="row form-group mb-4">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="fname">Re-Type Password</label>
                                    <input type="password" name="repass" id="fname" class="form-control" placeholder="Re-type Password">
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="fname">Name</label>
                                    <input type="text" name ="name" id="fname" class="form-control" placeholder="Enter your Name">
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="gender">Gender</label>
                                    <select id="gender" name ="gender" class="form-control">
                                        <option value="" selected disabled>Select Gender</option>
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="dob">Date of Birth</label>
                                    <input type="date" name="dob" id="dob" class="form-control">
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-12 d-flex">
                                    <input type="submit" value="Sign Up" class="btn px-4 btn-primary text-white w-100">
                                </div>
                            </div>

                            <div class="form-group mt-4">
                                <div class="w-100 text-center">
                                    <p class="mb-1">I am already member <a href="Login.jsp">Login Now!</a></p>

                                </div>
                            </div>

                        </form>
                    </div>

                </div>
            </div>
        </section>

        <%@include file="components/Footer.jsp" %>

    </div>

    <!-- SCRIPTS -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/stickyfill.min.js"></script>
    <script src="js/jquery.fancybox.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>

    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/quill.min.js"></script>


    <script src="js/bootstrap-select.min.js"></script>

    <script src="js/custom.js"></script>



</body>
</html>