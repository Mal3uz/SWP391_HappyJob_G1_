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
                    <div class="col-lg-4">
                        <div class="card">
               <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center"> 
                                <div style="width: 110px; height: 110px; overflow: hidden; border: 2px solid #000; border-radius: 4px;">
                                    <img src="${account.img}" alt="Profile Image" class="" style="width: 100%; height: 100%;">
                                </div>                                <div class="mt-3">
                                    <div>Name:${account.name}</div>
                                    <div>Birthday:${account.dob}</div>
                                    <div>Email:${account.email}</div>
                                    <div>Gender:${account.gender}</div>


                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="card">
                            <div class="card-body">
                                    <form action="profileEdit" method="POST">
                                        <input type="hidden" name="id" value="${account.accountID}">
                                        <div class="row mb-3">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Full Name</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="text" name="name" value="${account.name}" class="form-control" value="Nam Phuong">
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Email</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary"> 
                                                <input type="text" name="email" value="${account.email}" class="form-control" readonly>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Dob</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="date" name="dob" value="${account.dob}" class="form-control" value="076 xxx xxxx">
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Gender</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary"> 
                                                <select id="gender" name="gender" class="form-control">
                                                    <option value="Nam">Nam</option>
                                                    <option value="Nữ">Nữ</option>
                                                </select>
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
                                    <script>
                                document.getElementById("gender").value = "${account.gender}";
                                    </script>
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