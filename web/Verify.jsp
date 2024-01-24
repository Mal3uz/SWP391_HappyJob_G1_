<%-- 
    Document   : Verify
    Created on : Jan 22, 2024, 4:19:48 PM
    Author     : ASUS
--%>

<%@ page import="java.util.concurrent.TimeUnit" %>

<%@include file="components/Header.jsp" %>
 <style>
      

        .verification-container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        .verification-container h3 {
            color: #1877f2;
        }

        .form-container {
            margin-top: 20px;
        }
    </style>    
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container d-flex justify-content-center">

    <div class="verification-container">
        <h3 class="mt-3">Enter the verification code</h3>
                <p class="mt-3">To confirm your account, enter the 6-digit code we sent to: ${email}</p>
        <c:set var="currentTimeMillis" value="<%= System.currentTimeMillis() %>" scope="session" />


        <div class="form-container">
            <c:choose>
                <c:when test="${currentTimeMillis > sessionScope.time}">
                    <p class="text-danger">Your verification code has expired.</p>
                    <p>Click the button below to resend the verification code:</p>
                    <form action="verify" method="post">
                        <div class="mb-3">
                            <input type="text" id="email" name="email" value="${email}" class="form-control" readonly>
                        </div>
                        <input type="submit" name="action" value="Resend" class="btn btn-primary btn-block">
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="verify" method="post">
                        <div class="mb-3">
                            <input type="text" id="code" name="code" placeholder="Enter Verification Code" required class="form-control">
                        </div>
                        <input type="hidden" name="email" value="${email}">
                        <button type="submit" class="btn btn-success btn-block">Verify</button>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>

        <h4 class="text-danger mt-3">${mess1}</h4>
    </div>
        </div>
</section>

   <%@include file="components/Footer.jsp" %>