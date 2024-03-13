<%-- 
    Document   : ProfileEdit
    Created on : Jan 16, 2024, 7:07:04 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/Header.jsp" %>

<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="main-body">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <form action="updateProfile" method="POST">
                                <input type="hidden" name="id" value="${account.accountID}">
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Full Name</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" name="name" value="${sessionScope.user.getName()}" class="form-control" >
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary"> 
                                        <input type="text" name="email" value="${sessionScope.user.getEmail()}" class="form-control" readonly>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Dob</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="date" name="dob" value="${sessionScope.user.getDob()}" class="form-control" >
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Gender</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary"> 
                                        <select id="gender" name="gender" class="form-control">
                                            <option value="Male" ${sessionScope.user.getGender() == "Female" ? "" : "selected"}>Male</option>
                                            <option value="Female" ${sessionScope.user.getGender() == "Male" ? "" :"selected" }>Female</option>
                                        </select>
                                    </div>
                                </div>


                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Upload Image</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary"> 
                                        <!--                                     <label class="btn btn-primary btn-md btn-file">
                                                                                    Browse File  <input type="file" name="ProductImgURL" class="form-control"></input>
                                                                                </label>-->
                                        <input type="text" name="imgurl" value="${sessionScope.user.getImg()}" class="form-control" >
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-3">     
                                    </div>
                                    <div class="col-sm-9 text-secondary"> 
                                        <input type="submit" class="btn btn-primary px-4" value="Save Changes">
                                    </div>
                                </div>
                            </form>
                            <h4 class="text-success fw-bolder mt-4">${success}</h4>
                            <h4 class="text-success fw-bolder mt-4">${fail}</h4>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="card">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</section>
<%@include file="components/Footer.jsp" %>