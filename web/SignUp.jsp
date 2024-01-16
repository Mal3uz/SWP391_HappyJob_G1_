<%-- 
    Document   : SignUp
    Created on : Jan 16, 2024, 2:15:50 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                <form action="#" class="p-4 border rounded">

                    <div class="row form-group">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname">Email</label>
                            <input type="text" id="fname" class="form-control" placeholder="Email address">
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname">Password</label>
                            <input type="password" id="fname" class="form-control" placeholder="Password">
                        </div>
                    </div>
                    <div class="row form-group mb-4">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname">Re-Type Password</label>
                            <input type="password" id="fname" class="form-control" placeholder="Re-type Password">
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
