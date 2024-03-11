<%-- 
    Document   : ChangePassword
    Created on : Jan 24, 2024, 9:52:43 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <div class="container mt-3">

            <div class="row">
                <br><br>
            </div>

            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-5" id="text">
                    <br><br><br>
                    <h1>Change Your Password</h1>
                    <br><br>

                    <form action="changepass" method="POST">
                        <input type="password" id="pass" name="pass" placeholder="Old Password" class="form-control">
                        <br><br>
                        <input type="password" id="new-pass" name="new-pass" placeholder="Enter new Password" class="form-control">
                        <br><br>
                        <input type="password" id="repeat-new-pass" name="repeat-new-pass" placeholder="Re-enter new Password" class="form-control">
                        <hr>
                        <button class="btn btn-primary btn-block" type="submit" style="width: 200px" id='link2'><i class="fa fa-check-circle"></i>Confirm</button>
                    </form>

                    <br><br>
                    <a href="ProfileControl" id="back">Back to My Profile</a>
                    <br><br>
                </div>

                <div class="col-md-4" id="image">
                    <img style="height: 570px; width: 570px; border-radius: 20px; opacity: 0.7; filter: alpha(opacity=50);" src="resources/pass.jpg" alt=""/>
                </div>

                <div class="col-md-2"></div>
            </div>
        </div>

        <div class="row">
            <br><br>
        </div>
    </body>
</html>
