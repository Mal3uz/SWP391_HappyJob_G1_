<!--<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/Header.jsp" %>
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-6">
                <h2 class="mb-4 text-center">Change Password</h2>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-sm-6 col-sm-offset-3">
                <p class="text-center" >Use the form below to change your password. Your password cannot be the same as your username.</p>
                <form action="ChangePasswordServlet" method="post" id="passwordForm">
                     <input type="password" class="input-lg form-control" name="password" id="password" placeholder="Old Password" autocomplete="off">
                     <br>
                    <input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="New Password" autocomplete="off">
                    <div class="row">
                        <div class="col-sm-6">
                            <span id="8char" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> 8 Characters Long<br>

                        </div>
                        <div class="col-sm-6">
                            <span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter<br>
                            <span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number
                        </div>
                    </div>
                    <input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Repeat Password" autocomplete="off">
                    <div class="row">
                        <div class="col-sm-12">
                            <span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Passwords Match
                        </div>
                    </div>
                    <input type="submit" class="col-xs-12 btn btn-primary btn-load btn-lg" data-loading-text="Changing Password..." value="Change Password">
                </form>
            </div><!--/col-sm-6-->
        </div><!--/row-->
    </div>

    <!--JS-->
    <script>
        $("input[type=password]").keyup(function () {
            var lcase = new RegExp("[a-z]+");
            var num = new RegExp("[0-9]+");

            if ($("#password1").val().length >= 8) {
                $("#8char").removeClass("glyphicon-remove");
                $("#8char").addClass("glyphicon-ok");
                $("#8char").css("color", "#00A41E");
            } else {
                $("#8char").removeClass("glyphicon-ok");
                $("#8char").addClass("glyphicon-remove");
                $("#8char").css("color", "#FF0004");
            }
            if (lcase.test($("#password1").val())) {
                $("#lcase").removeClass("glyphicon-remove");
                $("#lcase").addClass("glyphicon-ok");
                $("#lcase").css("color", "#00A41E");
            } else {
                $("#lcase").removeClass("glyphicon-ok");
                $("#lcase").addClass("glyphicon-remove");
                $("#lcase").css("color", "#FF0004");
            }

            if (num.test($("#password1").val())) {
                $("#num").removeClass("glyphicon-remove");
                $("#num").addClass("glyphicon-ok");
                $("#num").css("color", "#00A41E");
            } else {
                $("#num").removeClass("glyphicon-ok");
                $("#num").addClass("glyphicon-remove");
                $("#num").css("color", "#FF0004");
            }

            if ($("#password1").val() == $("#password2").val()) {
                $("#pwmatch").removeClass("glyphicon-remove");
                $("#pwmatch").addClass("glyphicon-ok");
                $("#pwmatch").css("color", "#00A41E");
            } else {
                $("#pwmatch").removeClass("glyphicon-ok");
                $("#pwmatch").addClass("glyphicon-remove");
                $("#pwmatch").css("color", "#FF0004");
            }
        });
    </script>
</section>
<%@include file="components/Footer.jsp" %>
