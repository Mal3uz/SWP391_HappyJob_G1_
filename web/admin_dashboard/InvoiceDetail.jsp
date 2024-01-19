<%-- 
    Document   : InvoiceDetail
    Created on : Jan 17, 2024, 9:46:53 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
        
        <!-- App body starts -->
        <div class="app-body">

          <!-- Container starts -->
          <div class="container">

            <!-- Row start -->
            <div class="row">
              <div class="col-12 col-xl-6">

                <!-- Breadcrumb start -->
                <ol class="breadcrumb mb-3">
                  <li class="breadcrumb-item">
                    <i class="icon-home lh-1"></i>
                    <a href="index.html" class="text-decoration-none">Home</a>
                  </li>
                  <li class="breadcrumb-item">Pages</li>
                  <li class="breadcrumb-item text-light">Invoice Details</li>
                </ol>
                <!-- Breadcrumb end -->
              </div>
            </div>
            <!-- Row end -->

            <!-- Row start -->
            <div class="row">
              <div class="col-xl-12">
                <div class="card">
                  <div class="card-body">
                    <!-- Row start -->
                    <div class="row">
                      <div class="col-sm-3 col-12">
                        <img src="assets/images/logo.svg" alt="Bootstrap Admin Dashboard" class="img-fluid" />
                      </div>
                      <div class="col-sm-9 col-12">
                        <div class="text-end">
                          <p class="m-0">
                            Invoice - <span class="text-danger">#010</span>
                          </p>
                          <p class="m-0">January 20th 2024</p>
                          <span class="badge bg-danger">Overdue</span>
                        </div>
                      </div>
                      <div class="col-12 mb-5"></div>
                    </div>
                    <!-- Row end -->

                    <!-- Row start -->
                    <div class="row justify-content-between">
                      <div class="col-lg-6 col-12">
                        <h6 class="fw-semibold">Billed To :</h6>
                        <p class="m-0">
                          Alice Williams,<br />
                          7500 Oakdale Ave,<br />
                          San Francisco, California(CA), 94500
                        </p>
                      </div>
                      <div class="col-lg-6 col-12">
                        <div class="text-end">
                          <h6 class="fw-semibold">Shipped To :</h6>
                          <p class="text-end m-0">
                            Jumeirah Llc, 9990 St. <br />
                            5000 Church Street, Suite 550<br />
                            Huntsville, Alabama, 99990
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
                    <div class="row">
                      <div class="col-sm-12 col-12">
                        <div class="text-end">
                          <button class="btn btn-light">Download</button>
                          <button class="btn btn-light ms-1">Print</button>
                          <button class="btn btn-primary ms-1">Pay Now</button>
                        </div>
                      </div>
                    </div>
                    <!-- Row end -->
                  </div>
                </div>
              </div>
            </div>
            <!-- Row end -->

          </div>
          <!-- Container ends -->

        </div>
        <!-- App body ends -->

        <!-- App footer start -->
        <div class="app-footer">
          <div class="container">
            <span>© Bootstrap Gallery 2024</span>
          </div>
        </div>
        <!-- App footer end -->

      </div>
      <!-- App container ends -->

    </div>
    <!-- Page wrapper end -->

    <!-- *************
			************ JavaScript Files *************
		************* -->
    <!-- Required jQuery first, then Bootstrap Bundle JS -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>

    <!-- *************
			************ Vendor Js Files *************
		************* -->

    <!-- Overlay Scroll JS -->
    <script src="assets/vendor/overlay-scroll/jquery.overlayScrollbars.min.js"></script>
    <script src="assets/vendor/overlay-scroll/custom-scrollbar.js"></script>

    <!-- Custom JS files -->
    <script src="assets/js/custom.js"></script>
  </body>

</html>