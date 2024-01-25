

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
                            <th></th>
                            <th></th>
                            <th>Request by</th>
                            <th>Email</th>
                            <th>Subject</th>
                            <th>Agent</th>
                            <th>Country</th>
                            <th>Status</th>
                            <th>Last Message</th>
                            <th>Actions</th>
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
                            <td>iPad not working.</td>
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
                          <tr>
                            <td>2</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option2" />
                            </th>
                            <td>Aubrey Tyler</td>
                            <td>info@example.com</td>
                            <td>Mobile is not charging.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Mckinley Peters
                              </div>
                            </td>
                            <td>Germany</td>
                            <td>
                              <span class="badge bg-info">Open</span>
                            </td>
                            <td>3 mins ago</td>
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
                          <tr>
                            <td>3</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option3" />
                            </th>
                            <td>Darren Castillo</td>
                            <td>info@example.com</td>
                            <td>Product damaged.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-danger fs-5"></i>
                                Nelda Zavala
                              </div>
                            </td>
                            <td>Brazil</td>
                            <td>
                              <span class="badge bg-success">Solved</span>
                            </td>
                            <td>3 mins ago</td>
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
                          <tr>
                            <td>4</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option4" />
                            </th>
                            <td>Kendra Pineda</td>
                            <td>info@example.com</td>
                            <td>Coffee mechine is not responding.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Shelby Owen
                              </div>
                            </td>
                            <td>Turkey</td>
                            <td>
                              <span class="badge bg-success">Solved</span>
                            </td>
                            <td>18 mins ago</td>
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
                          <tr>
                            <td>5</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option5" />
                            </th>
                            <td>Tim Carson</td>
                            <td>info@example.com</td>
                            <td>Received damaged charger.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Shelby Owen
                              </div>
                            </td>
                            <td>Turkey</td>
                            <td>
                              <span class="badge bg-dark">Closed</span>
                            </td>
                            <td>25 mins ago</td>
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
                          <tr>
                            <td>6</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option6" />
                            </th>
                            <td>Luann Roberts</td>
                            <td>info@example.com</td>
                            <td>Product date expired.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Fannie Love
                              </div>
                            </td>
                            <td>India</td>
                            <td>
                              <span class="badge bg-info">Open</span>
                            </td>
                            <td>33 mins ago</td>
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
                          <tr>
                            <td>7</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option7" />
                            </th>
                            <td>Jeanie Pineda</td>
                            <td>info@example.com</td>
                            <td>Headphones not working.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Mckinley Peters
                              </div>
                            </td>
                            <td>Australia</td>
                            <td>
                              <span class="badge bg-danger">Pending</span>
                            </td>
                            <td>45 mins ago</td>
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
                          <tr>
                            <td>8</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option8" />
                            </th>
                            <td>Randolph Stanley</td>
                            <td>info@example.com</td>
                            <td>Keyboard issue.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Mckinley Peters
                              </div>
                            </td>
                            <td>Germany</td>
                            <td>
                              <span class="badge bg-info">Open</span>
                            </td>
                            <td>2 hours ago</td>
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
                          <tr>
                            <td>9</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option9" />
                            </th>
                            <td>Maria Harper</td>
                            <td>info@example.com</td>
                            <td>Laptop broken.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-danger fs-5"></i>
                                Nelda Zavala
                              </div>
                            </td>
                            <td>Brazil</td>
                            <td>
                              <span class="badge bg-success">Solved</span>
                            </td>
                            <td>3 hours ago</td>
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
                          <tr>
                            <td>10</td>
                            <th>
                              <input class="form-check-input" type="checkbox" value="option10" />
                            </th>
                            <td>Dominique Rice</td>
                            <td>info@example.com</td>
                            <td>Mobile display issue.</td>
                            <td>
                              <div class="d-flex align-items-center">
                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                Shelby Owen
                              </div>
                            </td>
                            <td>United States</td>
                            <td>
                              <span class="badge bg-success">Solved</span>
                            </td>
                            <td>5 hours ago</td>
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
