<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            /* Add some basic styling for the button */
            #editProfileButton {
                position: absolute;
                top: 10px;
                right: 10px; /* Updated to position at the top right corner */
                padding: 10px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <button id="editProfileButton" onclick="navigateToProfileEdit()">Profile</button>

        <h1>Provider Dashboard</h1>


        <script>
            function navigateToProfileEdit() {
                window.location.href = 'Profile.jsp';
            }
        </script>
    </body>
</html>
