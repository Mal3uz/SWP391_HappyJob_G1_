<%-- 
    Document   : Login
    Created on : Jan 15, 2024, 7:31:04 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="components/Header.jsp" %>


        <!-- HOME -->
        <section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1 class="text-white font-weight-bold">Login</h1>
                        <div class="custom-breadcrumbs">
                            <a href="#">Home</a> <span class="mx-2 slash">/</span>
                            <span class="text-white"><strong>Log In</strong></span>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="site-section">
            <div class="container">
                <div class="row justify-content-center">

                    <div class="col-lg-6">
                        <h2 class="mb-4 text-center">Log In To HappyJob</h2>
                        <form action="LoginControl" class="p-4 border rounded" method ="post">

                            <div class="row form-group">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="fname">Email</label>
                                    <input type="text" id="fname" name="user" class="form-control" placeholder="Email address">
                                </div>
                            </div>
                            <div class="row form-group mb-4">
                                <div class="col-md-12 mb-3 mb-md-0">
                                    <label class="text-black" for="fname">Password</label>
                                    <input type="password" id="fname" name ="pass" class="form-control" placeholder="Password">
                                </div>
                                <h4 class="text-danger">${mess1}</h4>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-12 d-flex">
                                    <input type="submit" name="action" value="Login" class="btn px-4 btn-primary text-white w-100">
                                </div>
                            </div>


                            <div class="form-group mt-4">
                                <div class="w-100 text-center">
                                    <p class="mb-1">Don't have an account? <a href="SignUp.jsp">Sign Up</a></p>
                                    <p><a href="ForgotPassword.jsp">Forgot Password</a></p>
                                </div>
                            </div>



                        </form>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="components/Footer.jsp" %>

   
