<%-- 
    Document   : InvoiceList
    Created on : Jan 17, 2024, 9:45:17 PM
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
                  <li class="breadcrumb-item text-light">Invoice List</li>
                </ol>
                <!-- Breadcrumb end -->
              </div>
            </div>
            <!-- Row end -->

            <!-- Row start -->
            <div class="row">
              <div class="col-12">
                <div class="card mb-2">
                  <div class="card-header">
                    <div class="d-flex align-items-end justify-content-between">
                      <small class="small opacity-50">Select all checkboxes to send an update.</small>
                      <button class="btn btn-danger">Send to everyone</button>
                    </div>
                  </div>
                  <div class="card-body">
                    <div class="border rounded-3">
                      <div class="table-responsive">
                        <table class="table align-middle m-0">
                          <thead>
                            <tr>
                              <th>
                                <input type="checkbox" class="form-check m-0" />
                              </th>
                              <th>#</th>
                              <th>Date</th>
                              <th>Name</th>
                              <th>Items Bought</th>
                              <th>Status</th>
                              <th>Money Spent</th>
                              <th>Action</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>
                                <input type="checkbox" class="form-check m-0" />
                              </td>
                              <td>#00001</td>
                              <td>20/10/2022</td>
                              <td>
                                <div class="fw-semibold">Elisa Shah</div>
                              </td>
                              <td>2</td>
                              <td>
                                <span class="badge bg-success">Paid</span>
                              </td>
                              <td>
                                <span class="badge border border-info text-info">$4500</span>
                              </td>
                              <td>
                                <button class="btn btn-primary btn-sm">
                                  Send Mail
                                </button>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <input type="checkbox" class="form-check m-0" />
                              </td>
                              <td>#00002</td>
                              <td>12/10/2022</td>
                              <td>
                                <div class="fw-semibold">Ladonna Jones</div>
                              </td>
                              <td>6</td>
                              <td>
                                <span class="badge bg-warning">Pending</span>
                              </td>
                              <td>
                                <span class="badge border border-warning text-warning">$3800</span>
                              </td>
                              <td>
                                <button class="btn btn-primary btn-sm">
                                  Send Mail
                                </button>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <input type="checkbox" class="form-check m-0" />
                              </td>
                              <td>#00003</td>
                              <td>12/10/2022</td>
                              <td>
                                <div class="fw-semibold">Shelly Daniel</div>
                              </td>
                              <td>5</td>
                              <td>
                                <span class="badge bg-success">Paid</span>
                              </td>
                              <td>
                                <span class="badge border border-success text-success">$9800</span>
                              </td>
                              <td>
                                <button class="btn btn-primary btn-sm">
                                  Send Mail
                                </button>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <input type="checkbox" class="form-check m-0" />
                              </td>
                              <td>#00004</td>
                              <td>15/10/2022</td>
                              <td>
                                <div class="fw-semibold">Rich Spears</div>
                              </td>
                              <td>7</td>
                              <td>
                                <span class="badge bg-danger">Overdue</span>
                              </td>
                              <td>
                                <span class="badge border border-danger text-danger">$6200</span>
                              </td>
                              <td>
                                <button class="btn btn-primary btn-sm">
                                  Send Mail
                                </button>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <input type="checkbox" class="form-check m-0" />
                              </td>
                              <td>#00005</td>
                              <td>20/10/2022</td>
                              <td>
                                <div class="fw-semibold">Jewel Alexander</div>
                              </td>
                              <td>8</td>
                              <td>
                                <span class="badge bg-warning">Pending</span>
                              </td>
                              <td>
                                <span class="badge border border-primary text-primary">$7900</span>
                              </td>
                              <td>
                                <button class="btn btn-primary btn-sm">
                                  Send Mail
                                </button>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
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
<%@include file="Footer.jsp" %>