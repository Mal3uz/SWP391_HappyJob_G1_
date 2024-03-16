<%-- 
    Document   : OrderDetail
    Created on : Mar 13, 2024, 2:42:01 AM
    Author     : DELL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="components/Header.jsp" %>
<!-- HOME -->
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1 class="text-white font-weight-bold">Waiting List</h1>
                <div class="custom-breadcrumbs">
                    <a href="#">Home</a> <span class="mx-2 slash">/</span>
                    <span class="text-white"><strong>Waiting List</strong></span>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="site-section  bg-light">

          <div class="container">

            <!-- Row start -->
            <div class="row">
              <div class="col-xl-12">
                <div class="card bg-dark">
                  <div class="card-body">
                    <!-- Row start -->
                    <div class="row">
                    
                      <div class="col-sm-9 col-12">
                        <div class="text-end">
                          <p class="m-0">
                            Order - <span class="text-danger">#${orderDetail.getOrderID()}</span>
                          </p>
                          <p class="m-0">${orderDetail.getTimestamp()}</p>
                          <span class="badge bg-primary">${orderDetail.getStatus()}</span>
                        </div>
                      </div>
                      <div class="col-12 mb-5"></div>
                    </div>
                    <!-- Row end -->

                    <!-- Row start -->
                   <c:set var="account" value="${adao.getAccountByOrderId(orderDetail.getOrderID())}" />
                    <div class="row justify-content-between">
                      <div class="col-lg-6 col-12">
                        <h6 class="fw-semibold">Order From :</h6>
                        <p class="m-0">
                          ${account.getName()},<br />
                          ${account.getEmail()},<br />
                        </p>
                      </div>
                      <c:set var="accountOftalent" value="${adao.getAccountTalentByOrderId(orderDetail.getOrderID())}" />
                      <div class="col-lg-6 col-12">
                          <div class="text-end" style="float: right;">
                          <h6 class="fw-semibold">Send To :</h6>
                          <p class="text-end m-0">
                            ${accountOftalent.getName()},<br />
                          ${accountOftalent.getEmail()},<br />
                          </p>
                        </div>
                      </div>
                      <div class="col-12 mb-3"></div>
                    </div>
                    <!-- Row end -->

                    <!-- Row start -->
                    <div class="row">
                      <div class="col-12">
                        <div class="table-responsive">
                          <table class="table table-bordered">
                            <thead>
                              <tr>
                                <th>Items</th>
                                <th>Product ID</th>
                                <th>Hours</th>
                                <th>Amount (Net)</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td>
                                  <h6>Bootstrap Admin Template</h6>
                                  <p class="text-light">
                                    Create quality mockups and prototypes and
                                    Design mobile based features.
                                  </p>
                                </td>
                                <td>
                                  <h6>#651</h6>
                                </td>
                                <td>
                                  <h6>40</h6>
                                </td>
                                <td>
                                  <h6>$450.00</h6>
                                </td>
                              </tr>
                              <tr>
                                <td>
                                  <h6>Admin Themes</h6>
                                  <p class="text-light">
                                    Best Bootstrap Admin Dashboards and Admin
                                    Themes
                                  </p>
                                </td>
                                <td>
                                  <h6>#429</h6>
                                </td>
                                <td>
                                  <h6>60</h6>
                                </td>
                                <td>
                                  <h6>$550.00</h6>
                                </td>
                              </tr>
                              <tr>
                                <td colspan="2">&nbsp;</td>
                                <td>
                                  <p>Subtotal</p>
                                  <p>Discount</p>
                                  <p>VAT</p>
                                  <h5 class="mt-4 text-primary">Total USD</h5>
                                </td>
                                <td>
                                  <p>$1000.00</p>
                                  <p>$10.00</p>
                                  <p>$5.00</p>
                                  <h5 class="mt-4 text-primary">$1015.00</h5>
                                </td>
                              </tr>
                              <tr>
                                <td colspan="4">
                                  <h6 class="text-danger">NOTES</h6>
                                  <p class="small text-light m-0">
                                    We really appreciate your business and if
                                    there’s anything else we can do, please let
                                    us know! Also, should you need us to add VAT
                                    or anything else to this order, it’s super
                                    easy since this is a template, so just ask!
                                  </p>
                                </td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                    <!-- Row end -->

                    <!-- Row start -->
                  
                    <!-- Row end -->
                  </div>
                </div>
              </div>
            </div>
            <!-- Row end -->

      

        </div>
</section>


<%@include file="components/Footer.jsp" %>
