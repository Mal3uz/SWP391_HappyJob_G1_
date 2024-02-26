

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
                  <li class="breadcrumb-item">Tickets</li>
                  <li class="breadcrumb-item text-light">All Tickets</li>
                </ol>
                <!-- Breadcrumb end -->
              </div>
            </div>
            <!-- Row end -->

            <!-- Row start -->
            <div class="row">
              <div class="col-12">
                <div class="card mb-2">
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-bordered table-striped align-middle m-0">
                        <thead>
                          <tr>
                             <tr>
                                        <th></th>
                                        <th></th>
                                        <th>Account Name</th>
                                        <th>Email</th>
                                        <th>ProductUrl</th>
                                        <th>CreatedAt</th>
                                        <th>Status</th>
                                        <th>Time</th>
                                        <th>Actions</th>
                                    </tr>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option1" />
                            </th>
                            <td>Araceli Zhang</td>
                            <td>info@example.com</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Fannie Love
                              </div>
                            </td>
                            <td>United States</td>
                            <td>
                              <span class="badge bg-info">Open</span>
                            </td>
                            <td>2 mins ago</td>
                            <td>
                              <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                data-bs-title="Edit">
                                <i class="icon-check-circle"></i>
                              </button>
                              <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                data-bs-title="Delete">
                                <i class="icon-trash"></i>
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
            <!-- Row end -->

          </div>
          <!-- Container ends -->

        </div>
        <!-- App body ends -->

        <!-- App footer start -->
      <%@include file="Footer.jsp" %>
